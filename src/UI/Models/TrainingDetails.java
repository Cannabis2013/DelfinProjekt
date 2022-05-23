package UI.Models;

import Backend.Competition.Result.Time.Time;
import Backend.Competition.Result.CreateTrainingResults.Discipline;
import java.time.LocalDate;

public record TrainingDetails(String id, Time result, Discipline discipline, LocalDate date) {
}
