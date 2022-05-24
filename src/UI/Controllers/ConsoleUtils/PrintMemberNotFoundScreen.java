package UI.Controllers.ConsoleUtils;

import Backend.Contracts.BackendDomain;
import UI.Contracts.PrintScreen;
import UI.Contracts.ReadUserInput;
import UI.Controllers.ReadUserInput.ConsoleHaltForInput;

public class PrintMemberNotFoundScreen implements PrintScreen {
    private ReadUserInput<String> _halt = new ConsoleHaltForInput();
    private PrintScreen _printBlank = new PrintBlankScreen();
    private PrintScreen _clearBuffer = new ClearScrollBuffer();
    @Override
    public void print(BackendDomain domain) {
        System.out.println("Invalid id");
        _halt.read();
        _printBlank.print(null);
        _clearBuffer.print(null);
    }
}
