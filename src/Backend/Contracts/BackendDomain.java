package Backend.Contracts;

import Backend.Competition.Result.CreateTrainingResults.TrainingResult;
import Backend.Competition.Result.Time.Time;
import Backend.Competition.Result.CreateTrainingResults.Discipline;
import Backend.Competition.SortCompetitors.TopSwimmerResult;
import Backend.Contracts.Members.Member;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface BackendDomain {
    String registerBasicDetails(String name, LocalDate birthDay, boolean active, List<Discipline> disciplines);
    String registerContactDetails(String id, String phone, String mail, String address);
    Member member(String id);
    UUID registerTrainingResult(String id, Time result, Discipline discipline, LocalDate date);
    //Skal vi skifte navn for registerResult til registerTrainingResult?
    void registerCompetitionResult(String id, String convention, LocalDate date, int rank, Time result);
    TrainingResult trainingResult(UUID id);
    void registerPayment(String id);
    List<TopSwimmerResult> topFiveBestSwimmers();
    List<Member> membersInArrears();
    List<Discipline> registeredDisciplines(String id);
    int expectedEarnings();
    void save();
}
