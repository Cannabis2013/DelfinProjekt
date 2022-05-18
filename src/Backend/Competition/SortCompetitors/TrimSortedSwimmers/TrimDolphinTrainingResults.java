package Backend.Competition.SortCompetitors.TrimSortedSwimmers;

import Backend.Competition.CreateTrainingResults.Discipline;
import Backend.Competition.CreateTrainingResults.TrainingResult;
import java.util.ArrayList;
import java.util.List;

public class TrimDolphinTrainingResults implements TrimTrainingResults{
    @Override
    public List<TrainingResult> trim(List<TrainingResult> results) {
        var resultingList = new ArrayList<TrainingResult>();
        var disciplines = results.stream()
                .map(r -> r.discipline).distinct().toList();
        var optionalDiscipline = disciplines.stream().findFirst();
        if(!optionalDiscipline.isPresent())
            return null;
        final Discipline[] tempDis = {optionalDiscipline.get()};
        final int[] index = {0};
        resultingList.forEach(r -> {
            var d = r.discipline;
            if(tempDis[0] == d && index[0] < 5){
                resultingList.add(r);
                index[0]++;
            }
            else{
                tempDis[0] = d;
                index[0] = 0;
            }
        });
        return resultingList;
    }
}
