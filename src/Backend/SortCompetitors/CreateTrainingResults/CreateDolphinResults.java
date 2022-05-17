package Backend.SortCompetitors.CreateTrainingResults;

import Backend.Members.CreateMembers.Member;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class CreateDolphinResults implements CreateTrainingResults{
    @Override
    public List<TrainingResult> create(List<Member> members) {
        var results = new ArrayList<TrainingResult>();
        members.stream()
                .forEach(m -> {
                    var l = m.results();
                    results.addAll(l);
                });
        return results;
    }
}
