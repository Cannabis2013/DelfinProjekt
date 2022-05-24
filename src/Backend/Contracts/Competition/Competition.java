package Backend.Contracts.Competition;

import Backend.Competition.Result.CreateTrainingResults.TrainingResult;
import Backend.Competition.Result.Time.Time;
import Backend.Competition.Result.CreateTrainingResults.Discipline;
import Backend.Competition.SortCompetitors.TopSwimmerResult;
import Backend.Contracts.Members.Member;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface Competition {
    List<TopSwimmerResult> sortedCompetitors(List<Member> members);
    void registerToDisciplines(String id, List<Discipline> disciplines);
    UUID registerTrainingResult(String id, Time result, Discipline discipline, LocalDate date);
    void registerCompetitionResult(String id, String competition, LocalDate date, int rank, Time result);
    List<Discipline> registeredDisciplines(String id);
    TrainingResult trainingResult(UUID id);
    void save();
}
