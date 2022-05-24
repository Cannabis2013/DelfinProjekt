package UI.Controllers.PrintScreen;

import Backend.Contracts.BackendDomain;
import Backend.Contracts.Members.Member;
import UI.Contracts.PrintScreen;
import UI.Contracts.PrintScreenByDomain;
import UI.Contracts.ReadUserInput;
import UI.Controllers.ReadUserInput.ConsoleHaltForInput;

import java.util.List;

public class PrintMembersInArrears implements PrintScreenByDomain {
    private final String ROW_LAYOUT = "%-4s %-20s %-5s";
    PrintScreen _printBlank = new PrintBlankScreen();
    PrintScreen _clearBuffer = new ClearScrollBuffer();
    ReadUserInput<String> _halt = new ConsoleHaltForInput();

    private String memberDetailToString(Member member){
        var id = member.subscriptionID();
        var name = member.name();
        var status = member.status().toString();
        var str = String.format(ROW_LAYOUT,id,name,status);
        return str;
    }

    private List<String> memberDetailsAsList(List<Member> members){
        var detailsAsString = members.stream()
                .map(m -> memberDetailToString(m)).toList();
        return detailsAsString;
    }

    private void haltScreen(){
        _clearBuffer.print();
        _halt.read();
        _printBlank.print();
    }

    private String createHeader(){
        var header = String.format(ROW_LAYOUT,"ID", "NAME", "STATUS\n");
        header += "-".repeat(32);
        return header;
    }

    @Override
    public void print(BackendDomain domain) {
        _printBlank.print();
        var members = domain.membersInArrears();
        var details = memberDetailsAsList(members);
        System.out.println(createHeader());
        details.forEach(d -> System.out.println(d));
        haltScreen();
    }
}
