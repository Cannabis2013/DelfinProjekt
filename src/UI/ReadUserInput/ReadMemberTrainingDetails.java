package UI.ReadUserInput;

import Backend.Competition.Result.Time.Time;
import Backend.Competition.Result.CreateTrainingResults.Discipline;
import UI.Contracts.ReadUserInput;
import UI.Models.TrainingDetails;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class ReadMemberTrainingDetails implements ReadUserInput<TrainingDetails> {
    private void clearLine(){
        System.out.print("\33[A");
        System.out.print("\33[2K");
    }

    private Discipline toDiscipline(String str){
        var discipline = Discipline.valueOf(str.toUpperCase());
        return discipline;
    }

    @Override
    public TrainingDetails read() {
        var reader = new Scanner(System.in);
        System.out.print("Enter Member ID: ");
        String membershipID = reader.nextLine();
        clearLine();
        System.out.print("Enter Discipline: ");
        var discipline = toDiscipline(reader.nextLine());
        clearLine();
        System.out.print("Enter Date: ");
        String dateAsString = reader.nextLine();
        LocalDate date;
        try{
            date = LocalDate.parse(dateAsString, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        }catch (DateTimeParseException e){
            date = LocalDate.now();
        }
        clearLine();
        System.out.print("Enter Time: ");
        var result = Time.fromString(reader.nextLine());
        clearLine();
        TrainingDetails details = new TrainingDetails(membershipID,result,discipline,date);
        return details;

    }
}

