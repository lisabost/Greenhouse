import reader.KeyboardReader;
import reader.Reader;
import writer.ConsoleWriter;
import writer.Writer;


public class Game {

    public static void main(String[] args) {

        Writer screenWriter = new ConsoleWriter();
        Reader keyboardReader = new KeyboardReader();
        Room currentRoom = Hallway.getInstance();

        while(currentRoom != null) {
            screenWriter.writeln(currentRoom.getInteraction());
            String input = keyboardReader.readln();
            currentRoom.onInput(input);
            currentRoom = currentRoom.getNextRoom();
        }

        }
    }

