package UI.RegisterTrainingResult;

import Backend.Contracts.BackendDomain;
import UI.Contracts.PrintScreenByDomain;
import UI.RegisterTrainingResult.Results.PrintReadResultDetails;

import java.util.UUID;

public class PrintRegisterTrainingResult implements PrintScreenByDomain {
    private void printHelpScreen(){
        var screen = """
                Dolphin results registration
                
                Register training results.
                """;
        System.out.println(screen);
    }

    private void printConfirmationScreen(UUID id, BackendDomain domain){
        var trainingResult = domain.trainingResult(id);
    }

    @Override
    public void print(BackendDomain domain) {
        printHelpScreen();
        var printReadingScreen = new PrintReadResultDetails();
        var id = printReadingScreen.print(domain);
        if(id != null)
            printConfirmationScreen(id,domain);
    }
}
