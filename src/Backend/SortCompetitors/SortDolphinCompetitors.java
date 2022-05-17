package Backend.SortCompetitors;

import Backend.Members.CreateMembers.Member;
import Backend.Members.CreateMembers.TrainingResult;
import Backend.SortCompetitors.Predicates.SortByAgeAndResults;
import Backend.SortCompetitors.TrimSortedSwimmers.TrimDolphinTrainingResults;
import Backend.SortCompetitors.TrimSortedSwimmers.TrimTrainingResults;
import java.util.ArrayList;
import java.util.List;

public class SortDolphinCompetitors implements SortCompetitors {
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

    private List<TrainingResult> getResults(List<Member> competitors){
        var results = new ArrayList<TrainingResult>();
        competitors.stream()
                .forEach(m -> {
                    var l = m.results();
                    results.addAll(l);
                });
        return results;
    }

    @Override
    public List<Member> sort(List<Member> competitors) {
        var results = getResults(competitors);
        var sorted = results.stream().sorted(new SortByAgeAndResults());
        var trimmed = _trimResults.trim(sorted.toList());
        var resultingList = toMembers(trimmed,competitors);
        return resultingList;
    }
}
