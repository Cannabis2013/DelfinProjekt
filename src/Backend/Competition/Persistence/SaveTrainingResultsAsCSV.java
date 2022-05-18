package Backend.Competition.Persistence;


import Backend.Competition.CreateTrainingResults.Discipline;
import Backend.Competition.CreateTrainingResults.TrainingResult;
import Backend.Contracts.Persistence.Persistence;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SaveTrainingResultsAsCSV implements Persistence<TrainingResult> {
    @Override
    public void save(List<TrainingResult> trainingResults) {
        PrintStream stream = null;
        try {
            stream = new PrintStream("resources/training_results.csv");
        } catch (FileNotFoundException e) {
            return;
        }
        PrintStream finalStream = stream;
        trainingResults.forEach(result -> {
            String id = result.subscriberID;
            String team = result.team.toString();
            String discipline = result.discipline.toString();
            String time = result.result.toString();
            String queryString = String.format("%s;%s;%s;%s;\n", id, team, discipline, time);
            finalStream.print(queryString);
        });
        stream.close();
    }

    @Override
    public List<TrainingResult> load() {
        var fetchedResults = new ArrayList<TrainingResult>();
        File file = new File("resources/training_results.csv");
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            return new ArrayList<>();
        }
        while(scanner.hasNextLine()) {
            String line = scanner.nextLine();
            Scanner lineScanner = new Scanner(line).useDelimiter(";");
            String id = lineScanner.next();
            TrainingResult.Team team = teamStringToEnum(lineScanner.next());
            Discipline discipline = Discipline.valueOf(lineScanner.next().toUpperCase());
            LocalTime time = LocalTime.parse(lineScanner.next());
            var fetchedResult = resultCreator(id, team, discipline, time);
            fetchedResults.add(fetchedResult);
        }
        scanner.close();
        return fetchedResults;
    }

    private TrainingResult resultCreator(String id, TrainingResult.Team team, Discipline discipline, LocalTime time) {
        TrainingResult newResult = new TrainingResult();
        newResult.subscriberID = id;
        newResult.discipline = discipline;
        newResult.result = time;
        newResult.team = team;
        return newResult;
    }

    private TrainingResult.Team teamStringToEnum(String stringified) {
        switch (stringified) {
            case "JUNIOR" -> {return TrainingResult.Team.JUNIOR;}
            case "SENIOR" -> {return TrainingResult.Team.SENIOR;}
            default -> {return null;}
        }
    }
}
