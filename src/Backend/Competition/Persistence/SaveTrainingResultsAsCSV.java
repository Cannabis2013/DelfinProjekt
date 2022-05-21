package Backend.Competition.Persistence;


import Backend.Competition.CreateTrainingResults.CreateDolphinResults;
import Backend.Competition.CreateTrainingResults.Discipline;
import Backend.Competition.CreateTrainingResults.Team;
import Backend.Competition.CreateTrainingResults.TrainingResult;
import Backend.Contracts.Persistence.Persistence;
import Backend.Persistence.AbstractPersistence;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SaveTrainingResultsAsCSV extends AbstractPersistence<TrainingResult> {
    private final String FOLDER_NAME = "resources";
    private final String FILE_NAME = "trainingResults.csv";

    private String toQueryString(TrainingResult result){
        String id = result.subscriberID;
        String team = result.team.toString();
        String discipline = result.discipline.toString();
        String time = result.result.toString();
        String queryString = String.format("%s;%s;%s;%s;\n", id, team, discipline, time);
        return queryString;
    }

    @Override
    public void save(List<TrainingResult> trainingResults) {
        createFolderIfNotExists(FOLDER_NAME);
        PrintStream stream = instantiateStream(FOLDER_NAME,FILE_NAME);
        PrintStream finalStream = stream;
        trainingResults.forEach(result -> finalStream.print(toQueryString(result)));
        stream.close();
    }

    private TrainingResult toTrainingResult(String line){
        var creator = new CreateDolphinResults();
        Scanner lineScanner = new Scanner(line).useDelimiter(";");
        String id = lineScanner.next();
        var teamAsString = lineScanner.next();
        Discipline discipline = Discipline.valueOf(lineScanner.next().toUpperCase());
        LocalTime time = LocalTime.parse(lineScanner.next());
        var fetchedResult = creator.create(id, teamAsString, discipline, time);
        return fetchedResult;
    }

    @Override
    public List<TrainingResult> load() {
        var fetchedResults = new ArrayList<TrainingResult>();
        Scanner reader = instantiateScanner(FOLDER_NAME,FILE_NAME);
        while(reader != null && reader.hasNextLine()) {
            String line = reader.nextLine();
            var fetchedResult = toTrainingResult(line);
            fetchedResults.add(fetchedResult);
        }
        return fetchedResults;
    }
}
