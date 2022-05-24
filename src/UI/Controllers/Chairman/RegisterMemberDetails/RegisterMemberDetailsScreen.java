package UI.Controllers.Chairman.RegisterMemberDetails;

import Backend.Contracts.BackendDomain;
import UI.Contracts.PrintScreen;
import UI.Contracts.ReadUserInput;
import UI.Controllers.Chairman.RegisterMemberDetails.BasicDetails.Model.BasicDetails;
import UI.Controllers.Chairman.RegisterMemberDetails.BasicDetails.ReadBasicMemberDetails;
import UI.Controllers.ReadUserInput.ReadConfirmation;
import UI.Controllers.Chairman.RegisterMemberDetails.ContactInformation.ContactDetails;
import UI.Controllers.Chairman.RegisterMemberDetails.ContactInformation.ReadMemberContactDetails;
import UI.Controllers.Chairman.RegisterMemberDetails.HelpScreen.PrintRMDHelpScreen;
import UI.Controllers.Chairman.RegisterMemberDetails.Confirmation.PrintConfirmationScreen;
import UI.Controllers.ConsoleUtils.ClearScrollBuffer;
import UI.Controllers.ConsoleUtils.PrintBlankScreen;
import UI.Controllers.ReadUserInput.ConsoleHaltForInput;

public class RegisterMemberDetailsScreen implements PrintScreen {
    private PrintScreen _printBlank = new PrintBlankScreen();
    private PrintScreen _clearBuffer = new ClearScrollBuffer();
    private PrintScreen _printHelp = new PrintRMDHelpScreen();
    private ReadUserInput<String> _halt = new ConsoleHaltForInput();
    private PrintConfirmationScreen _printConfirmation = new PrintConfirmationScreen();
    private ReadUserInput<Boolean> _readConfirmation = new ReadConfirmation();

    private void clearScreen(){
        _printBlank.print(null);
        _clearBuffer.print(null);
    }

    private void registerDetails(BackendDomain domain, BasicDetails basics, ContactDetails contactDetails){
        var id = domain.registerBasicDetails(basics.name(),basics.birthDate(), basics.active(), basics.disciplines());
        domain.registerContactDetails(id,contactDetails.phone(),contactDetails.mail(),contactDetails.address());
        System.out.println("Registered!");
    }

    private void confirm(BackendDomain domain, BasicDetails basicDetails, ContactDetails contactDetails){
        _printConfirmation.printConfirmation(basicDetails,contactDetails);
        if(_readConfirmation.read())
            registerDetails(domain, basicDetails, contactDetails);
        else
            System.out.println("Discarded!");
    }

    @Override
    public void print(BackendDomain domain) {
        _printHelp.print(null);
        var basicDetails = new ReadBasicMemberDetails().register();
        var contactDetails = new ReadMemberContactDetails().register();
        clearScreen();
        confirm(domain,basicDetails,contactDetails);
        _halt.read();
        clearScreen();
    }
}
