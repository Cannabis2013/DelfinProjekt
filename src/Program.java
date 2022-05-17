import MemberManagement.MemberManager.MemberManager;

public class Program {
    public static void main(String[] args) {
        var generator = new GenerateRandomData();
        var manager = new MemberManager();
        if(manager.members().size() == 0)
            generator.generateRandomUsers(10,manager);
    }
}
