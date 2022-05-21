package Backend.Contracts.Competition;

import Backend.Competition.Result.Time.Time;
import Backend.Competition.Result.CreateTrainingResults.Discipline;
import Backend.Competition.SortCompetitors.TopSwimmerResult;
import Backend.Contracts.Members.Member;

import java.time.LocalDate;
import java.util.List;

public interface Competition {
    List<TopSwimmerResult> sortedCompetitors(List<Member> members);
    void registerToDisciplines(String id, String disciplines);
    void registerTrainingResult(String id, Time result, Discipline discipline, LocalDate date);
    void registerCompetitionResult(String id, String competition, String date, int rank, Time result);
    void save();
}
