package MemberManagement.MemberManager;

import MemberManagement.CreateMembers.CreateDolphinMember;
import MemberManagement.CreateMembers.CreateMember;
import MemberManagement.CreateMembers.Member;
import MemberManagement.Persistence.iManager;
import MemberManagement.Persistence.iCSVPersistence;
import MemberManagement.Persistence.CSVPersistence;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class MemberManager implements MemberContext, iManager {
    private CreateMember _createMember = new CreateDolphinMember();
    private Entities<Member> _members = new DolphinMembers();
    private iCSVPersistence _persistMembers = new CSVPersistence();

    @Override
    public String file_path() {
        return "resources/members.csv";
    }


    public MemberManager(){
        List<Member> members;
        try {
            members = _persistMembers.load(this);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        _members.set(members);
    }

    @Override
    public void add(String name, LocalDate birthDay) {
        var member = _createMember.create(name,birthDay);
        _members.add(member);
    }

    @Override
    public Member member(String id) {
        var members = _members.entities();
        var memberOptional = members.stream()
                .filter(m -> m.subscriptionID().equals(id)).findFirst();
        if(!memberOptional.isPresent())
            return null;
        return memberOptional.get();
    }

    @Override
    public List<Member> members() {
        return _members.entities();
    }

    @Override
    public void save() {
        var members = _members.entities();
        try {
            _persistMembers.save(file_path(), members);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void load() {
        List<Member> fetched;
        try {
            fetched = _persistMembers.load(this);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        _members.set(fetched);
    }

    @Override
    public Object loadScheme(Scanner lineScanner) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String fullName = lineScanner.next();
        String id = lineScanner.next();
        LocalDate birthday = LocalDate.parse(lineScanner.next(), formatter);
        LocalDate enrollmentDate = LocalDate.parse(lineScanner.next(), formatter);
        return _createMember.loadMember(fullName, id, birthday, enrollmentDate);
    }



}
