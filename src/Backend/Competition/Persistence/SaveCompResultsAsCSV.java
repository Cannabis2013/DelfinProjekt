package Backend.Competition.Persistence;

import Backend.Competition.Result.CreateCompetitionResult.CompetitionResult;
import Backend.Competition.Result.CreateCompetitionResult.DolphinCreateCompetitionResult;
import Backend.Competition.Result.Time.Time;
import Backend.Contracts.Competition.CreateCompetitionResult;
import Backend.Persistence.AbstractPersistence;
import java.io.PrintStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SaveCompResultsAsCSV extends AbstractPersistence<CompetitionResult> {
    private final String FOLDER_NAME = "resources";
    private final String FILE_NAME = "competitionResults.csv";

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

    @Override
    public void save(List<CompetitionResult> results) {
        createFolderIfNotExists(FOLDER_NAME);
        PrintStream stream = instantiateStream(FOLDER_NAME,FILE_NAME);
        PrintStream finalStream = stream;
        results.forEach(r -> finalStream.print(toQueryString(r)));
        stream.close();
    }

    private CompetitionResult toCompetitionResult(String line){
        var wordReader = new Scanner(line).useDelimiter(";");
        var id = wordReader.next();
        var convention = wordReader.next();
        var date = LocalDate.parse(wordReader.next());
        var rank = wordReader.nextInt();
        var result = Time.fromString(wordReader.next());
        var compResult = builder.create(id,convention,rank,date,result);
        return compResult;
    }

    @Override
    public List<CompetitionResult> load() {
        var fetchedResults = new ArrayList<CompetitionResult>();
        Scanner reader = instantiateScanner(FOLDER_NAME,FILE_NAME);
        while (reader != null && reader.hasNextLine()){
            var line = reader.nextLine();
            var compResult = toCompetitionResult(line);
            fetchedResults.add(compResult);
        }
        return fetchedResults;
    }
}
