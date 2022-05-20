package UI.ReadUserInput;

import Backend.Competition.CreateTrainingResults.Discipline;
import UI.Contracts.ReadUserInput;
import UI.Models.TrainingDetails;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

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
        var keyboard = new Scanner(System.in);
        System.out.print("Enter Member ID: ");
        String membershipID = keyboard.nextLine();
        clearLine();
        System.out.print("Enter Discipline: ");
        var discipline = toDiscipline(keyboard.nextLine());
        clearLine();
        System.out.print("Enter Date: ");
        String dateAsString = keyboard.nextLine();
        var date = LocalDate.parse(dateAsString, DateTimeFormatter.ofPattern("YYYY-MM-DD"));
        clearLine();
        System.out.print("Enter Time: ");
        String timeAsString = keyboard.nextLine();
        var result = LocalTime.parse(timeAsString, DateTimeFormatter.ofPattern("MIN-SEC"));
        clearLine();
        var trainingResult = new TrainingDetails(membershipID,result,discipline,date);
        return trainingResult;

    }
}

