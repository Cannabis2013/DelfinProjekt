package UI.PrintScreen;

import Backend.Contracts.BackendDomain;
import UI.Contracts.PrintScreen;
import UI.Contracts.PrintScreenByDomain;
import UI.Contracts.ReadUserInput;
import UI.ReadUserInput.ConsoleHaltForInput;

public class RegisterCompetitionResultScreen implements PrintScreen {

    private PrintScreen _blankScreen = new PrintBlankScreen();
    private ReadUserInput<String> _halt = new ConsoleHaltForInput();
    @Override
    public void print() {
        _blankScreen.print();
        System.out.println("""
                ------------------------
                Competition result added
                ------------------------
                """);
        _halt.read();
        _blankScreen.print();
    }
}
