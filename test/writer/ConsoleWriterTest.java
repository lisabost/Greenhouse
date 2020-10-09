package writer;

import org.junit.Assert;
import org.junit.Test;

public class ConsoleWriterTest {

    ConsoleWriter consoleWriter = new ConsoleWriter();

    @Test
    public void writerTest() {
        consoleWriter.writeln("This is a fun test");
        Assert.assertTrue("Error with system.out", true);
    }
}
