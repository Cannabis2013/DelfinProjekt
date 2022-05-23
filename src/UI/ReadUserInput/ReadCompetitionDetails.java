package UI.ReadUserInput;

import UI.Contracts.ReadUserInput;
import UI.Models.CompetitionDetails;

import Backend.Competition.Result.Time.Time;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ReadCompetitionDetails implements ReadUserInput<CompetitionDetails> {
    private void clearLine(){
        System.out.print("\33[A");
        System.out.print("\33[2K");
    }

    private LocalDate toDate(String str){
        var formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        var date = LocalDate.parse(str,formatter);
        return date;
    }

    @Override
    public CompetitionDetails read() {
        var keyboard = new Scanner(System.in);
        System.out.print("Enter Member ID: ");
        String membershipID = keyboard.nextLine();
        clearLine();
        System.out.print("Enter convention name: ");
        String conventionName = keyboard.nextLine();
        clearLine();
        System.out.print("Enter Date (yyyy-MM-dd): ");
        LocalDate dateAsString = toDate(keyboard.nextLine());
        clearLine();
        System.out.print("Enter rank: ");
        int rank = Integer.parseInt(keyboard.nextLine());
        clearLine();
        System.out.print("Enter result (mm:ss.CC): ");
        Time result = Time.fromString(keyboard.nextLine());
        var competitionResult = new CompetitionDetails(membershipID,conventionName, dateAsString, rank, result);
        return competitionResult;

    }
}