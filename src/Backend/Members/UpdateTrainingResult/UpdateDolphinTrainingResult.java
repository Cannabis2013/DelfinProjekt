package Backend.Members.UpdateTrainingResult;

import Backend.Members.CreateMembers.Discipline;
import Backend.Members.CreateMembers.Member;
import Backend.Members.CreateMembers.TrainingResult;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.util.List;

public class UpdateDolphinTrainingResult implements UpdateResult{
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

    private TrainingResult findByDiscipline(List<TrainingResult> results, Discipline discipline){
        var result = results.stream()
                .filter(r -> r.discipline == discipline).findFirst()
                .orElseThrow(ResultNotFoundException::new);
        return result;


    }

    private void updateResult(Member member,TrainingResult trainingResult, LocalTime result){
        trainingResult.result = result;
        var age = getAgeByBirthDate(member.birthDate());
        trainingResult.team = getTeamByAge(age);
    }

    @Override
    public void update(Member member, LocalTime result, Discipline discipline) {
        var results = member.results();
        var trainingResult = findByDiscipline(results,discipline);
        updateResult(member,trainingResult,result);
        var i = results.indexOf(trainingResult);
        results.set(i,trainingResult);
    }
}
