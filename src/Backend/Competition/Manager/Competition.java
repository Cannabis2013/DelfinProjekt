package Backend.Competition.Manager;

import Backend.Competition.CreateTrainingResults.Discipline;
import Backend.Members.CreateMembers.Member;

import java.util.List;

public interface Competition {
    List<Member> sortedCompetitors(List<Member> members);
    void registerToDisciplines(String id, String disciplines);
    void registerTrainingResult(String id, String resultAsString, Discipline discipline);
    void registerCompetitionResult(String id, String competition, String date, int rank, String result);
    void save();
}
