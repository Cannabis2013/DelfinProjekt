package Backend;

import Backend.Competition.CreateTrainingResults.Discipline;
import Backend.Members.CreateMembers.Member;

import java.util.List;

public interface BackendDomain {
    String registerMember(String name, String birthDay, boolean active, String disciplines);
    void registerResult(String id, String result, Discipline discipline);
    void registerConventionResult(String id, String convention, String date, int rank, String result);
    List<Member> topFiveBestSwimmers();
    List<Member> membersInArrears();
    int expectedEarnings();
}
