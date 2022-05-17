package Backend.Members.CreateTrainingResults;

import Backend.Members.CreateMembers.Discipline;
import Backend.Members.CreateMembers.Member;
import Backend.Members.CreateMembers.TrainingResult;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class CreateDolphinResult implements CreateTrainingResult{
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

    private TrainingResult createResult(String id, Discipline discipline){
        var trainingResult = new TrainingResult();
        trainingResult.subscriberID = id;
        trainingResult.discipline = discipline;
        return trainingResult;
    }

    @Override
    public List<TrainingResult> create(Member member, List<Discipline> disciplines) {
        var results = new ArrayList<TrainingResult>();
        disciplines.forEach(d -> {
            var result = createResult(member.subscriptionID(),d);
            results.add(result);
        });
        return results;
    }
}
