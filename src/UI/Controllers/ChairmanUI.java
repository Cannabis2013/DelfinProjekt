package UI.Controllers;

import Backend.Contracts.BackendDomain;
import UI.Contracts.Controller;
import UI.Contracts.PrintScreen;
import UI.Contracts.PrintScreenByDomain;
import UI.Contracts.ReadUserInput;
import UI.Controllers.PrintScreen.PrintChairmanOptions;
import UI.Controllers.PrintScreen.PrintMemberCreatedScreen;
import UI.Controllers.ReadUserInput.DefaultReadUserOption;
import UI.Controllers.RegisterMemberDetails.PrintRegisterMemberDetailsScreen;

public class ChairmanUI implements Controller {
    private final BackendDomain _backend;
    private ReadUserInput<Integer> _readMainMenuOption = new DefaultReadUserOption();
    private PrintScreen _printMenu = new PrintChairmanOptions();
    private PrintScreenByDomain _registerMemberDetailsScreen = new PrintRegisterMemberDetailsScreen();
    private PrintScreen _printMemberCreated = new PrintMemberCreatedScreen();

    public ChairmanUI(BackendDomain domain){
        _backend = domain;
    }

    public void run(){
        var running = true;
        while (running) {
            _printMenu.print();
            int command = _readMainMenuOption.read();
            switch (command) {
                case 1 -> _registerMemberDetailsScreen.print(_backend);
                default -> running = false;
            }
        }
    }
}
