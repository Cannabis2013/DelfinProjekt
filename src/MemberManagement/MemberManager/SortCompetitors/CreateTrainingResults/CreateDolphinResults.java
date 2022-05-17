package MemberManagement.MemberManager.SortCompetitors.CreateTrainingResults;

import MemberManagement.MemberManager.CreateMembers.Member;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class CreateDolphinResults implements CreateTrainingResults{
    private final int SENIOR_THRESHOLD = 18;

    private int getAgeByBirthDate(LocalDate birthDate){
        var now = LocalDate.now();
        var period = Period.between(birthDate,now);
        var years = period.getYears();
        return years;
    }

    private TrainingResult.Team getTeamByAge(int age){
        if(age < SENIOR_THRESHOLD)
            return TrainingResult.Team.JUNIOR;
        else
            return TrainingResult.Team.SENIOR;
    }

    List<TrainingResult> toTrainingResults(Member m){
        var l = new ArrayList<TrainingResult>();
        var disciplines = m.disciplines();
        var results = m.results();
        for (var i = 0;i <disciplines.size();i++){
            var discipline = disciplines.get(i);
            var result = results.get(i);
            var trainingResult = new TrainingResult();
            trainingResult.discipline = discipline;
            trainingResult.result = result;
            var age = getAgeByBirthDate(m.birthDate());
            trainingResult.team = getTeamByAge(age);
            l.add(trainingResult);
        }
        return l;
    }

    @Override
    public List<TrainingResult> create(List<Member> members) {
        var results = new ArrayList<TrainingResult>();
        members.stream()
                .forEach(m -> {
                    var l = toTrainingResults(m);
                    results.addAll(l);
                });
        return results;
    }
}
