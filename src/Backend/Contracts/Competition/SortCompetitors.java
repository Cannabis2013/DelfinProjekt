package Backend.Contracts.Competition;

import Backend.Competition.Result.CreateTrainingResults.TrainingResult;
import Backend.Competition.SortCompetitors.TopSwimmerResult;
import Backend.Contracts.Members.Member;

import java.util.List;

public interface SortCompetitors {
    List<TopSwimmerResult> sort(List<Member> competitors, List<TrainingResult> trainingResults);
}
