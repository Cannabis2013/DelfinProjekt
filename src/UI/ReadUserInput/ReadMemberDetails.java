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

    @Override
    public MemberDetails read() {
        var keyboard = new Scanner(System.in);
        System.out.print("Enter Name: ");
        String name = keyboard.nextLine();
        clearLine();
        System.out.print("Enter birthday:");
        String birthDayAsString = keyboard.nextLine();
        var birthDay = LocalDate.parse(birthDayAsString, DateTimeFormatter.ofPattern("YYYY-mm-dd"));
        clearLine();
        System.out.print("Register as active or passive?");
        Boolean status = Boolean.valueOf(keyboard.nextLine().toLowerCase(Locale.ROOT));
        clearLine();
        if (status.equals("active")) {
            status = true;
        } else if (status.equals("passive")) {
            status = false;
        }
        System.out.print("Enter disciplines: ");

        String disciplines = keyboard.nextLine();
        clearLine();
        var details = new MemberDetails(name,birthDay,status,disciplines);
        return details;
    }
}
