package MemberManagement.MemberManager;

import MemberManagement.CreateMembers.ICreateMember;
import MemberManagement.CreateMembers.IMember;
import MemberManagement.SubscriptionType;

import java.time.LocalDate;
import java.util.List;

public class MemberManager implements MemberContext{
    private ICreateMember _createRegular;
    private ICreateMember _createCompetitor;
    private IMembersContext _membersContext;
    public MemberManager(){
        // Load models
    }

    @Override
    public void addRegular(String name, LocalDate birthDay, boolean passive) {
        var member = _createRegular.create(name,birthDay,passive);
        _membersContext.addMember(member);
    }

    @Override
    public void addCompetitor(String name, LocalDate birthDay, boolean passive) {
        var member = _createRegular.create(name,birthDay,passive);
        _membersContext.addMember(member);
    }

    @Override
    public List<IMember> members() {
        return _membersContext.members();
    }

    @Override
    public List<IMember> regularMembers() {
        var members = _membersContext.members();
        var regulars = members.stream()
                .filter(m -> m.subscriptionType() == SubscriptionType.REGULAR)
                .toList();
        return regulars;
    }

    @Override
    public List<IMember> competitionMembers() {
        var members = _membersContext.members();
        var competitors = members.stream()
                .filter(m -> m.subscriptionType() == SubscriptionType.COMPETITION)
                .toList();
        return competitors;
    }
}
