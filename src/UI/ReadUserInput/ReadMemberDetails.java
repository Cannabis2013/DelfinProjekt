package UI.ReadUserInput;

import UI.Contracts.ReadUserInput;
import UI.Models.MemberDetails;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class ReadMemberDetails implements ReadUserInput<MemberDetails> {
    private void clearLine(){
        System.out.print("\33[A");
        System.out.print("\33[2K");
    }

    private void printMessage(){
        var msg = """
                Dolphin user registration.
                * Please use full name
                * Please enter date in format YYYY-dd-mm (Ex. 1985-04-02)
                * As a competitor, please type in desired disciplines separated by slash
                """;
        System.out.println(msg);
    }

    private boolean readMemberStatus(Scanner reader){
        System.out.print("Register as active (1) or passive (*)?");
        var input = reader.nextLine();
        int option;
        try {
            option = Integer.parseInt(input);
        } catch (NumberFormatException e){
            return false;
        }
        return option == 1;
    }

    LocalDate toDate(String str){
        var formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date;
        try {
            return LocalDate.parse(str,formatter);
        }catch (DateTimeParseException e){
            return LocalDate.of(2000,1,1);
        }
    }

    private String readString(String text, Scanner reader){
        System.out.print(text);
        var line = reader.nextLine();
        clearLine();
        return line;
    }

    private MemberDetails readDetails(){
        var disciplines = "";
        var reader = new Scanner(System.in);
        String name = readString("Enter Name: ",reader);
        String birthDayAsString = readString("Enter birthday: ",reader);
        var birthDay = toDate(birthDayAsString);
        clearLine();
        var status = readMemberStatus(reader);
        clearLine();
        if(status)
            disciplines = readString("Enter disciplines: ",reader);
        var details = new MemberDetails(name,birthDay,status,disciplines);
        return details;
    }

    @Override
    public MemberDetails read() {
        printMessage();
        var details = readDetails();
        return details;
    }
}
