package Backend.Competition.Result.CreateTrainingResults;

import Backend.Competition.Result.Time.TimeResult;

import java.time.LocalDate;
import java.util.UUID;

public class TrainingResult {
    public Team team;
    public Discipline discipline;
    public LocalDate date;
    public TimeResult result;
    public String subscriberID;
    public UUID id;
}
