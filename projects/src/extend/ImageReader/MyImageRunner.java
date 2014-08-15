  // <Copyrright liaoqb>  [Copyright 2014.08.07]
  // This is the runner
import imagereader.Runner;

public final class MyImageRunner {
  private MyImageRunner() {}

  public static void main(String[] args) {
    MyIImageIO imageIO = new MyIImageIO();
    MyIImageProcessor imageProcessor = new MyIImageProcessor();

    Runner.run(imageIO, imageProcessor);
  }
}
