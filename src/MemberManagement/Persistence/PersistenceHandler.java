package MemberManagement.Persistence;

import MemberManagement.CreateMembers.Member;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PersistenceHandler implements Persistence{

    File file = new File("resources/members.csv");

    @Override
    public void save(List<Member> members) throws FileNotFoundException {
        if (file.exists() && !file.isDirectory()) {
            PrintStream out = new PrintStream(file);
            members.forEach(member -> {
                saveMember(out, member);
            });
        }
    }

    @Override
    public List<Member> load() throws FileNotFoundException {
        List<Member> members = new ArrayList<>();
        if (file.exists() && !file.isDirectory()) {
            Scanner scanner = new Scanner(file);
        }
        return members;
    }

    private void saveMember(PrintStream out, Member member) {
        out.print(member.foreName());
        out.print(";");
        out.print(member.subscriptionID());
        out.print(";");
        out.print(member.birthDate());
        out.print(";");
        out.print(member.dateEnrolled());
        out.print(";");
        out.print("\n");
    }
}
