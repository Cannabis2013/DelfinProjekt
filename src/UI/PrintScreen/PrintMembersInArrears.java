package UI.PrintScreen;

import Backend.Contracts.BackendDomain;
import UI.Contracts.PrintScreenByDomain;

public class PrintMembersInArrears implements PrintScreenByDomain {
    @Override
    public void print(BackendDomain domain) {
        /*
            TODO:
                Get objects from backend
                Print objects
         */
        var members = domain.membersInArrears();
        members.forEach(m -> System.out.println(m.name()));
    }
}
