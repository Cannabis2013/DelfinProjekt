package Backend.SortCompetitors.TrimSortedSwimmers;

import Backend.Members.CreateMembers.TrainingResult;

import java.util.List;

public interface TrimTrainingResults {
    List<TrainingResult> trim(List<TrainingResult> results);
}
