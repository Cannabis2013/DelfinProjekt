import MemberManagement.*;
import MemberManagement.Persistence.PersistenceHandler;

import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

public class Program {
    public static void main(String[] args) {
        try {
            PersistenceHandler perHandler = new PersistenceHandler();
            LocalDate date = LocalDate.of(2001, 5, 28);
            List<Discipline> disciplines = new ArrayList<>();
            disciplines.add(Discipline.BACKSTROKE);
            disciplines.add(Discipline.BREAST);
            Member member = new Member();
            member._name = "Stefan";
            member._id = 2;
            member._subscriptionType = SubscriptionType.COMPETITION;
            member._birthDate = date;
            member._disciplines = disciplines;
            member._lastPayment = date;
            member._dateEnrolled = date;
            member._memberStatus = MemberStatus.ACTIVE;
            List<IMember> members = new ArrayList<>();
            members.add(member);
            perHandler.save(members);
        } catch (FileNotFoundException e) {
            System.out.println("Something went wrong");
        }
    }
}
