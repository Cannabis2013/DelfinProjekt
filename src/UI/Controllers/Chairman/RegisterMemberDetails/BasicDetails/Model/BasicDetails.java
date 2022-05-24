package UI.Controllers.Chairman.RegisterMemberDetails.BasicDetails.Model;

import Backend.Competition.Result.CreateTrainingResults.Discipline;

import java.time.LocalDate;
import java.util.List;

public record BasicDetails(String name, LocalDate birthDate, boolean active, List<Discipline> disciplines) {
}
