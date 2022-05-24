package UI.Controllers;

import Backend.Contracts.BackendDomain;
import UI.Contracts.Controller;
import UI.Contracts.PrintScreen;
import UI.Contracts.PrintScreenByDomain;
import UI.Contracts.ReadUserInput;
import UI.Controllers.PrintScreen.*;
import UI.ReadUserInput.DefaultReadUserOption;


public class CashierUI implements Controller {
    private final BackendDomain _backend;
    private PrintScreen _printMenu = new PrintCashierOptions();
    private ReadUserInput<Integer> _readMainMenuOption = new DefaultReadUserOption();
    private PrintScreen _printBlankScreen = new PrintBlankScreen();
    private PrintScreenByDomain _PrintExpectedIncomeScreen = new PrintExpectedIncomeScreen();
    private PrintScreenByDomain _printMembersInArrears = new PrintMembersInArrears();
    private PrintScreenByDomain _printRegisterPaymentScreen = new PrintUpdatePaymentScreen();

    public CashierUI(BackendDomain domain){
        _backend = domain;
    }

    @Override
    public void run(){
        var running = true;
        while (running) {
            _printMenu.print();
            int command = _readMainMenuOption.read();
            switch (command) {
                case 1 -> _PrintExpectedIncomeScreen.print(_backend);
                case 2 -> _printMembersInArrears.print(_backend);
                case 3 -> _printRegisterPaymentScreen.print(_backend);
                default -> running = false;
            }
        }
    }




}
