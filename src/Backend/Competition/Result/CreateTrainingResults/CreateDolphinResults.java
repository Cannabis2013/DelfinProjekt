package Backend.Competition.Result.CreateTrainingResults;

import Backend.Competition.Result.Time.Time;
import Backend.Contracts.Competition.CreateTrainingResult;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CreateDolphinResults implements CreateTrainingResult {
    private final int SENIOR_THRESHOLD = 18;

    private TrainingResult createResult(String id, Discipline discipline){
        var trainingResult = new TrainingResult();
        trainingResult.subscriberID = id;
        trainingResult.discipline = discipline;
        trainingResult.id = UUID.randomUUID();
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

    @Override
    public TrainingResult create(String id, Discipline discipline, Time result, LocalDate date) {
        TrainingResult newResult = new TrainingResult();
        newResult.subscriberID = id;
        newResult.discipline = discipline;
        newResult.result = result;
        return newResult;
    }
}
