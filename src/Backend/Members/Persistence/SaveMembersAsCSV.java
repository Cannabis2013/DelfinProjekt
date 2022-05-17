package Backend.Members.Persistence;

import Backend.Members.CreateMembers.Discipline;
import Backend.Members.CreateMembers.CreateDolphinMember;
import Backend.Members.CreateMembers.Member;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SaveMembersAsCSV implements Persistence {
    @Override
    public void save(List<Member> members) {
        PrintStream stream = null;
        try {
            stream = new PrintStream("resources/members.csv");
        } catch (FileNotFoundException e) {
            return;
        }
        for (Member member : members) {
            String fullName = member.name();
            String id = member.subscriptionID();
            String birthDate = member.birthDate().toString();
            String enrollment = member.dateEnrolled().toString();
            boolean hasPaid = member.hasNotPaid();
            List<Discipline> disciplines = member.disciplines();
            stream.print(String.format("%s;%s;%s;%s;%s;%s;\n", fullName, id, birthDate, enrollment, hasPaid, disciplines.toString()));
        }
        stream.close();
    }


    // Name - done
    // id - done
    // birthday - done
    // enrollment - done
    // hasPaid - done
    // disciplines - done
    // results
    // team?
    //

    @Override
    public List<Member> load() {
        File file = new File("resources/members.csv");
        CreateDolphinMember creater = new CreateDolphinMember();
        List<Member> loadedMembers = new ArrayList<>();
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            return new ArrayList<>();
        }
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            Scanner lineScanner = new Scanner(line).useDelimiter(";");
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            String fullName = lineScanner.next();
            String id = lineScanner.next();
            LocalDate birthday = LocalDate.parse(lineScanner.next(), formatter);
            LocalDate enrollmentDate = LocalDate.parse(lineScanner.next(), formatter);
            Member loadedMember = creater.create(fullName, id, birthday, enrollmentDate);
            loadedMembers.add(loadedMember);
        }
        return loadedMembers;
    }

    private List<Discipline> handleDisciplineLoading(String loadedString) {
        List<Discipline> disciplines = new ArrayList<>();
        String unArrayedString = loadedString.substring(1, loadedString.length()-1);
        if (unArrayedString.length() > 1) {
            String commaLess = unArrayedString.replace(",", "");
            String[] strDisciplineArray = commaLess.split(" ");
            for (String strDiscipline : strDisciplineArray) {
                disciplines.add(stringToEnum(strDiscipline));
            }
        }
        return disciplines;
    }

    private Discipline stringToEnum(String stringEnum) {
        switch (stringEnum) {
            case "BREAST" -> {
                return Discipline.BREAST;
            }
            case "CRAWL" -> {
                return Discipline.CRAWL;
            }
            case "BACKSTROKE" -> {
                return Discipline.BACKSTROKE;
            }
            case "BUTTERFLY" -> {
                return Discipline.BUTTERFLY;
            }
            default -> {
                return null;
            }
        }
    }
}
