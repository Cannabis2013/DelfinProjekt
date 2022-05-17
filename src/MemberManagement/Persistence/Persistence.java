package MemberManagement.Persistence;

import MemberManagement.CreateMembers.CreateDolphinMember;
import MemberManagement.CreateMembers.Member;
import MemberManagement.Discipline;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Persistence implements IPersistence {


    @Override
    public void save(List<Member> members) throws FileNotFoundException {
        PrintStream stream = new PrintStream("resources/members.csv");
        for (Member member : members) {
            String fullName = member.name();
            String id = member.subscriptionID();
            String birthDate = member.birthDate().toString();
            String enrollment = member.dateEnrolled().toString();
            boolean hasPaid = member.hasPaid();
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
            boolean hasPaid = Boolean.getBoolean(lineScanner.next());
            List<Discipline> disciplines = handleDisciplineLoading(lineScanner.next());

            Member loadedMember = creater.loadMember(fullName, id, birthday, enrollmentDate, hasPaid, disciplines);
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
