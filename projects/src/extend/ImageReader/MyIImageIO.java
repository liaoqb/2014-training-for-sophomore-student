  // <Copyright liaoqb>  [Copyright 2014.08.06]
  // This is the bitmap, I don't know how to do
  //
    /*
    int bitMapHeadLength = 14;
    int bitMapMessageLength = 40;

    byte[] bitMapHead = new byte[bitMapHeadLength];
    byte[] bitMapMessage = new byte[bitMapMessageLength];

    fin.read(bitMapHead, 0, bitMapHeadLength);
    fin.read(bitMapMessage, 0, bitMapMessage);

    int bitMapFileSize = ((int)bitMapHead[2] & CMP) | (((int)bitMapHead[3] & CMP) << 8) |
      (((int)bitMapHead[4] & CMP) << 16) | (((int)bitMapHead[5] & CMP) << 24);

    int offset = ((int)bitMapHead[10] & CMP) | (((int)bitMapHead[11] & CMP) << 8) |
      (((int)bitMapHead[12] & CMP) << 16) | (((int)bitMapHead[13] & CMP) << 24);
    */
import java.awt.*;
import java.awt.image.*;
import javax.imageio.*;
import java.io.*;
import imagereader.*;

public class MyIImageIO implements IImageIO {
  private final static int CMP = 0xff;

  private int getInt(FileInputStream fin) throws IOException {
    byte[] intArray = new byte[4];

    fin.read(intArray, 0, 4);

    int intNumber = ((int)intArray[0] & CMP) | (((int)intArray[1] & CMP) << 8) |
      (((int)intArray[2] & CMP) << 16) | (((int)intArray[3] & CMP) << 24);

    return intNumber;
  }

  private int getShort(FileInputStream fin) throws IOException {
    byte[] shortArray = new byte[2];

    fin.read(shortArray, 0, 2);

    int shortNumber = ((int)shortArray[0] & CMP) | (((int)shortArray[1] & CMP) << 8);

    return shortNumber;    
  }

    // inner class for file message
  class BitMapFileHead {
    public int bfType;
    public int bfSize;
    public int bfReserved1;
    public int bfReserved2;
    public int ofOffBits;

    public BitMapFileHead(FileInputStream fin) {
      try {
      this.bfType = getShort(fin);
      this.bfSize = getInt(fin);

      this.bfReserved1 = getInt(fin);
      this.bfReserved2 = 0;

      this.ofOffBits = getInt(fin);
      } catch(IOException exception) {
          // This should be added
        exception.printStackTrace();
      }
    }
  }

    // inner class for bitmap message
  class BitMapInfoHeader {
    public int biSize;
    public int biWidth;
    public int biHeight;
    public int biPlanes;
    public int biBitCount;
    public int biCompression;
    public int biSizeImage;
    public int biXPelsPerMeter;
    public int biYPelsPerMeter;
    public int biClrUsed;
    public int biClrImportant;

      // This array will store the message of the bitMap;
    public int mapArray[];

    public BitMapInfoHeader(FileInputStream fin) {
      try {
        this.biSize = getInt(fin);
        this.biWidth = getInt(fin);
        this.biHeight = getInt(fin);
        this.biPlanes = getShort(fin);
        this.biBitCount = getShort(fin);
        this.biCompression = getInt(fin);
        this.biSizeImage = getInt(fin);
        this.biXPelsPerMeter = getInt(fin);
        this.biYPelsPerMeter = getInt(fin);
        this.biClrUsed = getInt(fin);
        this.biClrImportant = getInt(fin);
        // This is only for 24, not others
        if (this.biBitCount == 24) {
          // the px is 3 bits, but we store 4 bits, we should deal with them
          int biPad = (int)((this.biSizeImage / this.biHeight) - (this.biWidth * 3)) % 4;
          mapArray = new int[this.biHeight * this.biWidth];
          byte[] rgb = new byte[this.biSizeImage];

          // read the color edit
          fin.read(rgb, 0, this.biSizeImage);

          int find = 0;

          for (int i = 0; i < this.biHeight; ++i) {
            for (int j = 0; j < this.biWidth; ++j) {
              mapArray[this.biWidth * (this.biHeight - i - 1) + j] =
                ((int)rgb[find] & CMP) | (((int)rgb[find + 1] & CMP) << 8) |
                (((int)rgb[find + 2] & CMP) << 16) | ((255 & CMP) << 24);

              find += 3;
            }

            find += biPad;
          }
        }
      } catch (IOException exception) {
        exception.printStackTrace();
      }
    }
  }

  public Image myRead(String file) throws IOException {
    FileInputStream fin = new FileInputStream(file);
    BitMapFileHead bitMapFileHead = new BitMapFileHead(fin);
    BitMapInfoHeader bitMapInfoHeader = new BitMapInfoHeader(fin);

    Image image = Toolkit.getDefaultToolkit().createImage(new MemoryImageSource(
        bitMapInfoHeader.biWidth, bitMapInfoHeader.biHeight, bitMapInfoHeader.mapArray, 0, bitMapInfoHeader.biWidth));

    fin.close();

    return image;
  }

  public Image myWrite(Image image, String file) throws IOException {
    File createImage = new File(file + ".bmp");

    BufferedImage bufferImage = new BufferedImage(image.getWidth(null), image.getHeight(null), BufferedImage.TYPE_INT_RGB);
    Graphics graphics = bufferImage.getGraphics();
        // draw Image to the panel
    graphics.drawImage(image, 0, 0, null);
      // dispose it
    graphics.dispose();

      // write it to the file
    ImageIO.write(bufferImage, "bmp", createImage);

    return image;
  }
}
