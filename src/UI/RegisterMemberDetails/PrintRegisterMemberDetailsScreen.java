package UI.RegisterMemberDetails;

import Backend.Competition.Result.CreateTrainingResults.Discipline;
import Backend.Contracts.BackendDomain;
import Backend.Contracts.Members.Member;
import UI.Contracts.PrintScreen;
import UI.Contracts.PrintScreenByDomain;
import UI.Contracts.ReadUserInput;
import UI.PrintScreen.ClearScrollBuffer;
import UI.PrintScreen.PrintBlankScreen;
import UI.ReadUserInput.ConsoleHaltForInput;
import UI.RegisterMemberDetails.BasicDetails.RegisterBasicDetails;
import UI.RegisterMemberDetails.ContactInformation.RegisterContactInformation;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PrintRegisterMemberDetailsScreen implements PrintScreenByDomain {
    private PrintScreen _printBlank = new PrintBlankScreen();
    private PrintScreen _clearBuffer = new ClearScrollBuffer();
    private ReadUserInput<String> _halt = new ConsoleHaltForInput();
    private void printHelpScreen(){
        var msg = """
                Dolphin user registration.
                * Please use full name
                * Please enter date in format dd-MM-yyyy (Ex. 02-04-1985)
                * As a competitor, please type in numberdesignators for each desired disciplines separated by space
                    
                    CRAWL(1) BREAST(2) BUTTERFLY(3) BACKSTROKE(4)
                    
                    Ex.: 2 3 4 (BREAST, BUTTERFLY,BACKSTROKE)
                """;
        System.out.println(msg);
    }

    private String buildDisciplinesAsString(List<Discipline> disciplines){
        var l = new ArrayList<Discipline>();
        l.addAll(disciplines);
        var disc ="Disciplines: ";
        if(disciplines.isEmpty()) {
            return disc + "Not registered to any disciplines";
        }
        Collections.reverse(l);
        var string = l.stream()
                .map(d -> d.toString() + " ")
                .reduce("",(s,str) -> str += s);
        return disc + string;
    }

    private void printDetails(Member member, List<Discipline> disciplines){
        var name = member.name();
        var birthDate = member.birthDate().toString();
        var status = member.status().toString();
        var dMsg = buildDisciplinesAsString(disciplines);
        var phone = member.phone();
        var mail = member.mail();
        var address = member.address();
        var screen = String.format("""
                    Entered details: 
                    
                    Name: %s
                    Birthdate: %s
                    Member status: %s
                    %s
                    Phone: %s
                    Mail: %s
                    Address: %s
                    """,name,birthDate,status,dMsg,phone,mail,address);
        System.out.println(screen);
    }

    private void clearScreen(){
        _printBlank.print();
        _clearBuffer.print();
    }

    @Override
    public void print(BackendDomain domain) {
        var registerBasics = new RegisterBasicDetails();
        var registerContactInfo = new RegisterContactInformation();
        printHelpScreen();
        var id = registerBasics.register(domain);
        registerContactInfo.register(domain,id);
        var member = domain.member(id);
        var disciplines = domain.registeredDisciplines(id);
        clearScreen();
        printDetails(member,disciplines);
        _halt.read();
        clearScreen();
    }
}
