package UI.Models;

import Backend.Competition.Result.Time.TimeResult;
import Backend.Competition.Result.CreateTrainingResults.Discipline;
import java.time.LocalDate;

public record TrainingDetails(String id, TimeResult result, Discipline discipline, LocalDate date) {
}
