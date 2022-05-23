package Backend.Members.Persistence;

import Backend.Contracts.Members.Member;
import Backend.Members.CreateMembers.CreateDolphinMember;
import Backend.Members.CreateMembers.SubscriptionStatus;
import Backend.Persistence.AbstractPersistence;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SaveMembersAsCSV extends AbstractPersistence<Member> {
    private final String FOLDER_NAME = "resources";
    private final String FILE_NAME = "members.csv";

    private String toCSVLine(Member member){
        String fullName = member.name();
        String id = member.subscriptionID();
        String birthDate = member.birthDate().toString();
        String enrollment = member.dateEnrolled().toString();
        boolean hasPaid = member.hasNotPaid();
        var csvLineAsString = String.format("%s;%s;%s;%s;%s;\n", fullName, id, birthDate, enrollment, hasPaid);
        return csvLineAsString;
    }

    @Override
    public void save(List<Member> members) {
        createFolderIfNotExists(FOLDER_NAME);
        var fileOut = instantiateStream(FOLDER_NAME,FILE_NAME);
        for (Member member : members) {
            var csvLineAsString = toCSVLine(member);
            fileOut.print(csvLineAsString);
        }
        fileOut.close();
    }

    private Member toMember(String line){
        CreateDolphinMember creator = new CreateDolphinMember();
        Scanner lineScanner = new Scanner(line).useDelimiter(";");
        String fullName = lineScanner.next();
        String id = lineScanner.next();
        LocalDate birthday = LocalDate.parse(lineScanner.next());
        LocalDate enrollmentDate = LocalDate.parse(lineScanner.next());
        String statusAsString = lineScanner.next();
        var status = statusAsString.equalsIgnoreCase("true") ?
                SubscriptionStatus.ACTIVE : SubscriptionStatus.PASSIVE;
        var member = creator.create(fullName, id, birthday, enrollmentDate,status);
        return member;
    }

    @Override
    public List<Member> load() {
        List<Member> fetchedMembers = new ArrayList<>();
        var scanner = instantiateScanner(FOLDER_NAME,FILE_NAME);
        while (scanner != null && scanner.hasNextLine()) {
            String line = scanner.nextLine();
            var member = toMember(line);
            fetchedMembers.add(member);
        }
        return fetchedMembers;
    }
}
