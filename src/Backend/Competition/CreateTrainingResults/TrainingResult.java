package Backend.Competition.CreateTrainingResults;

import java.time.LocalDate;
import java.time.LocalTime;

public class TrainingResult {
    public Team team;
    public Discipline discipline;
    public LocalDate date;
    public LocalTime result;
    public String subscriberID;
}
