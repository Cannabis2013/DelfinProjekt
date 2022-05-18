package Backend.Competition.CreateDisciplines;

import Backend.Competition.CreateTrainingResults.Discipline;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class DolphinStringToDisciplines implements StringToDiscipline{
    @Override
    public List<Discipline> convert(String disciplines) {
        var resultingList = new ArrayList<Discipline>();
        var pattern = Pattern.compile("\\w+");
        var matcher = pattern.matcher(disciplines);
        if(!matcher.find())
            return new ArrayList<>();
        for (var i = 0;i < matcher.groupCount();i++){
            var nameOfVal = matcher.group(i);
            var discipline = Discipline.valueOf(nameOfVal.toUpperCase());
            resultingList.add(discipline);
        }
        return resultingList;
    }
}
