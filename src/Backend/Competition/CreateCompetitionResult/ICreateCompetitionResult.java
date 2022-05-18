package Backend.Competition.CreateCompetitionResult;

import java.time.LocalDate;
import java.time.LocalTime;

public interface ICreateCompetitionResult {
    CompetitionResult create(String id, String convention, int rank, LocalDate date, LocalTime result);
}
