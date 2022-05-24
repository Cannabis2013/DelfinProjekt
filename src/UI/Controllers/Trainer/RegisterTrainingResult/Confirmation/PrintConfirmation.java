package UI.Controllers.Trainer.RegisterTrainingResult.Confirmation;

import UI.Controllers.Trainer.RegisterTrainingResult.Results.TrainingDetails;

public class PrintConfirmation {
    public void print(TrainingDetails details){
        var subscriberID = details.id();
        var result = details.result().toString();
        var date = details.date().toString();
        var discipline = details.discipline().toString();
        var screen = String.format("""
                Entered details:
                ID: %s
                Discipline: %s
                Date: %s
                Result: %s
                
                Are you sure? (Y/n):
                """,subscriberID,discipline,date,result);
        System.out.print(screen);
    }
}
