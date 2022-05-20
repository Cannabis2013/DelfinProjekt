package Backend.Members.Persistence;

import Backend.Contracts.Members.Member;
import Backend.Contracts.Persistence.Persistence;
import Backend.Members.CreateMembers.CreateDolphinMember;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SaveMembersAsCSV implements Persistence<Member> {
    private final String FOLDER_NAME = "resources";
    private final String FILE_NAME = "members.csv";

    private PrintStream instantiateStream(){
        var path = FOLDER_NAME + "/" + FILE_NAME;
        PrintStream stream = null;
        try {
            stream = new PrintStream("resources/members.csv");
        } catch (FileNotFoundException e) {
            return null;
        }
        return stream;
    }

    private String toCSVLine(Member member){
        String fullName = member.name();
        String id = member.subscriptionID();
        String birthDate = member.birthDate().toString();
        String enrollment = member.dateEnrolled().toString();
        boolean hasPaid = member.hasNotPaid();
        var csvLineAsString = String.format("%s;%s;%s;%s;%s;\n", fullName, id, birthDate, enrollment, hasPaid);
        return csvLineAsString;
    }

    private void createFolderIfNotExist(){
        var folder = new File(FOLDER_NAME);
        if(!folder.isDirectory())
            folder.mkdir();
    }

    @Override
    public void save(List<Member> members) {
        createFolderIfNotExist();
        var fileOut = instantiateStream();
        for (Member member : members) {
            var csvLineAsString = toCSVLine(member);
            fileOut.print(csvLineAsString);
        }
        fileOut.close();
    }

    @Override
    public List<Member> load() {
        File file = new File("resources/members.csv");
        CreateDolphinMember creator = new CreateDolphinMember();
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
            String fullName = lineScanner.next();
            String id = lineScanner.next();
            String birthday = lineScanner.next();
            String enrollmentDate = lineScanner.next();
            Member loadedMember = creator.create(fullName, id, birthday, enrollmentDate);
            loadedMembers.add(loadedMember);
        }
        return loadedMembers;
    }
}
