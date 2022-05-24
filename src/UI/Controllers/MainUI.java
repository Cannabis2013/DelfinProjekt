package UI.Controllers;

import Backend.Contracts.BackendDomain;
import Backend.DolphinDomain;
import UI.Contracts.Controller;
import UI.Contracts.PrintScreen;
import UI.Contracts.PrintScreenByDomain;
import UI.Contracts.ReadUserInput;
import UI.Controllers.PrintScreen.PrintDolphinWelcomeScreen;
import UI.Controllers.PrintScreen.PrintExitScreen;
import UI.Controllers.PrintScreen.PrintMainOptions;
import UI.Controllers.PrintScreen.PrintMembersInArrears;
import UI.ReadUserInput.DefaultReadUserOption;
import UI.ReadUserInput.ReadExitOption;

public class MainUI implements Controller {
    protected BackendDomain _backend;
    boolean running = true;
    private PrintScreen _printWelcomeScreen = new PrintDolphinWelcomeScreen();
    private PrintScreen _printMainMenu = new PrintMainOptions();
    private PrintScreen _printExitScreen = new PrintExitScreen();
    private ReadUserInput<Integer> _readMainMenuOption = new DefaultReadUserOption();
    private ReadUserInput<Boolean> _readExitOption = new ReadExitOption();
    private PrintScreenByDomain _printMembersInArreas = new PrintMembersInArrears();

    private Controller _chairMan ;
    private Controller _cashier;
    private Controller _trainer;

    public MainUI(){
        _backend = new DolphinDomain();
        _chairMan = new ChairmanUI(_backend);
        _cashier = new CashierUI(_backend);
        _trainer = new TrainerUI(_backend);
    }

    @Override
    public void run(){
        _printWelcomeScreen.print();
        while(running) {
            _printMainMenu.print();
            int commandMenu = _readMainMenuOption.read();
            switch (commandMenu) {
                case 1 -> _chairMan.run();
                case 2 -> _cashier.run();
                case 3 -> _trainer.run();
                default -> running = _readExitOption.read();
            }
        }
        _backend.save();
        _printExitScreen.print();
    }
}
