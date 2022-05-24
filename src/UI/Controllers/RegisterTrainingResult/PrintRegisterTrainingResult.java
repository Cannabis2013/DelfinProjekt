package UI.Controllers.RegisterTrainingResult;

import Backend.Contracts.BackendDomain;
import UI.Contracts.PrintScreenByDomain;
import UI.Controllers.RegisterTrainingResult.Results.PrintReadResultDetails;

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
        var subscriberID = trainingResult.subscriberID;
        var member = domain.member(subscriberID);
        var name = member.name();
        var result = trainingResult.result.toString();
        var date = trainingResult.date.toString();
        var discipline = trainingResult.discipline.toString();
        var screen = String.format("""
                You have registered the following informations for %s:
                
                Discipline: %s
                Date: %s
                Result: %s
                """,name,discipline,date,result);
        System.out.println(screen);
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
