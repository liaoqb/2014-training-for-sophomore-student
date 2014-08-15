  javac -classpath .:ImageReader.jar MyIImageIO.java
  javac -classpath .:ImageReader.jar MyIImageProcessor.java
  javac -classpath .:ImageReader.jar MyImageRunner.java
  javac -classpath .:ImageReader.jar:junit-4.9.jar TestImage.java
  java -classpath .:ImageReader.jar:junit-4.9.jar -ea org.junit.runner.JUnitCore TestImage
  #java -classpath .:ImageReader.jar MyImageRunner
