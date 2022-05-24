package UI.Controllers.Trainer.RegisterTrainingResult.Results.Discipline;

import Backend.Competition.Result.CreateTrainingResults.Discipline;
import UI.Contracts.ReadUserInput;

import java.util.Scanner;

public class ReadDiscipline implements ReadUserInput<Discipline> {
    private Discipline fromNumber(int value){
        switch (value){
            case 1 : return Discipline.CRAWL;
            case 2 : return Discipline.BREAST;
            case 3 : return Discipline.BUTTERFLY;
            default: return Discipline.BACKSTROKE;
        }
    }

    private Discipline fromString(String str){
        switch (str.toUpperCase()){
            case "CRAWL" : return Discipline.CRAWL;
            case "BREAST" : return Discipline.BREAST;
            case "BUTTERFLY" : return Discipline.BUTTERFLY;
            default: return Discipline.BACKSTROKE;
        }
    }

    private Discipline toDiscipline(String input){
        int val;
        try {
            val = Integer.parseInt(input);
            return fromNumber(val);
        } catch (NumberFormatException e){
            return fromString(input);
        }
    }

    @Override
    public Discipline read() {
        var input = new Scanner(System.in).nextLine();
        var discipline = toDiscipline(input);
        return discipline;
    }
}
