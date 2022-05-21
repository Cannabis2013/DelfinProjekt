package UI.Models;


import Backend.Competition.Result.Time.Time;

import java.time.LocalDate;

public record CompetitionDetails(String id, String convention, LocalDate date, int rank, Time result) {
}