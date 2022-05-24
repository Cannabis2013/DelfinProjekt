package UI.Controllers.Trainer.RegisterTrainingResult.Results;

import Backend.Competition.Result.CreateTrainingResults.Discipline;
import Backend.Competition.Result.Time.TimeResult;
import Backend.Contracts.BackendDomain;
import Backend.Members.MemberManager.MemberNotFoundException;
import UI.Contracts.ReadUserInput;
import UI.Controllers.ReadUserInput.ConsoleHaltForInput;
import UI.Controllers.ReadUserInput.ReadString.ReadStringMinimalConstraints;
import UI.Controllers.ReadUserInput.ReadTimeResult.ReadDefaultFormattedDate;
import UI.Controllers.Trainer.RegisterTrainingResult.Results.Discipline.ReadDiscipline;
import UI.Controllers.Trainer.RegisterTrainingResult.Results.Time.InvalidResultFormatException;
import UI.Controllers.Trainer.RegisterTrainingResult.Results.Time.ReadMemberResult;
import java.time.LocalDate;

public class ReadResultDetails {
    private ReadUserInput<String> _readMemberID = new ReadStringMinimalConstraints();
    private ReadUserInput<Discipline> _readDiscipline = new ReadDiscipline();
    private ReadUserInput<TimeResult> _readTime = new ReadMemberResult();
    private ReadUserInput<LocalDate> _readDate = new ReadDefaultFormattedDate();
    private ReadUserInput<String> _halt = new ConsoleHaltForInput();

    private void clearLine(){
        System.out.print("\33[A");
        System.out.print("\33[2K");
    }

    private String readMemberID(BackendDomain domain){
        System.out.print("Enter member ID: ");
        var id = _readMemberID.read();
        try {
            var member = domain.member(id);
        } catch (MemberNotFoundException e){
            System.out.println("No member with provided id!");
            _halt.read();
            return "";
        }
        clearLine();
        return id;
    }

    private TimeResult readTimeResult(){
        var cmdLine = "Enter result: ";
        var err = "Invalid time format. Try again: ";
        while (true){
            System.out.print(cmdLine);
            TimeResult time;
            try {
                time = _readTime.read();
                clearLine();
                return time;
            } catch (InvalidResultFormatException e){
                clearLine();
                cmdLine = err;
            }
        }
    }

    private boolean validateDiscipline(Discipline discipline, String id, BackendDomain domain){
        var disciplines = domain.registeredDisciplines(id);
        return disciplines.contains(discipline);
    }

    private Discipline readDiscipline(BackendDomain domain) {
        System.out.print("Read discipline: ");
        var discipline = _readDiscipline.read();
        clearLine();
        return discipline;
    }

    private LocalDate readDate() {
        System.out.print("Read date: ");
        var date = _readDate.read();
        clearLine();
        return date;
    }

    private void printErrorScreen(){}

    public TrainingDetails read(BackendDomain domain){
        var id = readMemberID(domain);
        if(id.isEmpty()){
            printErrorScreen();
            return null;
        }
        var time = readTimeResult();
        var discipline = readDiscipline(domain);
        if(!validateDiscipline(discipline,id,domain)){
            printErrorScreen();
            return null;
        }
        var date = readDate();
        return new TrainingDetails(id,time,discipline,date);
    }
}
