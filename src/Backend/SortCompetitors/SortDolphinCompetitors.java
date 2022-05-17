package Backend.SortCompetitors;

import Backend.Members.CreateMembers.Member;
import Backend.Members.CreateMembers.SubscriptionMode;
import Backend.SortCompetitors.CreateTrainingResults.CreateTrainingResults;
import Backend.SortCompetitors.Predicates.SortByAgeAndResults;
import Backend.SortCompetitors.TrimSortedSwimmers.TrimDolphinTrainingResults;
import Backend.SortCompetitors.TrimSortedSwimmers.TrimTrainingResults;
import Backend.SortCompetitors.CreateTrainingResults.CreateDolphinResults;
import Backend.SortCompetitors.CreateTrainingResults.TrainingResult;

import java.util.List;

public class SortDolphinCompetitors implements SortCompetitors {
    CreateTrainingResults _createResults = new CreateDolphinResults();
    TrimTrainingResults _trimResults = new TrimDolphinTrainingResults();

    private List<Member> toMembers(List<TrainingResult> results, List<Member> members){
        var resultingList = results.stream()
                .map(t -> {
                    var id = t.subscriberID;
                    var f = members.stream()
                            .filter(m -> m.subscriptionID() == id).findFirst().orElse(null);
                    return f;
                }).toList();
        return resultingList;
    }

    @Override
    public List<Member> sort(List<Member> members) {
        var competitors = members.stream()
                .filter(m -> m.subscriptionMode() == SubscriptionMode.COMPETITOR).toList();
        var results = _createResults.create(competitors);
        var sorted = results.stream().sorted(new SortByAgeAndResults());
        var trimmed = _trimResults.trim(sorted.toList());
        var resultingList = toMembers(trimmed,members);
        return resultingList;
    }
}
