package Backend.Competition.CreateTrainingResults;

import java.util.ArrayList;
import java.util.List;

public class CreateDolphinResults implements CreateTrainingResult{
    private final int SENIOR_THRESHOLD = 18;

    private TrainingResult createResult(String id, Discipline discipline){
        var trainingResult = new TrainingResult();
        trainingResult.subscriberID = id;
        trainingResult.discipline = discipline;
        return trainingResult;
    }

    @Override
    public List<TrainingResult> create(String id, List<Discipline> disciplines) {
        var results = new ArrayList<TrainingResult>();
        disciplines.forEach(d -> {
            var result = createResult(id,d);
            results.add(result);
        });
        return results;
    }
}
