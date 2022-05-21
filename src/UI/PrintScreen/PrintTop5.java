package UI.PrintScreen;

import Backend.Competition.SortCompetitors.TopSwimmerResult;
import Backend.Contracts.BackendDomain;
import UI.Contracts.PrintScreen;
import UI.Contracts.PrintScreenByDomain;
import UI.Contracts.ReadUserInput;
import UI.ReadUserInput.ConsoleHaltForInput;

import java.util.ArrayList;
import java.util.List;

public class PrintTop5 implements PrintScreenByDomain {

    private final String ROW_LAYOUT = "%-15s %-4s %-5s %-4s %-5s";
    PrintScreen _printBlank = new PrintBlankScreen();
    PrintScreen _clearBuffer = new ClearScrollBuffer();
    ReadUserInput<String> _halt = new ConsoleHaltForInput();

    private String topSwimmerToString(TopSwimmerResult topSwimmer){
        String name = topSwimmer.name();
        String id = topSwimmer.id();
        String discipline = topSwimmer.discipline().toString();
        String team = topSwimmer.team().toString();
        String result = topSwimmer.result().toString();
        String str = String.format(ROW_LAYOUT,name,id,discipline,team,result);
        return str;
    }

    private List<String> topSwimmerResultsToList(List<TopSwimmerResult> topSwimmers){
        List<String> resultingList = new ArrayList<>();
        for (TopSwimmerResult result : topSwimmers) {
            String str = topSwimmerToString(result);
            resultingList.add(str);
        }
        return resultingList;
    }

    private void printTop5Results (List<String> results){
        for (String result:results) {
            System.out.println(result);
        }
    }
    @Override
    public void print(BackendDomain domain) {
        List<TopSwimmerResult> topSwimmerResults = domain.topFiveBestSwimmers();
        List<String> resultsAsString = topSwimmerResultsToList(topSwimmerResults);
        printTop5Results(resultsAsString);
    }
}
