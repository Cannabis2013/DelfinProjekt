package Backend.Competition.SortCompetitors;

import Backend.Members.CreateMembers.Member;
import Backend.Competition.CreateTrainingResults.TrainingResult;

import java.util.List;

public interface SortCompetitors {
    List<Member> sort(List<Member> competitors, List<TrainingResult> trainingResults);
}
