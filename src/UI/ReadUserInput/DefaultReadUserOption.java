package UI.ReadUserInput;

import UI.ConsoleManipulation.ConsoleScrollUp;
import UI.Contracts.ClearLines;
import UI.Contracts.PrintScreen;
import UI.Contracts.ReadUserInput;
import UI.PrintScreen.ClearScrollBuffer;
import UI.PrintScreen.PrintBlankScreen;

import java.util.Scanner;

public class DefaultReadUserOption implements ReadUserInput<Integer> {
    private final String greenFont = "\33[32m";
    private final String redFont = "\33[31m";
    private final String reset = "\33[m";
    private final String blink = "\33[6m";
    PrintScreen _clearScrollBuffer = new ClearScrollBuffer();
    PrintScreen _printBlankScreen = new PrintBlankScreen();
    ClearLines _scrollUp = new ConsoleScrollUp();

    private void printCMD(){
        var cmd = """
                            -----------------------------
                            Choose a Number & Press Enter
                            -----------------------------
                            """;
        cmd += "[Enter here]: ";
        var formatted = greenFont + cmd + reset;
        System.out.printf(formatted);
    }

    private void printBadInputMessage(){
        var msg = blink + redFont + "Bad input. Try again.\n" + reset;
        System.out.println(msg);
    }

    @Override
    public Integer read() {
        var reader = new Scanner(System.in);
        int option;
        while (true){
            printCMD();
            _clearScrollBuffer.print();
            var input = reader.nextLine();
            try {
                option = Integer.parseInt(input);
                _printBlankScreen.print();
                return option;
            } catch (NumberFormatException e){
                _scrollUp.clear(4);
            }
        }

    }
}
