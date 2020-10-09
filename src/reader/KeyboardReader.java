package reader;


import java.util.Scanner;

public class KeyboardReader implements Reader {
    @Override
    public String readln() {
        Scanner input = new Scanner(System.in);
        return input.nextLine();
    }
}
