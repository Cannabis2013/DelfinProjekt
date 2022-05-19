package UI.Controllers;

import Backend.Contracts.BackendDomain;
import Backend.DolphinDomain;
import UI.Contracts.PrintScreen;
import UI.Contracts.PrintScreenByDomain;
import UI.Contracts.ReadUserInput;
import UI.PrintScreen.PrintDolphinWelcomeScreen;
import UI.PrintScreen.PrintExitScreen;
import UI.PrintScreen.PrintMainOptions;
import UI.PrintScreen.PrintMembersInArrears;
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
    private PrintScreenByDomain _printMembersInArreas = new PrintMembersInArrears();

    public void displayUI_delfin() throws InterruptedException {
        _printWelcomeScreen.print();
        while(running) {
            _printMainMenu.print();
            int commandMenu = _readMainMenuOption.read();
            switch (commandMenu) {
                case 1 -> new ChairmanUI(_backend).displayUI_formand();
                case 2 -> _printMembersInArreas.print(_backend);
                case 3 -> new TrainerUI(_backend).run();
                default -> running = _readExitOption.read();
            }
        }
        _backend.save();
        _printExitScreen.print();
    }
}
