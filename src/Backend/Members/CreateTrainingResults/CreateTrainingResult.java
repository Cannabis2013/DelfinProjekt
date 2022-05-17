package Backend.Members.CreateTrainingResults;

import Backend.Members.CreateMembers.Discipline;
import Backend.Members.CreateMembers.Member;
import Backend.Members.CreateMembers.TrainingResult;

import java.util.List;

public interface CreateTrainingResult {
    List<TrainingResult> create(Member member, List<Discipline> disciplines);
}
