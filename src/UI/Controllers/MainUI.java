package UI.Controllers;

import Backend.Contracts.BackendDomain;
import Backend.DolphinDomain;
import UI.Contracts.PrintScreen;
import UI.Contracts.ReadUserInput;
import UI.PrintScreen.PrintDolphinWelcomeScreen;
import UI.PrintScreen.PrintExitScreen;
import UI.PrintScreen.PrintMainOptions;
import UI.ReadUserInput.ReadExitOption;
import UI.ReadUserInput.ReadMainMenuOption;

public class MainUI {
    protected BackendDomain _backend = new DolphinDomain();
    boolean running = true;
    private PrintScreen _printWelcomeScreen = new PrintDolphinWelcomeScreen();
    private PrintScreen _printMainMenu = new PrintMainOptions();
    private PrintScreen _printExitScreen = new PrintExitScreen();
    private ReadUserInput<Integer> _readMainMenuOption = new ReadMainMenuOption();
    private ReadUserInput<Boolean> _readExitOption = new ReadExitOption();

    public void displayUI_delfin() throws InterruptedException {
        _printWelcomeScreen.print();
        while(running) {
            _printMainMenu.print();
            int commandMenu = _readMainMenuOption.read();
            switch (commandMenu) {
                case 1 -> new ChairmanUI().displayUI_formand();
                default -> running = _readExitOption.read();
            }
        }
        _printExitScreen.print();
    }
}
