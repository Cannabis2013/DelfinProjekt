package Backend.Contracts.Competition;

import Backend.Competition.CreateTrainingResults.Discipline;
import Backend.Competition.SortCompetitors.TopSwimmerResult;
import Backend.Contracts.Members.Member;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface Competition {
    List<TopSwimmerResult> sortedCompetitors(List<Member> members);
    void registerToDisciplines(String id, String disciplines);
    void registerTrainingResult(String id, LocalTime result, Discipline discipline, LocalDate date);
    void registerCompetitionResult(String id, String competition, String date, int rank, String result);
    void save();
}
