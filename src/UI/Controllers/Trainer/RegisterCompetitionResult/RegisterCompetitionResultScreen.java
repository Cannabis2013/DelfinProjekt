package UI.Controllers.Trainer.RegisterCompetitionResult;

import Backend.Contracts.BackendDomain;
import UI.Contracts.PrintScreen;
import UI.Contracts.ReadUserInput;
import UI.Controllers.ConsoleUtils.ClearScrollBuffer;
import UI.Controllers.ConsoleUtils.PrintBlankScreen;
import UI.Controllers.ReadUserInput.ConsoleHaltForInput;
import UI.Controllers.ReadUserInput.ReadConfirmation;
import UI.Controllers.Trainer.RegisterCompetitionResult.CompetitionResult.Model.CompDetails;
import UI.Controllers.Trainer.RegisterCompetitionResult.CompetitionResult.ReadCompetitionDetailsScreen;
import UI.Controllers.Trainer.RegisterCompetitionResult.Confirmation.PrintConfirmationScreen;
import UI.Controllers.Trainer.RegisterCompetitionResult.HelpScreen.PrintHelpScreen;

public class RegisterCompetitionResultScreen implements PrintScreen {
    private PrintScreen _printBlank = new PrintBlankScreen();
    private PrintScreen _clearBuffer = new ClearScrollBuffer();
    private ReadUserInput<String> _halt = new ConsoleHaltForInput();
    private PrintScreen _printHelpScreen = new PrintHelpScreen();
    private PrintConfirmationScreen _printConfirmation = new PrintConfirmationScreen();
    private ReadUserInput<Boolean> _readConfirmation = new ReadConfirmation();

    private void clearScreen(){
        _printBlank.print(null);
        _clearBuffer.print(null);
    }

    private void confirm(BackendDomain domain, CompDetails details){
        var memberID = details.memberID();
        var competition = details.competition();
        var result = details.result();
        var date = details.date();
        var rank = details.rank();
        if(_readConfirmation.read()){
            domain.registerCompetitionResult(memberID,competition,date,rank,result);
            System.out.println("Registered!");
        }
        else{
            System.out.println("Discarded!");
        }
    }

    @Override
    public void print(BackendDomain domain) {
        _printHelpScreen.print(null);
        var printReadScreen = new ReadCompetitionDetailsScreen();
        var details = printReadScreen.print(domain);
        clearScreen();
        _printConfirmation.print(details);
        confirm(domain,details);
        _halt.read();
        clearScreen();
    }
}
