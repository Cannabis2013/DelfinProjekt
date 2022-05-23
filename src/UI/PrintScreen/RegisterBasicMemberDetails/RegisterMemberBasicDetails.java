package UI.PrintScreen.RegisterBasicMemberDetails;

import Backend.Contracts.BackendDomain;
import UI.Contracts.ReadUserInput;
import UI.Contracts.TranslateToDisciplines;

import java.time.LocalDate;

public class RegisterMemberBasicDetails {
    private ReadUserInput<String> _readName;
    private ReadUserInput<LocalDate> _readBirthDate;
    private ReadUserInput<Integer> _readMemberStatus;
    private ReadUserInput<String> _readDisciplines;
    private TranslateToDisciplines _toDisciplines = new DolphinStringToDisciplines();

    private void clearLine(){
        System.out.print("\33[A");
        System.out.print("\33[2K");
    }

    private String readString(String cmdLine){
        System.out.print(cmdLine);
        var name = _readName.read();
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
        return status == 1;
    }



    String register(BackendDomain domain){
        var name = readString("Enter name: ");
        var birthDate = readDate("Enter birthdate: ");
        var activeMember = readMemberStatus("Register as active (1) or passive (*)?");
        var disciplines = readString("Enter disciplines: ");
        var id = domain.registerMemberBasicDetails(name,birthDate,activeMember,_toDisciplines.translate(disciplines));
        return id;
    }
}
