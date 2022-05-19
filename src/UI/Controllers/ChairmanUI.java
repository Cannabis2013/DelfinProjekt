package UI.Controllers;

import Backend.Contracts.BackendDomain;
import UI.Contracts.PrintScreen;
import UI.Contracts.ReadUserInput;
import UI.MemberDetails;
import UI.PrintScreen.PrintChairmanOptions;
import UI.PrintScreen.PrintRegisterMemberScreen;
import UI.ReadUserInput.ReadMainMenuOption;
import UI.ReadUserInput.ReadMemberDetails;

public class ChairmanUI {
    private final BackendDomain _backend;
    private ReadUserInput<Integer> _readMainMenuOption = new ReadMainMenuOption();
    private PrintScreen _printMenu = new PrintChairmanOptions();
    private ReadUserInput<MemberDetails> _readMemberDetails = new ReadMemberDetails();
    PrintScreen _printRegistrationScreen = new PrintRegisterMemberScreen();

    public ChairmanUI(BackendDomain domain){
        _backend = domain;
    }

    private void registerMember() {
        _printRegistrationScreen.print();
        var details = _readMemberDetails.read();
        _backend.registerMember(details.name(), details.birthDate(), details.active(), details.disciplines());
    }

    public void displayUI_formand(){
        var running = true;
        while (running) {
            _printMenu.print();
            int command = _readMainMenuOption.read();
            switch (command) {
                case 1 -> registerMember();
                case 2 -> System.out.println("Test 2_Formand");
                case 3 -> System.out.println("Test 3_Formand");
                case 4 -> System.out.println("Test 4_Formand");
                case 5 -> System.out.println("Test 5_Formand");
                default -> running = false;
            }
        }
    }
}
