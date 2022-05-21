package UI.PrintScreen;

import UI.Contracts.PrintScreen;
import UI.Contracts.ReadUserInput;
import UI.ReadUserInput.ConsoleHaltForInput;

public class PrintMemberNotFoundScreen implements PrintScreen {
    private ReadUserInput<String> _halt = new ConsoleHaltForInput();
    @Override
    public void print() {
        System.out.println("Invalid id");
        _halt.read();
    }
}
