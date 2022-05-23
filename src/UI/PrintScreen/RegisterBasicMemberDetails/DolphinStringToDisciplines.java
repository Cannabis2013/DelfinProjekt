package UI.PrintScreen.RegisterBasicMemberDetails;

import Backend.Competition.Result.CreateTrainingResults.Discipline;
import UI.Contracts.TranslateToDisciplines;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class DolphinStringToDisciplines implements TranslateToDisciplines {
    private Discipline toDiscipline(int index){
        switch (index){
            case 1 : return Discipline.CRAWL;
            case 2 : return Discipline.BREAST;
            case 3 : return Discipline.BUTTERFLY;
            default: return Discipline.BACKSTROKE;
        }
    }

    @Override
    public List<Discipline> translate(String disciplinesAsString) {
        var disciplines = new ArrayList<Discipline>();
        var pattern = Pattern.compile("^[0-4 ]+$");
        var matcher = pattern.matcher(disciplinesAsString);
        if(!matcher.find())
            return new ArrayList<>();
        for (var i = 0;i < matcher.groupCount();i++){
            int index;
            try {
                index = Integer.parseInt(matcher.group(i));
            } catch (NumberFormatException e){
                continue;
            }
            disciplines.add(toDiscipline(index));
        }
        return disciplines;
    }
}
