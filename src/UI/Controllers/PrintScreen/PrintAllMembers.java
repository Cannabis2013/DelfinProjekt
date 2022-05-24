package UI.Controllers.PrintScreen;

import Backend.Contracts.BackendDomain;
import Backend.Contracts.Members.Member;
import UI.Contracts.PrintScreen;
import UI.Contracts.PrintScreenByDomain;
import UI.Contracts.ReadUserInput;
import UI.Controllers.ReadUserInput.ConsoleHaltForInput;

import java.util.List;

public class PrintAllMembers implements PrintScreenByDomain {

    private final String ROW_LAYOUT = "%-15s    %s";
    PrintScreen _printBlank = new PrintBlankScreen();
    PrintScreen _clearBuffer = new ClearScrollBuffer();
    ReadUserInput<String> _halt = new ConsoleHaltForInput();

    private String memberDetailToString(Member member){
        var id = member.subscriptionID();
        var name = member.name();
        var str = String.format(ROW_LAYOUT,id,name);
        return str;
    }

    private List<String> memberDetailsAsList(List<Member> members){
        List<String> detailsAsString = members.stream()
                .map(m -> memberDetailToString(m)).toList();
        return detailsAsString;
    }

    private void haltScreen(){
        _clearBuffer.print();
        _halt.read();
        _printBlank.print();
    }

    private String createHeader(int longestName){
        String header = String.format(ROW_LAYOUT,"ID", "NAME\n");
        header += "-".repeat(19 + longestName);
        return header;
    }

    public int longestNameLength(List<Member> names) {
        int longest = 0;
        for (Member member : names) {
            if (member.name().length() > longest)
                longest = member.name().length();
        }
        return longest;
    }

    @Override
    public void print(BackendDomain domain) {
        _printBlank.print();
        List<Member> members = domain.members();
        int longestNameLength = longestNameLength(members);
        var details = memberDetailsAsList(members);
        System.out.println(createHeader(longestNameLength));
        details.forEach(d -> System.out.println(d));
        haltScreen();
    }
}
