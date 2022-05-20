package Backend.Contracts.Competition;

import Backend.Competition.SortCompetitors.TopSwimmerResult;
import Backend.Contracts.Members.Member;
import Backend.Competition.CreateTrainingResults.TrainingResult;

import java.util.List;

public interface SortCompetitors {
    List<TopSwimmerResult> sort(List<Member> competitors, List<TrainingResult> trainingResults);
}
