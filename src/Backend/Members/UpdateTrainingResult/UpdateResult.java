package Backend.Members.UpdateTrainingResult;

import Backend.Members.CreateMembers.Discipline;
import Backend.Members.CreateMembers.Member;

import java.time.LocalTime;

public interface UpdateResult {
    void update(Member member, LocalTime result, Discipline discipline);
}
