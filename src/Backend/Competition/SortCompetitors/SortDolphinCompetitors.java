package Backend.Competition.SortCompetitors;

import Backend.Competition.CreateTrainingResults.Team;
import Backend.Contracts.Competition.SortCompetitors;
import Backend.Contracts.Members.Member;
import Backend.Competition.CreateTrainingResults.TrainingResult;
import Backend.Competition.SortCompetitors.Predicates.SortByAgeAndResults;
import Backend.Competition.SortCompetitors.TrimSortedSwimmers.TrimDolphinTrainingResults;
import Backend.Contracts.Competition.TrimTrainingResults;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

public class SortDolphinCompetitors implements SortCompetitors {
    TrimTrainingResults _trimResults = new TrimDolphinTrainingResults();

    private final int SENIOR_THRESHOLD = 18;

    private int getAgeByBirthDate(LocalDate birthDate){
        var now = LocalDate.now();
        var period = Period.between(birthDate,now);
        var years = period.getYears();
        return years;
    }

    private Team getTeamByAge(int age){
        if(age < SENIOR_THRESHOLD)
            return Team.JUNIOR;
        else
            return Team.SENIOR;
    }

    private Member getMemberByID(String id, List<Member> members){
        var member = members.stream()
                .filter(m -> m.subscriptionID().equals(id)).findFirst().orElse(null);
        return member;
    }

    private List<TopSwimmerResult> toCompModels(List<TrainingResult> results, List<Member> members){
        var resultingList = results.stream()
                .map(r -> {
                    var m = getMemberByID(r.subscriberID,members);
                    return new TopSwimmerResult(m.name(),m.subscriptionID(),r.discipline,r.team,r.result);
                }).toList();
        return resultingList;
    }

    private Member memberByID(List<Member> members, String id){
        var member = members.stream()
                .filter(m -> m.subscriptionID().equals(id))
                .findFirst().orElse(null);
        return member;
    }

    private List<TrainingResult> updateTeamInfo(List<Member> members, List<TrainingResult> trainingResults){
        trainingResults.forEach(t -> {
            var member = memberByID(members,t.subscriberID);
            var age = getAgeByBirthDate(member.birthDate());
            t.team = getTeamByAge(age);
        });
        return trainingResults;
    }

    @Override
    public List<TopSwimmerResult> sort(List<Member> members, List<TrainingResult> trainingResults) {
        var results = updateTeamInfo(members, trainingResults);
        var sorted = results.stream().sorted(new SortByAgeAndResults());
        var trimmed = _trimResults.trim(sorted.toList());
        var resultingList = toCompModels(trimmed,members);
        return resultingList;
    }
}
