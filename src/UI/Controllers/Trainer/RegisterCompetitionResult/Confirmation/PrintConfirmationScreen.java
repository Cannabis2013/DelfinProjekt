package UI.Controllers.Trainer.RegisterCompetitionResult.Confirmation;

import UI.Controllers.Trainer.RegisterCompetitionResult.CompetitionResult.Model.CompDetails;

public class PrintConfirmationScreen{
    public void print(CompDetails details){
        var competitionName = details.competition();
        var timeResult = details.result().toString();
        var date = details.date().toString();
        var rank = details.rank();
        var screen = String.format("""
                You have entered:
                
                Competition: %s
                Result: %s
                Date: %s 
                Rank: %d
                
                Are you sure? (Y/n):
                """,competitionName,timeResult,date,rank);
        System.out.print(screen);
    }
}
