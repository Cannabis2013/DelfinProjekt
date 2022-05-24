package UI.Controllers.Trainer.Models;


import Backend.Competition.Result.Time.TimeResult;

import java.time.LocalDate;

public record CompetitionDetails(String id, String convention, LocalDate date, int rank, TimeResult result) {
}