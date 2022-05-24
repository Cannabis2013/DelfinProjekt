package UI.Controllers.ReadUserInput;

import UI.Contracts.PrintScreen;
import UI.Contracts.ReadUserInput;
import UI.Controllers.PrintScreen.ClearScrollBuffer;
import UI.Controllers.PrintScreen.PrintBlankScreen;

import java.util.Scanner;

public class ReadExitOption implements ReadUserInput<Boolean> {
    private final String greenFont = "\33[32m";
    private final String redFont = "\33[31m";
    private final String reset = "\33[m";
    private final String blink = "\33[6m";
    PrintScreen _clearScrollBuffer = new ClearScrollBuffer();
    PrintScreen _printBlankScreen = new PrintBlankScreen();

    private void printCMD(){
        var text = """
                                                        
                            ----------------------------------------
                            Are you sure, you want to exit - Y/n?
                            ----------------------------------------
                            [Enter here]:  """;
        var msg = redFont + text + reset;
        System.out.print(msg);
    }

    @Override
    public Boolean read() {
        var reader = new Scanner(System.in);
        boolean option;
        while (true){
            printCMD();
            _clearScrollBuffer.print();
            var input = reader.nextLine();
            _printBlankScreen.print();
            return !(input.equals("Y") || input.equals("y"));
        }
    }
}
