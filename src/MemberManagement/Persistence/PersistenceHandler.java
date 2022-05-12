package MemberManagement.Persistence;

import MemberManagement.CreateMembers.IMember;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PersistenceHandler implements Persistence{

    File file = new File("resources/members.csv");

    @Override
    public void save(List<IMember> members) throws FileNotFoundException {
        if (file.exists() && !file.isDirectory()) {
            PrintStream out = new PrintStream(file);
            members.forEach(member -> {
                saveMember(out, member);
            });
        }
    }

    @Override
    public List<IMember> load() throws FileNotFoundException {
        List<IMember> members = new ArrayList<>();
        if (file.exists() && !file.isDirectory()) {
            Scanner scanner = new Scanner(file);
        }
        return members;
    }

    private void saveMember(PrintStream out, IMember member) {
        out.print(member.name());
        out.print(";");
        out.print(member.subscriptionID());
        out.print(";");
        out.print(member.subscriptionType());
        out.print(";");
        out.print(member.coach());
        out.print(";");
        out.print(member.birthDate());
        out.print(";");
        out.print(member.status());
        out.print(";");
        out.print(member.dateEnrolled());
        out.print(";");
        out.print(member.lastPayment());
        out.print(";");
        out.print(member.disciplines());
        out.print("\n");
    }
}
