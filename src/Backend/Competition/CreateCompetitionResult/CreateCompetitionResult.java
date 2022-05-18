package Backend.Competition.CreateCompetitionResult;

import java.time.LocalDate;
import java.time.LocalTime;

public interface CreateCompetitionResult {
    CompetitionResult create(String id, String convention, int rank, String date, String result);
}
