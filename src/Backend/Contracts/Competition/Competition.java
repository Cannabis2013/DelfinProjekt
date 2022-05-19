package Backend.Contracts.Competition;

import Backend.Competition.CreateTrainingResults.Discipline;
import Backend.Contracts.Members.Member;

import java.time.LocalDate;
import java.util.List;

public interface Competition {
    List<Member> sortedCompetitors(List<Member> members);
    void registerToDisciplines(String id, String disciplines);
    void registerTrainingResult(String id, String resultAsString, Discipline discipline, LocalDate date);
    void registerCompetitionResult(String id, String competition, String date, int rank, String result);
    void save();
}
