package UI.PrintScreen;

import UI.Contracts.PrintScreen;
import UI.Contracts.ReadUserInput;
import UI.ReadUserInput.ConsoleHaltForInput;

public class PrintMemberCreatedScreen implements PrintScreen {
    private PrintScreen _blankScreen = new PrintBlankScreen();
    private ReadUserInput<String> _halt = new ConsoleHaltForInput();
    @Override
    public void print() {
        _blankScreen.print();
        System.out.println("""
                --------------
                Member created
                --------------
                """);
        _halt.read();
        _blankScreen.print();
    }
}
