package Backend.SortCompetitors.CreateTrainingResults;

import Backend.Members.CreateMembers.Discipline;

import java.time.LocalTime;

public class TrainingResult {
    public enum Team {JUNIOR, SENIOR}
    public Team team;
    public Discipline discipline;
    public LocalTime result;
    public String subscriberID;
}
