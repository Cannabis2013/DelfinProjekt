package UI.Controllers.Main;

import Backend.Contracts.BackendDomain;
import Backend.DolphinDomain;
import UI.Contracts.ConsoleCursorConfig;
import UI.Contracts.Controller;
import UI.Contracts.PrintScreen;
import UI.Contracts.ReadUserInput;
import UI.Controllers.Cashier.CashierUI;
import UI.Controllers.Cashier.Screens.PrintMembersInArrears;
import UI.Controllers.Chairman.ChairmanUI;
import UI.Controllers.ConsoleUtils.ConsoleCSICursorConfig;
import UI.Controllers.Main.ReadOption.ReadMainMenuOption;
import UI.Controllers.Main.Screen.PrintAllMembers;
import UI.Controllers.Main.Screen.PrintWelcomeScreen;
import UI.Controllers.Main.Screen.PrintExitScreen;
import UI.Controllers.Main.Screen.PrintMainOptions;
import UI.Controllers.ReadUserInput.ReadExitOption;
import UI.Controllers.Trainer.TrainerUI;

public class MainUI implements Controller {
    protected BackendDomain _backend;
    boolean running = true;
    private PrintScreen _printWelcomeScreen = new PrintWelcomeScreen();
    private PrintScreen _printMainMenu = new PrintMainOptions();
    private PrintScreen _printExitScreen = new PrintExitScreen();
    private ReadUserInput<Integer> _readMainMenuOption = new ReadMainMenuOption();
    private ReadUserInput<Boolean> _readExitOption = new ReadExitOption();
    private PrintScreen _printMembersInArreas = new PrintMembersInArrears();
    private PrintScreen _printMembers = new PrintAllMembers();
    private ConsoleCursorConfig _cursor = new ConsoleCSICursorConfig();
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
        _cursor.hideCursor();
        _printWelcomeScreen.print(null);
        while(running) {
            _printMainMenu.print(null);
            int commandMenu = _readMainMenuOption.read();
            switch (commandMenu) {
                case 1 -> _chairMan.run();
                case 2 -> _cashier.run();
                case 3 -> _trainer.run();
                case 4 -> _printMembers.print(_backend);
                case -1 -> running = _readExitOption.read();
            }
        }
        _backend.save();
        _printExitScreen.print(null);
        _cursor.hideCursor();
    }
}
