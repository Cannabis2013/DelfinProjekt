package UI.RegisterMemberDetails.BasicDetails.Disciplines;

import Backend.Competition.Result.CreateTrainingResults.Discipline;
import UI.Contracts.ReadUserInput;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReadDisciplinesFromUser implements ReadUserInput<List<Discipline>> {
    private Discipline toDiscipline(int index){
        switch (index){
            case 1 : return Discipline.CRAWL;
            case 2 : return Discipline.BREAST;
            case 3 : return Discipline.BUTTERFLY;
            default: return Discipline.BACKSTROKE;
        }
    }

    private Matcher matcher(String str){
        var pattern = Pattern.compile("[0-4]\\b");
        var matcher = pattern.matcher(str);
        return matcher;
    }

    public List<Discipline> toDisciplines(Matcher matcher) {
        var disciplines = new ArrayList<Discipline>();
        while (matcher.find()){
            var match = matcher.group();
            int index;
            try {
                index = Integer.parseInt(match);
            } catch (NumberFormatException e){
                continue;
            }
            disciplines.add(toDiscipline(index));
        }
        return disciplines;
    }

    @Override
    public List<Discipline> read() {
        var input = new Scanner(System.in).nextLine();
        var matcher = matcher(input);
        return toDisciplines(matcher);
    }
}
