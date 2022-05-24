package UI.Controllers.RegisterMemberDetails.BasicDetails.Disciplines;

import Backend.Competition.Result.CreateTrainingResults.Discipline;
import UI.Contracts.ReadUserInput;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class ReadDisciplinesFromUser implements ReadUserInput<List<Discipline>> {
    private final String FULL_NUMBER_REGEX = "^[1-4 ]+$";
    private final String ATOMIC_NUMBER_REGEX = "\\d\\b";
    private final String FULL_STRING_REGEX = "^[A-z ]+$";
    private final String ATOMIC_STRING_REGEX = "\\w+";

    private Discipline fromNumber(int index){
        switch (index){
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

    public List<Discipline> fromNumerics(String input) {
        var matcher = Pattern.compile(ATOMIC_NUMBER_REGEX).matcher(input);
        var disciplines = new ArrayList<Discipline>();
        while (matcher.find()){
            var match = matcher.group();
            int index;
            try {
                index = Integer.parseInt(match);
            } catch (NumberFormatException e){
                continue;
            }
            disciplines.add(fromNumber(index));
        }
        return disciplines;
    }

    public List<Discipline> fromStrings(String input){
        var matcher = Pattern.compile(ATOMIC_STRING_REGEX).matcher(input);
        var disciplines = new ArrayList<Discipline>();
        while (matcher.find()){
            var match = matcher.group();
            var discipline = fromString(match);
            disciplines.add(discipline);
        }
        return disciplines;
    }

    @Override
    public List<Discipline> read() {
        var input = new Scanner(System.in).nextLine();
        if (input.matches(FULL_NUMBER_REGEX))
            return fromNumerics(input);
        else if(input.matches(FULL_STRING_REGEX))
            return fromStrings(input);
        else
            return new ArrayList<Discipline>();
    }
}
