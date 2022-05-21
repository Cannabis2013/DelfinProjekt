package UI.Models;


import Backend.Competition.Result.Time.Time;

public record CompetitionDetails(String id, String convention, String date, int rank, Time result) {
}