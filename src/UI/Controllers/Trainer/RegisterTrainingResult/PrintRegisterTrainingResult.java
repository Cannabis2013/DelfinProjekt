package UI.Controllers.Trainer.RegisterTrainingResult;

import Backend.Contracts.BackendDomain;
import UI.Contracts.PrintScreen;
import UI.Contracts.ReadUserInput;
import UI.Controllers.ConsoleUtils.ClearScrollBuffer;
import UI.Controllers.ConsoleUtils.PrintBlankScreen;
import UI.Controllers.ReadUserInput.ConsoleHaltForInput;
import UI.Controllers.ReadUserInput.ReadConfirmation;
import UI.Controllers.Trainer.RegisterTrainingResult.Confirmation.PrintConfirmation;
import UI.Controllers.Trainer.RegisterTrainingResult.HelpScreen.PrintHelpScreen;
import UI.Controllers.Trainer.RegisterTrainingResult.Results.ReadResultDetails;
import UI.Controllers.Trainer.RegisterTrainingResult.Results.TrainingDetails;

import java.util.UUID;

public class PrintRegisterTrainingResult implements PrintScreen {
    private PrintScreen _printHelpScreen = new PrintHelpScreen();
    private PrintScreen _printBlank = new PrintBlankScreen();
    private PrintScreen _clearBuffer = new ClearScrollBuffer();
    private PrintConfirmation _printConfirmation = new PrintConfirmation();
    private ReadUserInput<Boolean> _readConfirmation = new ReadConfirmation();
    private ReadUserInput<String> _halt = new ConsoleHaltForInput();

    private void updateDomain(BackendDomain domain, TrainingDetails trainingDetails){
        var subscriptionID = trainingDetails.id();
        var result = trainingDetails.result();
        var discipline = trainingDetails.discipline();
        var date = trainingDetails.date();
        domain.registerTrainingResult(subscriptionID,result,discipline,date);
        System.out.println("Registered!");
    }

    private void clearScreen(){
        _printBlank.print(null);
        _clearBuffer.print(null);
    }

    private void confirm(BackendDomain domain, TrainingDetails trainingDetails){
        _printConfirmation.print(trainingDetails);
        if(_readConfirmation.read())
            updateDomain(domain,trainingDetails);
        else
            System.out.println("Discarded!");
    }

    @Override
    public void print(BackendDomain domain) {
        _printHelpScreen.print(null);
        var printReadingScreen = new ReadResultDetails();
        var trainingDetails = printReadingScreen.read(domain);
        clearScreen();
        confirm(domain,trainingDetails);
        _halt.read();
        clearScreen();
    }
}
