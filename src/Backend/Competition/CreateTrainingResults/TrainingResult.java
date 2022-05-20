package Backend.Competition.CreateTrainingResults;

import Backend.Competition.CreateTrainingResults.Discipline;

import java.time.LocalDate;
import java.time.LocalTime;

public class TrainingResult {
    public Team team;
    public Discipline discipline;
    public LocalDate date;
    public LocalTime result;
    public String subscriberID;
}
