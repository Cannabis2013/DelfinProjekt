package Backend.Competition.Manager;

import Backend.Competition.Result.CreateCompetitionResult.CompetitionResult;
import Backend.Competition.Result.CreateCompetitionResult.DolphinCreateCompetitionResult;
import Backend.Competition.CreateDisciplines.DolphinStringToDisciplines;
import Backend.Competition.Result.Time.Time;
import Backend.Competition.Result.CreateTrainingResults.CreateDolphinResults;
import Backend.Competition.Result.CreateTrainingResults.Discipline;
import Backend.Competition.Result.CreateTrainingResults.TrainingResult;
import Backend.Competition.Persistence.SaveCompResultsAsCSV;
import Backend.Competition.Persistence.SaveTrainingResultsAsCSV;
import Backend.Competition.SortCompetitors.SortDolphinCompetitors;
import Backend.Competition.SortCompetitors.TopSwimmerResult;
import Backend.Contracts.Competition.*;
import Backend.Contracts.Members.Member;
import Backend.Contracts.Persistence.Persistence;

import java.time.LocalDate;
import java.util.List;

public class DolphinCompetition implements Competition {
    List<CompetitionResult> _competitionResults;
    List<TrainingResult> _trainingResults;
    SortCompetitors _sorter = new SortDolphinCompetitors();
    StringToDiscipline _convertToDisciplines = new DolphinStringToDisciplines();
    CreateTrainingResult _createTrainingResults = new CreateDolphinResults();
    CreateCompetitionResult _createCompetitionResult = new DolphinCreateCompetitionResult();
    Persistence<TrainingResult> _persistTrainingResults = new SaveTrainingResultsAsCSV();
    Persistence<CompetitionResult> _persistCompetitionResults = new SaveCompResultsAsCSV();

    public DolphinCompetition(){
        _trainingResults = _persistTrainingResults.load();
        _competitionResults = _persistCompetitionResults.load();
    }

    @Override
    public List<TopSwimmerResult> sortedCompetitors(List<Member> members){
        var fastest = _sorter.sort(members,_trainingResults);
        return fastest;
    }

    @Override
    public void registerToDisciplines(String id, String disciplinesAsString) {
        var disciplines = _convertToDisciplines.convert(disciplinesAsString);
        var trainingResults = _createTrainingResults.create(id,disciplines);
        _trainingResults.addAll(trainingResults);
    }

    @Override
    public void registerTrainingResult(String id, Time result, Discipline discipline, LocalDate date) {
        var trainingResult = _trainingResults.stream()
                .filter(r -> r.subscriberID.equals(id) && r.discipline.equals(discipline))
                .findFirst().orElseThrow(NoResultMatchCriteriasException::new);
        trainingResult.result = result;
        trainingResult.date = date;
    }

    @Override
    public void registerCompetitionResult(String id, String competition, LocalDate date, int rank, Time result) {
        var compResult = _createCompetitionResult.create(id,competition,rank,date,result);
        _competitionResults.add(compResult);
    }

    @Override
    public void save() {
        _persistTrainingResults.save(_trainingResults);
        _persistCompetitionResults.save(_competitionResults);
    }
}
