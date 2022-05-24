package Backend.Competition.Persistence;


import Backend.Competition.Result.CreateTrainingResults.CreateDolphinResults;
import Backend.Competition.Result.CreateTrainingResults.Discipline;
import Backend.Competition.Result.CreateTrainingResults.TrainingResult;
import Backend.Competition.Result.Time.TimeParseFormatException;
import Backend.Competition.Result.Time.TimeResult;
import Backend.Persistence.AbstractPersistence;

import java.io.PrintStream;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SaveTrainingResultsAsCSV extends AbstractPersistence<TrainingResult> {
    private final String FOLDER_NAME = "resources";
    private final String FILE_NAME = "trainingResults.csv";

    private String toQueryString(TrainingResult result){
        String id = result.subscriberID;
        String discipline = result.discipline.toString();
        String date = result.date != null ? result.date.toString() : "";
        String time = result.result != null ? result.result.toString() : " ";
        String queryString = String.format("%s;%s;%s;%s;\n", id,discipline,time,date);
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
        Discipline discipline = Discipline.valueOf(lineScanner.next().toUpperCase());
        TimeResult time;
        try {
            time = TimeResult.fromString(lineScanner.next());
        }catch (TimeParseFormatException e){
            time = null;
        }
        LocalDate date;
        try {
            date = LocalDate.parse(lineScanner.next());
        } catch (DateTimeParseException e){
            date = null;
        }
        var fetchedResult = creator.create(id, discipline, time, date);
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
