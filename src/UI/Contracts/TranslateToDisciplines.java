package UI.Contracts;

import Backend.Competition.Result.CreateTrainingResults.Discipline;

import java.util.List;

public interface TranslateToDisciplines {
    List<Discipline> translate(String str);
}
