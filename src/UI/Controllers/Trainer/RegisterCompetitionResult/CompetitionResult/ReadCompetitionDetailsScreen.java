package UI.Controllers.Trainer.RegisterCompetitionResult.CompetitionResult;

import Backend.Competition.Result.Time.TimeResult;
import Backend.Contracts.BackendDomain;
import Backend.Members.MemberManager.MemberNotFoundException;
import UI.Contracts.ReadUserInput;
import UI.Controllers.ReadUserInput.ConsoleHaltForInput;
import UI.Controllers.ReadUserInput.ReadString.ReadStringMinimalConstraints;
import UI.Controllers.ReadUserInput.ReadTimeResult.ReadDefaultFormattedDate;
import UI.Controllers.Trainer.RegisterCompetitionResult.CompetitionResult.Rank.ReadCompetitionRank;
import UI.Controllers.Trainer.RegisterTrainingResult.Results.Time.InvalidResultFormatException;
import UI.Controllers.Trainer.RegisterTrainingResult.Results.Time.ReadMemberResult;

import java.time.LocalDate;
import java.util.UUID;

public class ReadCompetitionDetailsScreen {
    private ReadUserInput<TimeResult> _readTime = new ReadMemberResult();
    private ReadUserInput<LocalDate> _readDate = new ReadDefaultFormattedDate();
    private ReadUserInput<String> _readMemberID = new ReadStringMinimalConstraints();
    private ReadUserInput<String> _readCompetitionName = new ReadStringMinimalConstraints();
    private ReadUserInput<Integer> _readRank = new ReadCompetitionRank();
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

    private String readCompetitionName(){
        System.out.print("Enter name of competition: ");
        var name = _readCompetitionName.read();
        clearLine();
        return name;
    }

    private LocalDate readDate(){
        System.out.print("Read date: ");
        var date = _readDate.read();
        clearLine();
        return date;
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

    private int readRank(){
        System.out.print("Enter rank: ");
        var rank = _readRank.read();
        clearLine();
        return rank;
    }

    public UUID print(BackendDomain domain){
        var memberID = readMemberID(domain);
        var competitionName = readCompetitionName();
        var date = readDate();
        var result = readTimeResult();
        var rank = readRank();
        var id = domain.registerCompetitionResult(memberID,competitionName,date,rank,result);
        return id;
    }
}
