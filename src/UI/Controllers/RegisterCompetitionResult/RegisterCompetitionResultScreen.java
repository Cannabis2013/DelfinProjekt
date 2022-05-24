package UI.Controllers.RegisterCompetitionResult;

import Backend.Contracts.BackendDomain;
import UI.Contracts.PrintScreenByDomain;
import UI.Contracts.ReadUserInput;
import UI.Controllers.ReadUserInput.ConsoleHaltForInput;
import UI.Controllers.RegisterCompetitionResult.CompetitionResult.ReadCompetitionDetailsScreen;

import java.util.UUID;

public class RegisterCompetitionResultScreen implements PrintScreenByDomain {
    private ReadUserInput<String> _halt = new ConsoleHaltForInput();

    private void printHelpScreen(){
        var screen = """
                Dolphin results registration
                
                * Type in id as usual
                
                * Competition name
                  
                  Name of competition required.
                  
                  Ex.: Hillerød Svømme Stævne 2022
                
                * Time results
                  
                  Please enter results in accepted format as shown below:
                  
                  m:ss:CC (minutes, seconds, centi seconds)
                  
                  Examples of accepted results:
                  
                  Ex.: 0:24.44
                  Ex.: 12:01.12
                  
                * Date formats:
                
                  Examples of accepted date formats:
                  
                  5 august 2000
                  5 aug 2000
                  05-05-2000 (feel free to use your own delimiter)
                """;
        System.out.println(screen);
    }

    private void printConfirmationScreen(UUID id, BackendDomain domain){
        var compResult = domain.competitionResult(id);
        var memberID = compResult.subscriberID;
        var member = domain.member(memberID);
        var memberName = member.name();
        var competitionName = compResult.competition;
        var timeResult = compResult.result.toString();
        var date = compResult.date.toString();
        var rank = compResult.rank;
        var screen = String.format("""
                You registered competition details for %s:
                
                Competition: %s
                Result: %s
                Date: %s 
                Rank: %d
                """,memberName,competitionName,timeResult,date,rank);
        System.out.println(screen);
    }

    @Override
    public void print(BackendDomain domain) {
        printHelpScreen();
        var printReadScreen = new ReadCompetitionDetailsScreen();
        var id = printReadScreen.print(domain);
        printConfirmationScreen(id,domain);
        _halt.read();
    }
}
