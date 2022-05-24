package UI.Controllers.Trainer.RegisterCompetitionResult.CompetitionResult.Model;

import Backend.Competition.Result.Time.TimeResult;

import java.time.LocalDate;

public record CompDetails(String memberID, String competition, LocalDate date, TimeResult result,int rank) {
}
