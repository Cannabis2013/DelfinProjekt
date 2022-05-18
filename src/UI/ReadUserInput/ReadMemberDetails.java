package UI.ReadUserInput;

import UI.Contracts.ReadUserInput;
import UI.MemberDetails;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class ReadMemberDetails implements ReadUserInput<MemberDetails> {
    @Override
    public MemberDetails read() {
        var keyboard = new Scanner(System.in);
        System.out.print("""
            
            Enter Name: """);
        String name = keyboard.nextLine();

        System.out.println("""
            (Enter like this = year-month-day)
            Enter Date of Birth: """);
        String birthday = keyboard.nextLine();

        System.out.print("""
            Enter Subscription Status -- Active or Passive: """);
        Boolean status = Boolean.valueOf(keyboard.nextLine().toLowerCase(Locale.ROOT));
        if (status.equals("active")) {
            status = true;
        } else if (status.equals("passive")) {
            status = false;
        }
        System.out.print("""
            ( Enter like this = BREAST / CRAWL )
            Enter Disciplines: """);

        String disciplines = keyboard.nextLine();
        var details = new MemberDetails(name,birthday,status,disciplines);
        return details;
    }
}
