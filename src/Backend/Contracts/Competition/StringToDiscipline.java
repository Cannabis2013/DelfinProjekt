package Backend.Contracts.Competition;

import Backend.Competition.CreateTrainingResults.Discipline;

import java.util.List;

public interface StringToDiscipline {
    List<Discipline> convert(String disciplines);
}
