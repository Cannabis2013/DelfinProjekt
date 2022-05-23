package Backend.Contracts;

import Backend.Competition.Result.Time.Time;
import Backend.Competition.Result.CreateTrainingResults.Discipline;
import Backend.Competition.SortCompetitors.TopSwimmerResult;
import Backend.Contracts.Members.Member;

import java.time.LocalDate;
import java.util.List;

public interface BackendDomain {
    String registerMemberBasicDetails(String name, LocalDate birthDay, boolean active, List<Discipline> disciplines);
    String registerMemberContactDetails(String id, String phone, String mail, String address);
    void registerTrainingResult(String id, Time result, Discipline discipline, LocalDate date);
    //Skal vi skifte navn for registerResult til registerTrainingResult?
    void registerCompetitionResult(String id, String convention, LocalDate date, int rank, Time result);
    void registerPayment(String id);
    List<TopSwimmerResult> topFiveBestSwimmers();
    List<Member> membersInArrears();
    int expectedEarnings();
    void save();
}
