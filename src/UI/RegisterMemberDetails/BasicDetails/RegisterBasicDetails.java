package UI.RegisterMemberDetails.BasicDetails;

import Backend.Competition.Result.CreateTrainingResults.Discipline;
import Backend.Contracts.BackendDomain;
import UI.Contracts.ReadUserInput;
import UI.RegisterMemberDetails.BasicDetails.BirthDate.ReadBirthDay;
import UI.RegisterMemberDetails.BasicDetails.Disciplines.ReadDisciplinesFromUser;
import UI.RegisterMemberDetails.BasicDetails.Name.MemberNameNotValid;
import UI.RegisterMemberDetails.BasicDetails.Name.ReadMemberFullName;
import UI.RegisterMemberDetails.BasicDetails.Status.ReadMemberStatus;

import java.time.LocalDate;
import java.util.List;

public class RegisterBasicDetails {
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

    private LocalDate readDate(String cmdLine){
        System.out.print(cmdLine);
        var birthDate = _readBirthDate.read();
        clearLine();
        return birthDate;
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

    public String register(BackendDomain domain){
        var name = readName("Enter name: ");
        var birthDate = readDate("Enter birthdate: ");
        var activeMember = readMemberStatus("Register as active (1) or passive (*)?");
        var disciplines = readDisciplines();
        var id = domain.registerBasicDetails(name,birthDate,activeMember,disciplines);
        return id;
    }
}
