package Competition;

import Backend.Competition.Result.Time.Time;
import Backend.Competition.Result.CreateTrainingResults.Discipline;
import Backend.Competition.Result.CreateTrainingResults.Team;
import Backend.Competition.Result.CreateTrainingResults.TrainingResult;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CreateBadgeOfResults {
    private int _resultID = 1;

    private TrainingResult createJunior(Discipline discipline, String time){
        var result = new TrainingResult();
        result.team = Team.JUNIOR;
        result.date = LocalDate.now();
        var rand = new Random();
        result.result = Time.fromString(time);
        result.discipline = discipline;
        result.subscriberID = String.format("%d",_resultID++);
        return result;
    }

    private TrainingResult createSenior(Discipline discipline, String time){
        var result = new TrainingResult();
        result.team = Team.SENIOR;
        result.date = LocalDate.now();
        var rand = new Random();
        result.result = Time.fromString(time);
        result.discipline = discipline;
        result.subscriberID = String.format("%d",_resultID++);
        return result;
    }
    // 8-7-9-15-11-14-13-16-10-12-8-6-3-1-2-5-4
    // "8","7","9","15","11","14","13","16","10","12","8","6","3",
    //                "1","2","5","4","24","23","25","31","27","30","29","32","26","28",
    //                "22","19","17","18","21","20"
    public List<TrainingResult> createBadgeOne(){
        var juniors = new ArrayList<TrainingResult>(){{
            add(createJunior(Discipline.CRAWL,"00:24:00")); // id = 1
            add(createJunior(Discipline.CRAWL,"00:36:00")); // id = 2
            add(createJunior(Discipline.CRAWL,"00:22:00")); // id = 3
            add(createJunior(Discipline.CRAWL,"00:55:00")); // id = 4
            add(createJunior(Discipline.CRAWL,"00:51:00")); // id = 5
            add(createJunior(Discipline.CRAWL,"00:16:00")); // id = 6
            add(createJunior(Discipline.BREAST,"00:25:00")); // id = 7
            add(createJunior(Discipline.BREAST,"00:07:00")); // id = 8
            add(createJunior(Discipline.BREAST,"00:49:00")); // id = 9
            add(createJunior(Discipline.BUTTERFLY,"00:35:00")); // id = 10
            add(createJunior(Discipline.BUTTERFLY,"00:21:00")); // id = 11
            add(createJunior(Discipline.BUTTERFLY,"00:58:00")); // id = 12
            add(createJunior(Discipline.BUTTERFLY,"00:30:00")); // id = 13
            add(createJunior(Discipline.BUTTERFLY,"00:29:00")); // id = 14
            add(createJunior(Discipline.BUTTERFLY,"00:20:00")); // id = 15
            add(createJunior(Discipline.BUTTERFLY,"00:34:00")); // id = 16
        }};
        var seniors = new ArrayList<TrainingResult>(){{
            add(createSenior(Discipline.CRAWL,"00:24:00")); // id = 17
            add(createSenior(Discipline.CRAWL,"00:36:00")); // id = 18
            add(createSenior(Discipline.CRAWL,"00:22:00")); // id = 19
            add(createSenior(Discipline.CRAWL,"00:55:00")); // id = 20
            add(createSenior(Discipline.CRAWL,"00:51:00")); // id = 21
            add(createSenior(Discipline.CRAWL,"00:16:00")); // id = 22
            add(createSenior(Discipline.BREAST,"00:25:00")); // id = 23
            add(createSenior(Discipline.BREAST,"00:07:00")); // id = 24
            add(createSenior(Discipline.BREAST,"00:49:00")); // id = 25
            add(createSenior(Discipline.BUTTERFLY,"00:35:00")); // id = 26
            add(createSenior(Discipline.BUTTERFLY,"00:21:00")); // id = 27
            add(createSenior(Discipline.BUTTERFLY,"00:58:00")); // id = 28
            add(createSenior(Discipline.BUTTERFLY,"00:30:00")); // id = 29
            add(createSenior(Discipline.BUTTERFLY,"00:29:00")); // id = 30
            add(createSenior(Discipline.BUTTERFLY,"00:20:00")); // id = 31
            add(createSenior(Discipline.BUTTERFLY,"00:34:00")); // id = 32
        }};
        var results = new ArrayList<TrainingResult>(){{
            addAll(juniors);
            addAll(seniors);
        }};
        _resultID = 0;
        return results;
    }
}
