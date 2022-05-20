package UI.ReadUserInput;

import UI.Contracts.ReadUserInput;
import UI.MemberDetails;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
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

    private MemberDetails readDetails(){
        var reader = new Scanner(System.in);
        System.out.print("Enter Name: ");
        String name = reader.nextLine();
        clearLine();
        System.out.print("Enter birthday:");
        String birthDay = reader.nextLine();
        clearLine();
        var status = readMemberStatus(reader);
        clearLine();
        System.out.print("Enter disciplines: ");
        String disciplines = reader.nextLine();
        clearLine();
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
