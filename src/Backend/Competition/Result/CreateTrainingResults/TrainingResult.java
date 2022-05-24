package Backend.Competition.Result.CreateTrainingResults;

import Backend.Competition.Result.Time.Time;

import java.time.LocalDate;
import java.util.UUID;

public class TrainingResult {
    public Team team;
    public Discipline discipline;
    public LocalDate date;
    public Time result;
    public String subscriberID;
    public UUID id;
}
