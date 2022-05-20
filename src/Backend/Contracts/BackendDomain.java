package Backend.Contracts;

import Backend.Competition.CreateTrainingResults.Discipline;
import Backend.Contracts.Members.Member;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface BackendDomain {
    String registerMember(String name, String birthDay, boolean active, String disciplines);
    void registerResult(String id, LocalTime result, Discipline discipline, LocalDate date);
    void registerConventionResult(String id, String convention, String date, int rank, String result);
    List<Member> topFiveBestSwimmers();
    List<Member> membersInArrears();
    int expectedEarnings();
    void save();
}
