package MemberManagement.Persistence;

import MemberManagement.CreateMembers.CreateDolphinMember;
import MemberManagement.CreateMembers.Member;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Persistence implements IPersistence {


    @Override
    public void save(List<Member> members) throws FileNotFoundException {
        PrintStream stream = new PrintStream("resources/members.csv");
        for (Member member : members) {
            String fullName = String.format("%s %s %s", member.foreName(), member.middleName(), member.lastName());
            String id = member.subscriptionID();
            String birthDate = member.birthDate().toString();
            String enrollment = member.dateEnrolled().toString();
            stream.print(String.format("%s;%s;%s;%s;\n", fullName, id, birthDate, enrollment));
        }
        stream.close();
    }

    @Override
    public List<Member> load() throws FileNotFoundException {
        File file = new File("resources/members.csv");
        CreateDolphinMember creater = new CreateDolphinMember();
        List<Member> loadedMembers = new ArrayList<>();
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            Scanner lineScanner = new Scanner(line).useDelimiter(";");
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            String fullName = lineScanner.next();
            String id = lineScanner.next();
            LocalDate birthday = LocalDate.parse(lineScanner.next(), formatter);
            LocalDate enrollmentDate = LocalDate.parse(lineScanner.next(), formatter);
             Member loadedMember = creater.loadMember(fullName, id, birthday, enrollmentDate);
            loadedMembers.add(loadedMember);
        }
        return loadedMembers;
    }

}
