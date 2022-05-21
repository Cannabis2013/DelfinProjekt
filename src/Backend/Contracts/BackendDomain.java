package Backend.Contracts;

import Backend.Competition.Result.Time.Time;
import Backend.Competition.Result.CreateTrainingResults.Discipline;
import Backend.Competition.SortCompetitors.TopSwimmerResult;
import Backend.Contracts.Members.Member;

import java.time.LocalDate;
import java.util.List;

public interface BackendDomain {
    String registerMember(String name, LocalDate birthDay, boolean active, String disciplines);
    void registerResult(String id, Time result, Discipline discipline, LocalDate date);
    //Skal vi skifte navn for registerResult til registerTrainingResult?
    void registerConventionResult(String id, String convention, String date, int rank, Time result);
    List<TopSwimmerResult> topFiveBestSwimmers();
    List<Member> membersInArrears();
    int expectedEarnings();
    void save();
}
