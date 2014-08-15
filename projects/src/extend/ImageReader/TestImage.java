  // <Copyright liaoqb>  [Copyright 2014.08.10]
import static org.junit.Assert.*;
import org.junit.Test;

import java.awt.*;
import java.awt.image.*;
import javax.imageio.*;
import java.io.*;
import imagereader.*;

public class TestImage {
  @Test
  public void testBmp1R() throws IOException {
    FileInputStream imageStream = new FileInputStream("bmptest/goal/1_red_goal.bmp");
    FileInputStream imageTestStream = new FileInputStream("bmptest/goal/1_red.bmp");

    BufferedImage image = ImageIO.read(imageStream);
    BufferedImage imageTest = ImageIO.read(imageTestStream);

    assertTrue(image.getHeight() == imageTest.getHeight());
    assertTrue(image.getWidth() == imageTest.getWidth());
    
    for (int i = 0; i < image.getHeight(); ++i) {
      for (int j = 0; j < image.getWidth(); ++j) {
        assertTrue(image.getRGB(i, j) == imageTest.getRGB(i, j));
      }
    }
  }

  @Test
  public void testBmp1G() throws IOException {
    FileInputStream imageStream = new FileInputStream("bmptest/goal/1_green_goal.bmp");
    FileInputStream imageTestStream = new FileInputStream("bmptest/goal/1_green.bmp");

    BufferedImage image = ImageIO.read(imageStream);
    BufferedImage imageTest = ImageIO.read(imageTestStream);

    assertTrue(image.getHeight() == imageTest.getHeight());
    assertTrue(image.getWidth() == imageTest.getWidth());
    
    for (int i = 0; i < image.getHeight(); ++i) {
      for (int j = 0; j < image.getWidth(); ++j) {
        assertTrue(image.getRGB(i, j) == imageTest.getRGB(i, j));
      }
    }
  }

  @Test
  public void testBmp1B() throws IOException {
    FileInputStream imageStream = new FileInputStream("bmptest/goal/1_blue_goal.bmp");
    FileInputStream imageTestStream = new FileInputStream("bmptest/goal/1_blue.bmp");

    BufferedImage image = ImageIO.read(imageStream);
    BufferedImage imageTest = ImageIO.read(imageTestStream);

    assertTrue(image.getHeight() == imageTest.getHeight());
    assertTrue(image.getWidth() == imageTest.getWidth());
    
    for (int i = 0; i < image.getHeight(); ++i) {
      for (int j = 0; j < image.getWidth(); ++j) {
        assertTrue(image.getRGB(i, j) == imageTest.getRGB(i, j));
      }
    }
  }

  @Test
  public void testBmp1Gray() throws IOException {
    FileInputStream imageStream = new FileInputStream("bmptest/goal/1_gray_goal.bmp");
    FileInputStream imageTestStream = new FileInputStream("bmptest/goal/1_gray.bmp");

    BufferedImage image = ImageIO.read(imageStream);
    BufferedImage imageTest = ImageIO.read(imageTestStream);

    assertTrue(image.getHeight() == imageTest.getHeight());
    assertTrue(image.getWidth() == imageTest.getWidth());
    
    for (int i = 0; i < image.getHeight(); ++i) {
      for (int j = 0; j < image.getWidth(); ++j) {
        assertTrue(image.getRGB(i, j) == imageTest.getRGB(i, j));
      }
    }
  }

  @Test
  public void testBmp2R() throws IOException {
    FileInputStream imageStream = new FileInputStream("bmptest/goal/2_red_goal.bmp");
    FileInputStream imageTestStream = new FileInputStream("bmptest/goal/2_red.bmp");

    BufferedImage image = ImageIO.read(imageStream);
    BufferedImage imageTest = ImageIO.read(imageTestStream);

    assertTrue(image.getHeight() == imageTest.getHeight());
    assertTrue(image.getWidth() == imageTest.getWidth());
    
    for (int i = 0; i < image.getWidth(); ++i) {
      for (int j = 0; j < image.getHeight(); ++j) {
        assertTrue(image.getRGB(i, j) == imageTest.getRGB(i, j));
      }
    }
  }

  @Test
  public void testBmp2G() throws IOException {
    FileInputStream imageStream = new FileInputStream("bmptest/goal/2_green_goal.bmp");
    FileInputStream imageTestStream = new FileInputStream("bmptest/goal/2_green.bmp");

    BufferedImage image = ImageIO.read(imageStream);
    BufferedImage imageTest = ImageIO.read(imageTestStream);

    assertTrue(image.getHeight() == imageTest.getHeight());
    assertTrue(image.getWidth() == imageTest.getWidth());
    
    for (int i = 0; i < image.getWidth(); ++i) {
      for (int j = 0; j < image.getHeight(); ++j) {
        assertTrue(image.getRGB(i, j) == imageTest.getRGB(i, j));
      }
    }
  }

  @Test
  public void testBmp2B() throws IOException {
    FileInputStream imageStream = new FileInputStream("bmptest/goal/2_blue_goal.bmp");
    FileInputStream imageTestStream = new FileInputStream("bmptest/goal/2_blue.bmp");

    BufferedImage image = ImageIO.read(imageStream);
    BufferedImage imageTest = ImageIO.read(imageTestStream);

    assertTrue(image.getHeight() == imageTest.getHeight());
    assertTrue(image.getWidth() == imageTest.getWidth());
    
    for (int i = 0; i < image.getWidth(); ++i) {
      for (int j = 0; j < image.getHeight(); ++j) {
        assertTrue(image.getRGB(i, j) == imageTest.getRGB(i, j));
      }
    }  
  }

  @Test
  public void testBmp2Gray() throws IOException {
    FileInputStream imageStream = new FileInputStream("bmptest/goal/2_gray_goal.bmp");
    FileInputStream imageTestStream = new FileInputStream("bmptest/goal/2_gray.bmp");

    BufferedImage image = ImageIO.read(imageStream);
    BufferedImage imageTest = ImageIO.read(imageTestStream);

    assertTrue(image.getHeight() == imageTest.getHeight());
    assertTrue(image.getWidth() == imageTest.getWidth());
    
    for (int i = 0; i < image.getWidth(); ++i) {
      for (int j = 0; j < image.getHeight(); ++j) {
        assertTrue(image.getRGB(i, j) == imageTest.getRGB(i, j));
      }
    }  
  }
}
