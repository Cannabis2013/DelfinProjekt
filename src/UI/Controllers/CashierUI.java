package UI.Controllers;

import Backend.Contracts.BackendDomain;
import UI.Contracts.PrintScreen;
import UI.Contracts.PrintScreenByDomain;
import UI.Contracts.ReadUserInput;
import UI.PrintScreen.PrintBlankScreen;
import UI.PrintScreen.PrintCashierOptions;
import UI.PrintScreen.PrintExpectedIncomeScreen;
import UI.PrintScreen.PrintMembersInArrears;
import UI.ReadUserInput.ReadMainMenuOption;

import java.util.Scanner;


public class CashierUI {
    private final BackendDomain _backend;
    private PrintScreen _printMenu = new PrintCashierOptions();
    private ReadUserInput<Integer> _readMainMenuOption = new ReadMainMenuOption();
    private PrintScreen _printBlankScreen = new PrintBlankScreen();
    private PrintScreenByDomain _PrintExpectedIncomeScreen = new PrintExpectedIncomeScreen();
    private PrintScreenByDomain _printMembersInArrears = new PrintMembersInArrears();

    public CashierUI(BackendDomain domain){
        _backend = domain;
    }


    public void displayUI_cashier(){
        var running = true;
        while (running) {
            _printMenu.print();
            int command = _readMainMenuOption.read();
            switch (command) {
                case 1 -> _PrintExpectedIncomeScreen.print(_backend);
                case 2 -> _printMembersInArrears.print(_backend);

                default -> running = false;
            }
        }
    }




}
