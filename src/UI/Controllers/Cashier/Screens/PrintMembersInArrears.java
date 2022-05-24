package UI.Controllers.Cashier.Screens;

import Backend.Contracts.BackendDomain;
import Backend.Contracts.Members.Member;
import UI.Contracts.PrintScreen;
import UI.Contracts.ReadUserInput;
import UI.Controllers.ConsoleUtils.ClearScrollBuffer;
import UI.Controllers.ConsoleUtils.PrintBlankScreen;
import UI.Controllers.ReadUserInput.ConsoleHaltForInput;

import java.util.List;

public class PrintMembersInArrears implements PrintScreen {
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
        _clearBuffer.print(null);
        _halt.read();
        _printBlank.print(null);
    }

    private String createHeader(){
        var header = String.format(ROW_LAYOUT,"ID", "NAME", "STATUS\n");
        header += "-".repeat(32);
        return header;
    }

    @Override
    public void print(BackendDomain domain) {
        _printBlank.print(null);
        var members = domain.membersInArrears();
        var details = memberDetailsAsList(members);
        System.out.println(createHeader());
        details.forEach(d -> System.out.println(d));
        haltScreen();
    }
}
