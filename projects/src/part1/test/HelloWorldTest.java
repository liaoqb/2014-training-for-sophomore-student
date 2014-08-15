import static org.junit.Assert.*;
import org.junit.Test;

public class HelloWorldTest {
  private HelloWorld helloworld = new HelloWorld();

  @Test
  public void testHello() {
    helloworld.hello();
    assertEquals("Hello World!", helloworld.getStr());
  }
}
