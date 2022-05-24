package UI.Controllers.Chairman.RegisterMemberDetails.Confirmation;

import Backend.Competition.Result.CreateTrainingResults.Discipline;
import UI.Controllers.Chairman.RegisterMemberDetails.BasicDetails.Model.BasicDetails;
import UI.Controllers.Chairman.RegisterMemberDetails.ContactInformation.ContactDetails;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PrintConfirmationScreen {
    private String buildDisciplinesAsString(List<Discipline> disciplines){
        var l = new ArrayList<Discipline>();
        l.addAll(disciplines);
        var disc ="Disciplines: ";
        if(disciplines.isEmpty()) {
            return disc + "Not registered to any disciplines";
        }
        Collections.reverse(l);
        var string = l.stream().map(d -> d.toString() + " ").reduce("",(s,str) -> str += s);
        return disc + string;
    }

    public void printConfirmation(BasicDetails basics, ContactDetails contactDetails){
        var name = basics.name();
        var birthDate = basics.birthDate().toString();
        var status = basics.active() ? "ACTIVE" : "PASSIVE";
        var dMsg = buildDisciplinesAsString(basics.disciplines());
        var phone = contactDetails.phone();
        var mail = contactDetails.mail();
        var address = contactDetails.address();
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
        System.out.print("Are you sure? (Y/n):");
    }
}
