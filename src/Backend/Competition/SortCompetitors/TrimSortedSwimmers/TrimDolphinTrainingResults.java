package Backend.Competition.SortCompetitors.TrimSortedSwimmers;

import Backend.Competition.Result.CreateTrainingResults.Discipline;
import Backend.Competition.Result.CreateTrainingResults.Team;
import Backend.Competition.Result.CreateTrainingResults.TrainingResult;
import Backend.Contracts.Competition.TrimTrainingResults;

import java.util.ArrayList;
import java.util.List;

public class TrimDolphinTrainingResults implements TrimTrainingResults {
    private List<TrainingResult> trimmed(List<TrainingResult> results){
        var disciplines = results.stream().map(r -> r.discipline).distinct().toList();
        var firstDiscipline = disciplines.stream().findFirst().orElseThrow(IllegalStateException::new);
        final Discipline[] tempDis = {firstDiscipline};
        final int[] index = {0};
        var resultingList = new ArrayList<TrainingResult>();
        results.forEach(r -> {
            var d = r.discipline;
            if(d.equals(tempDis[0])){
                if(index[0] < 4){
                    resultingList.add(r);
                    index[0]++;
                }
            }
            else {
                index[0] = 0;
                tempDis[0] = d;
                resultingList.add(r);
            }
        });
        return resultingList;
    }

    private List<TrainingResult> findResultsByTeam(Team team, List<TrainingResult> results){
        var filtered = results.stream().filter(r -> r.team.equals(team)).toList();
        return filtered;
    }

    @Override
    public List<TrainingResult> trim(List<TrainingResult> results) {
        var resultingList = new ArrayList<TrainingResult>();
        var teams = results.stream().map(r -> r.team).distinct().toList();
        teams.forEach(t -> {
            var resultsByTeam = findResultsByTeam(t,results);
            var trimmed = trimmed(resultsByTeam);
            resultingList.addAll(trimmed);
        });
        return resultingList;
    }
}
