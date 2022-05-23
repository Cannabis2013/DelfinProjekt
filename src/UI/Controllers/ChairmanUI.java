package UI.Controllers;

import Backend.Contracts.BackendDomain;
import UI.Contracts.Controller;
import UI.Contracts.PrintScreen;
import UI.Contracts.ReadUserInput;
import UI.Models.MemberDetails;
import UI.PrintScreen.PrintChairmanOptions;
import UI.PrintScreen.PrintMemberCreatedScreen;
import UI.ReadUserInput.DefaultReadUserOption;
import UI.ReadUserInput.ReadMemberDetails;

public class ChairmanUI implements Controller {
    private final BackendDomain _backend;
    private ReadUserInput<Integer> _readMainMenuOption = new DefaultReadUserOption();
    private PrintScreen _printMenu = new PrintChairmanOptions();
    private ReadUserInput<MemberDetails> _readMemberDetails = new ReadMemberDetails();
    private PrintScreen _printMemberCreated = new PrintMemberCreatedScreen();

    public ChairmanUI(BackendDomain domain){
        _backend = domain;
    }

    private void registerMember() {
        var details = _readMemberDetails.read();
        _backend.registerMember(details.name(),details.birthDate(),details.active(),details.disciplines());
        _printMemberCreated.print();
    }

    public void run(){
        var running = true;
        while (running) {
            _printMenu.print();
            int command = _readMainMenuOption.read();
            switch (command) {
                case 1 -> registerMember();
                default -> running = false;
            }
        }
    }
}
