package UI.ReadUserInput;

import Backend.Competition.CreateTrainingResults.TrainingResult;
import Backend.Contracts.BackendDomain;
import UI.Contracts.ReadUserInput;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ReadMemberTrainingDetails implements ReadUserInput<TrainingResult> {
    private void clearLine(){
        System.out.print("\33[A");
        System.out.print("\33[2K");
    }
    @Override
    public TrainingResult read() {
        var keyboard = new Scanner(System.in);
        System.out.print("Enter Member ID: ");
        String membershipID = keyboard.nextLine();
        clearLine();
        System.out.print("Enter Team: ");
        String team = keyboard.nextLine();
        clearLine();
        System.out.print("Enter Discipline: ");
        String discipline = keyboard.nextLine();
        clearLine();
        System.out.print("Enter Date: ");
        String dateAsString = keyboard.nextLine();
        var date = LocalDate.parse(dateAsString, DateTimeFormatter.ofPattern("YYYY-MM-DD"));
        clearLine();
        System.out.print("Enter Time: ");
        String timeAsString = keyboard.nextLine();
        var time = LocalTime.parse(timeAsString, DateTimeFormatter.ofPattern("MIN-SEC"));
        clearLine();

         /*

        System.out.print("Enter Member Name: ");
        String competitorName = keyboard.nextLine();
        clearLine();

        System.out.print("Enter Birthday: ");
        String birthDayAsString = keyboard.nextLine();
        var birthDay = LocalDate.parse(birthDayAsString, DateTimeFormatter.ofPattern("YYYY-mm-dd"));
        clearLine();

         */

        var trainingResult = new TrainingResult();
        return trainingResult;

    }
}

