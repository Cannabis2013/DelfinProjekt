package Backend.Competition.Manager;

import Backend.Competition.Persistence.SaveCompResultsAsCSV;
import Backend.Competition.Persistence.SaveTrainingResultsAsCSV;
import Backend.Competition.Result.CreateCompetitionResult.CompetitionResult;
import Backend.Competition.Result.CreateCompetitionResult.DolphinCreateCompetitionResult;
import Backend.Competition.Result.CreateTrainingResults.CreateDolphinResults;
import Backend.Competition.Result.CreateTrainingResults.Discipline;
import Backend.Competition.Result.CreateTrainingResults.TrainingResult;
import Backend.Competition.Result.Time.TimeResult;
import Backend.Competition.SortCompetitors.SortDolphinCompetitors;
import Backend.Competition.SortCompetitors.TopSwimmerResult;
import Backend.Contracts.Competition.Competition;
import Backend.Contracts.Competition.CreateCompetitionResult;
import Backend.Contracts.Competition.CreateTrainingResult;
import Backend.Contracts.Competition.SortCompetitors;
import Backend.Contracts.Members.Member;
import Backend.Contracts.Persistence.Persistence;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public class DolphinCompetition implements Competition {
    List<CompetitionResult> _competitionResults;
    List<TrainingResult> _trainingResults;
    SortCompetitors _sorter = new SortDolphinCompetitors();
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
        var filledResults = _trainingResults.stream()
                .filter(r -> r.result != null).toList();
        var fastest = _sorter.sort(members,filledResults);
        return fastest;
    }

    @Override
    public void registerToDisciplines(String id, List<Discipline> disciplines) {
        var trainingResults = _createTrainingResults.create(id,disciplines);
        _trainingResults.addAll(trainingResults);
    }

    @Override
    public UUID registerTrainingResult(String id, TimeResult result, Discipline discipline, LocalDate date) {
        var trainingResult = _trainingResults.stream()
                .filter(r -> r.subscriberID.equals(id) && r.discipline.equals(discipline))
                .findFirst().orElseThrow(NoResultMatchCriteriasException::new);
        trainingResult.result = result;
        trainingResult.date = date;
        return trainingResult.id;
    }

    @Override
    public UUID registerCompetitionResult(String id, String competition, LocalDate date, int rank, TimeResult result) {
        var compResult = _createCompetitionResult.create(id,competition,rank,date,result);
        _competitionResults.add(compResult);
        return compResult.id;
    }

    @Override
    public List<Discipline> registeredDisciplines(String id) {
        var disciplines = _trainingResults.stream()
                .filter(r -> r.subscriberID.equals(id))
                .map(r -> r.discipline).distinct().toList();
        return disciplines;
    }

    @Override
    public TrainingResult trainingResult(UUID id) {
        var result = _trainingResults.stream()
                .filter(r -> r.id.equals(id)).findFirst().orElse(null);
        return result;
    }

    @Override
    public CompetitionResult competitionResult(UUID id) {
        var result = _competitionResults.stream()
                .filter(c -> c.id.equals(id)).findFirst().orElse(null);
        return result;
    }

    @Override
    public void save() {
        _persistTrainingResults.save(_trainingResults);
        _persistCompetitionResults.save(_competitionResults);
    }
}
