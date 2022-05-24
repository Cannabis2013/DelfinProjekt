package UI.Controllers.Chairman.RegisterMemberDetails.BasicDetails;

import Backend.Competition.Result.CreateTrainingResults.Discipline;
import UI.Contracts.ReadUserInput;
import UI.Controllers.Chairman.RegisterMemberDetails.BasicDetails.BirthDate.InvalidBirthDateException;
import UI.Controllers.Chairman.RegisterMemberDetails.BasicDetails.BirthDate.ReadBirthDay;
import UI.Controllers.Chairman.RegisterMemberDetails.BasicDetails.Disciplines.ReadDisciplinesFromUser;
import UI.Controllers.Chairman.RegisterMemberDetails.BasicDetails.Model.BasicDetails;
import UI.Controllers.Chairman.RegisterMemberDetails.BasicDetails.Name.MemberNameNotValid;
import UI.Controllers.Chairman.RegisterMemberDetails.BasicDetails.Name.ReadMemberFullName;
import UI.Controllers.Chairman.RegisterMemberDetails.BasicDetails.Status.ReadMemberStatus;
import UI.Controllers.ReadUserInput.ReadDate.InvalidDateException;

import java.time.LocalDate;
import java.util.List;

public class ReadBasicMemberDetails {
    private ReadUserInput<String> _readName = new ReadMemberFullName();
    private ReadUserInput<LocalDate> _readBirthDate = new ReadBirthDay();
    private ReadUserInput<Boolean> _readMemberStatus = new ReadMemberStatus();
    private ReadUserInput<List<Discipline>> _readDisciplines = new ReadDisciplinesFromUser();

    private void clearLine(){
        System.out.print("\33[A");
        System.out.print("\33[2K");
    }

    private String readName(String cmdLine){
        String name = "";
        while (true){
            System.out.print("Enter name: ");
            try {
                name = _readName.read();
                break;
            } catch (MemberNameNotValid e){
                clearLine();
            }
        }
        clearLine();
        return name;
    }

    private LocalDate readBirthDate(){
        var err = "";
        while (true){
            LocalDate birthDate;
            try {
                System.out.printf("Enter date of birth%s: ",err);
                birthDate = _readBirthDate.read();
                clearLine();
                return birthDate;
            }catch (InvalidBirthDateException e){
                err = String.format("(Please enter a date before %s)",LocalDate.now().toString());
                clearLine();
            }

        }
    }

    private boolean readMemberStatus(String cmdLine){
        System.out.print(cmdLine);
        var status = _readMemberStatus.read();
        clearLine();
        return status;
    }

    private List<Discipline> readDisciplines(){
        System.out.print("Enter disciplines: ");
        var disciplines = _readDisciplines.read();
        clearLine();
        return disciplines;
    }

    public BasicDetails register(){
        var name = readName("Enter name: ");
        var birthDate = readBirthDate();
        var activeMember = readMemberStatus("Register as active (1) or passive (*)?");
        var disciplines = readDisciplines();
        return new BasicDetails(name,birthDate,activeMember,disciplines);
    }
}
