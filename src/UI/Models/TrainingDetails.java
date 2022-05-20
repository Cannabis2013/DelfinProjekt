package UI.Models;

import Backend.Competition.CreateTrainingResults.Discipline;

import java.time.LocalDate;
import java.time.LocalTime;

public record TrainingDetails(String id, LocalTime result, Discipline discipline, LocalDate date) {
}
