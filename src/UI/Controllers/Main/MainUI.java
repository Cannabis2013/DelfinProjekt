package UI.Controllers.Main;

import Backend.Contracts.BackendDomain;
import Backend.DolphinDomain;
import UI.Contracts.Controller;
import UI.Contracts.PrintScreen;
import UI.Contracts.PrintScreenByDomain;
import UI.Contracts.ReadUserInput;
import UI.Controllers.Cashier.CashierUI;
import UI.Controllers.Cashier.Screens.PrintMembersInArrears;
import UI.Controllers.Chairman.ChairmanUI;
import UI.Controllers.Main.Screen.PrintAllMembers;
import UI.Controllers.Main.Screen.PrintDolphinWelcomeScreen;
import UI.Controllers.Main.Screen.PrintExitScreen;
import UI.Controllers.Main.Screen.PrintMainOptions;
import UI.Controllers.ReadUserInput.DefaultReadUserOption;
import UI.Controllers.ReadUserInput.ReadExitOption;
import UI.Controllers.Trainer.TrainerUI;

public class MainUI implements Controller {
    protected BackendDomain _backend;
    boolean running = true;
    private PrintScreen _printWelcomeScreen = new PrintDolphinWelcomeScreen();
    private PrintScreen _printMainMenu = new PrintMainOptions();
    private PrintScreen _printExitScreen = new PrintExitScreen();
    private ReadUserInput<Integer> _readMainMenuOption = new DefaultReadUserOption();
    private ReadUserInput<Boolean> _readExitOption = new ReadExitOption();
    private PrintScreenByDomain _printMembersInArreas = new PrintMembersInArrears();
    private PrintScreenByDomain _printMembers = new PrintAllMembers();

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
                case 4 -> _printMembers.print(_backend);
                default -> running = _readExitOption.read();
            }
        }
        _backend.save();
        _printExitScreen.print();
    }
}
