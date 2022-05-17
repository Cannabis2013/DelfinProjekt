package MemberManagement.MemberManager.SortCompetitors;

import MemberManagement.MemberManager.SortCompetitors.CreateTrainingResults.CreateDolphinResults;
import MemberManagement.MemberManager.SortCompetitors.CreateTrainingResults.CreateTrainingResults;
import MemberManagement.MemberManager.CreateMembers.Member;
import MemberManagement.MemberManager.CreateMembers.SubscriptionMode;
import MemberManagement.MemberManager.SortCompetitors.Predicates.SortByAgeAndResults;

import java.util.List;

public class GetFastestDolphinSwimmers implements GetFastestSwimmers {
    CreateTrainingResults _createResults = new CreateDolphinResults();
    @Override
    public List<Member> get(List<Member> members) {
        var competitors = members.stream()
                .filter(m -> m.subscriptionMode() == SubscriptionMode.COMPETITOR).toList();
        var results = _createResults.create(competitors);
        var sorted = results.stream().sorted(new SortByAgeAndResults());
        return null;
    }
}
