package UI.Controllers.Trainer.Models;

import Backend.Competition.Result.CreateTrainingResults.Discipline;
import Backend.Competition.Result.Time.TimeResult;

import java.time.LocalDate;

public record TrainingDetails(String id, TimeResult result, Discipline discipline, LocalDate date) {
}
