package Backend.Competition.Persistence;

import Backend.Competition.CreateCompetitionResult.CompetitionResult;
import Backend.Contracts.Competition.CreateCompetitionResult;
import Backend.Competition.CreateCompetitionResult.DolphinCreateCompetitionResult;
import Backend.Contracts.Persistence.Persistence;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SaveCompResultsAsCSV implements Persistence<CompetitionResult> {
    private final CreateCompetitionResult builder = new DolphinCreateCompetitionResult();

    String toQueryString(CompetitionResult r){
        var id = r.subscriberID;
        var convention = r.convention;
        var date = r.date.toString();
        var rank = r.rank;
        var result = r.result.toString();
        var queryString = String.format("%s;%s;%s;%d;%s;\n", id, convention, date, rank,result);
        return queryString;
    }

    private final String FILEPATH = "resources/competition_results.csv";
    @Override
    public void save(List<CompetitionResult> results) {
        PrintStream stream = null;
        try {
            stream = new PrintStream(FILEPATH);
        } catch (FileNotFoundException e) {
            return;
        }
        PrintStream finalStream = stream;
        results.forEach(r -> finalStream.print(toQueryString(r)));
        stream.close();
    }

    private CompetitionResult toCompetitionResult(String line){
        var wordReader = new Scanner(line).useDelimiter(";");
        var id = wordReader.next();
        var convention = wordReader.next();
        var date = wordReader.next();
        var rank = wordReader.nextInt();
        var result = wordReader.next();
        var compResult = builder.create(id,convention,rank,date,result);
        return compResult;
    }

    @Override
    public List<CompetitionResult> load() {
        var fetchedResults = new ArrayList<CompetitionResult>();
        File file = new File(FILEPATH);
        Scanner lineReader = null;
        try {
            lineReader = new Scanner(file);
        } catch (FileNotFoundException e) {
            return new ArrayList<>();
        }
        while (lineReader.hasNextLine()){
            var line = lineReader.nextLine();
            var compResult = toCompetitionResult(line);
            fetchedResults.add(compResult);
        }
        return fetchedResults;
    }
}
