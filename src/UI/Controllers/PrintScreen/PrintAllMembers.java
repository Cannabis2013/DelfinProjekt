package UI.Controllers.PrintScreen;

import Backend.Competition.Result.CreateTrainingResults.Discipline;
import Backend.Contracts.BackendDomain;
import Backend.Contracts.Members.Member;
import Backend.DolphinDomain;
import UI.Contracts.PrintScreen;
import UI.Contracts.PrintScreenByDomain;
import UI.Contracts.ReadUserInput;
import UI.Controllers.ReadUserInput.ConsoleHaltForInput;

import java.util.List;

public class PrintAllMembers implements PrintScreenByDomain {

    private final String ROW_LAYOUT = "%-12s %-20s %s";
    PrintScreen _printBlank = new PrintBlankScreen();
    PrintScreen _clearBuffer = new ClearScrollBuffer();
    ReadUserInput<String> _halt = new ConsoleHaltForInput();

    private String memberDetailToString(Member member, BackendDomain backend){
        var id = member.subscriptionID();
        var truncatedName = truncate(member.name());
        List<Discipline> disciplines = backend.registeredDisciplines(member.subscriptionID());

        var str = String.format(ROW_LAYOUT, id, truncatedName, stringifyDisciplines(disciplines));
        return str;
    }

    private String truncate(String str) {
        final int MAX_NAME_LENGTH = 16;
        if (str.length() <= MAX_NAME_LENGTH)
            return str;
        else
            return str.substring(0, MAX_NAME_LENGTH-2) + "...";
    }

    private String stringifyDisciplines(List<Discipline> disciplines) {
        if (disciplines.isEmpty()) {
            return "No disciplines";
        } else {
            return disciplines.toString().substring(1, disciplines.toString().length()-1);
        }
    }

    private List<String> memberDetailsAsList(List<Member> members, BackendDomain backend){
        List<String> detailsAsString = members.stream()
                .map(m -> memberDetailToString(m, backend)).toList();
        return detailsAsString;
    }

    private void haltScreen(){
        _clearBuffer.print();
        _halt.read();
        _printBlank.print();
    }

    private String createHeader(int longestDetail){
        String header = String.format(ROW_LAYOUT,"ID", "NAME", "DISCIPLINES\n");
        header += "-".repeat(longestDetail);
        return header;
    }

    private int longestDetailString(List<String> details) {
        int longest = 0;
        for (String str : details) {
            if (str.length() > longest)
                longest = str.length();
        }
        return longest;
    }



    @Override
    public void print(BackendDomain domain) {
        _printBlank.print();
        List<Member> members = domain.members();
        var details = memberDetailsAsList(members, domain);
        int longestDetail = longestDetailString(details);
        System.out.println(createHeader(longestDetail));
        details.forEach(d -> System.out.println(d));
        haltScreen();
    }
}
