package Backend.Competition.SortCompetitors.Predicates;

import Backend.Competition.CreateTrainingResults.TrainingResult;
import java.util.Comparator;

public class SortByAgeAndResults implements Comparator<TrainingResult> {
    @Override
    public int compare(TrainingResult t1, TrainingResult t2) {
        var team1 = t1.team.toString();
        var team2 = t2.team.toString();
        var teamsPredicate=  team1.compareTo(team2);
        if(teamsPredicate == 0){
            var dis1 = t1.discipline.toString();
            var dis2 = t2.discipline.toString();
            var disPredicate = dis1.compareTo(dis2);
            if(disPredicate == 0)
                return t1.result.compareTo(t2.result);
            return disPredicate;
        }
        return teamsPredicate;
    }
}
