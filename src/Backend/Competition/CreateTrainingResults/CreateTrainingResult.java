package Backend.Competition.CreateTrainingResults;

import java.util.List;

public interface CreateTrainingResult {
    List<TrainingResult> create(String id, List<Discipline> disciplines);
}
