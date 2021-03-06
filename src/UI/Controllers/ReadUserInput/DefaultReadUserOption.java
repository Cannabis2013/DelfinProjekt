package UI.Controllers.ReadUserInput;

import UI.Contracts.ClearLines;
import UI.Contracts.PrintScreen;
import UI.Contracts.ReadUserInput;
import UI.Controllers.ConsoleUtils.ClearScrollBuffer;
import UI.Controllers.ConsoleUtils.ConsoleScrollUp;
import UI.Controllers.ConsoleUtils.PrintBlankScreen;

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
                            "[Enter here]:
                            """;
        var formatted = greenFont + cmd + reset;
        System.out.printf(formatted);
    }

    @Override
    public Integer read() {
        var reader = new Scanner(System.in);
        int option;
        while (true){
            printCMD();
            _clearScrollBuffer.print(null);
            var input = reader.nextLine();
            try {
                option = Integer.parseInt(input);
                _printBlankScreen.print(null);
                return option;
            } catch (NumberFormatException e){
                _scrollUp.clear(4);
            }
        }
    }
}
