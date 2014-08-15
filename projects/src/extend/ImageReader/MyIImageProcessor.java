  // <Copyright liaoqb>  [Copyright 2014.08.07]
  // This is the bitmap, I don't know how to do
import imagereader.IImageProcessor;
import java.awt.image.*;
import java.awt.*;

public class MyIImageProcessor implements IImageProcessor {
  public Image showChanelR(Image image) {
    Image RImage = Toolkit.getDefaultToolkit().createImage(
        new FilteredImageSource(image.getSource(), new RGBImageFilter() {
          public int filterRGB(int x, int y, int rgb) {
              // filter red
            return (rgb & 0xffff0000);  
          }        
        }));

    return RImage;
  }

  public Image showChanelG(Image image) {
    Image GImage = Toolkit.getDefaultToolkit().createImage(
        new FilteredImageSource(image.getSource(), new RGBImageFilter() {
          public int filterRGB(int x, int y, int rgb) {
              // filter green
            return (rgb & 0xff00ff00);
          }
        }));

    return GImage;
  }

  public Image showChanelB(Image image) {
    Image BImage = Toolkit.getDefaultToolkit().createImage(
        new FilteredImageSource(image.getSource(), new RGBImageFilter() {
          public int filterRGB(int x, int y, int rgb) {
            return (rgb & 0xff0000ff);
          }
        }));

    return BImage;
  }

  public Image showGray(Image image) {
    Image grayImage = Toolkit.getDefaultToolkit().createImage(
        new FilteredImageSource(image.getSource(), new RGBImageFilter() {
          public int filterRGB(int x, int y, int rgb) {
            int r = (rgb & 0x00ff0000) >> 16;
            int g = (rgb & 0x0000ff00) >> 8;
            int b = rgb & 0x000000ff;

            int gray = (int)((double)r * 0.299 + (double)g * 0.587 + (double)b * 0.114);

            return (rgb & 0xff000000) + (gray << 16) + (gray << 8) + gray;
          }
        }));

    return grayImage;    
  }
}
