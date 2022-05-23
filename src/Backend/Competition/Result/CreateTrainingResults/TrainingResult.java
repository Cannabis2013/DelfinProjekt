package Backend.Competition.Result.CreateTrainingResults;

import Backend.Competition.Result.Time.Time;

import java.time.LocalDate;

public class TrainingResult {
    public Team team;
    public Discipline discipline;
    public LocalDate date;
    public Time result;
    public String subscriberID;
}
