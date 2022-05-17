package Backend.SortCompetitors.CreateTrainingResults;

import Backend.Members.CreateMembers.Member;

import java.util.List;

public interface CreateTrainingResults {
    List<TrainingResult> create(List<Member> members);
}
