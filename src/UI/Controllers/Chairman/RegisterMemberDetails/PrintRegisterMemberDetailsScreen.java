package UI.Controllers.Chairman.RegisterMemberDetails;

import Backend.Competition.Result.CreateTrainingResults.Discipline;
import Backend.Contracts.BackendDomain;
import Backend.Contracts.Members.Member;
import UI.Contracts.PrintScreen;
import UI.Contracts.PrintScreenByDomain;
import UI.Contracts.ReadUserInput;
import UI.Controllers.ConsoleUtils.ClearScrollBuffer;
import UI.Controllers.ConsoleUtils.PrintBlankScreen;
import UI.Controllers.Chairman.RegisterMemberDetails.BasicDetails.RegisterBasicDetails;
import UI.Controllers.ReadUserInput.ConsoleHaltForInput;
import UI.Controllers.Chairman.RegisterMemberDetails.ContactInformation.RegisterContactInformation;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PrintRegisterMemberDetailsScreen implements PrintScreenByDomain {
    private PrintScreen _printBlank = new PrintBlankScreen();
    private PrintScreen _clearBuffer = new ClearScrollBuffer();
    private ReadUserInput<String> _halt = new ConsoleHaltForInput();
    private void printHelpScreen(){
        var msg = """
                Dolphin member registration.
                
                * Please provide full name
                  Ex. of accepted formats : Martin Hansen, Murat Kaan Arici
                  Ex. of not accepted formats: Martin, Murat, Nikki
                  
                * Accepted date formats: 3 feb 2012, 3 february 2012, 03-02-2012
                  
                  Note: Months in letters are matched against danish and english abbreviations/names
                  
                  Ex. : January and Januar always match. Likewise for abbreviations.
                  
                * Disciplines:
                  
                  The following disciplines are all marked with a number id:
                    
                  CRAWL(1) BREAST(2) BUTTERFLY(3) BACKSTROKE(4)
                  
                  You can use numbers or names (case insensitive), but don't mix. Please see examples below:
                  
                  Accepted formats:
                    
                  Ex.: 2 3 4 (BREAST, BUTTERFLY,BACKSTROKE)
                  Ex.: BREAST BACKSTROKE CRAWL
                  
                  Not accepted formats:
                  
                  Ex.: 2 CRAWL 3
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
