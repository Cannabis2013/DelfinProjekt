package Backend.Contracts.Competition;

import Backend.Competition.Result.CreateTrainingResults.Discipline;

import java.util.List;

public interface StringToDiscipline {
    List<Discipline> convert(String disciplines);
}
