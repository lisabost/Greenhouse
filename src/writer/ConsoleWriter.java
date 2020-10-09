package writer;

/**
 * this is an implementation of the Writer interface that writes lines to the console
 */
public class ConsoleWriter implements Writer {
    @Override
    public void writeln(String line) {
        System.out.println(line);
    }
}
