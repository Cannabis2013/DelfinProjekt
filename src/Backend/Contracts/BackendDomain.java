package Backend.Contracts;

import Backend.Competition.CreateTrainingResults.Discipline;
import Backend.Competition.SortCompetitors.TopSwimmerResult;
import Backend.Contracts.Members.Member;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface BackendDomain {
    String registerMember(String name, LocalDate birthDay, boolean active, String disciplines);
    void registerResult(String id, LocalTime result, Discipline discipline, LocalDate date);
    //Skal vi skifte navn for registerResult til registerTrainingResult?
    void registerConventionResult(String id, String convention, String date, int rank, String result);
    List<TopSwimmerResult> topFiveBestSwimmers();
    List<Member> membersInArrears();
    int expectedEarnings();
    void save();
}
