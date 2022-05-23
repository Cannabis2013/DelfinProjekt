package UI.PrintScreen.RegisterBasicMemberDetails;

import Backend.Contracts.BackendDomain;
import UI.Contracts.PrintScreenByDomain;

public class PrintRegisterBasicDetailsScreen implements PrintScreenByDomain {
    private void printMessage(){
        var msg = """
                Dolphin user registration.
                * Please use full name
                * Please enter date in format dd-MM-yyyy (Ex. 02-04-1985)
                * As a competitor, please type in desired disciplines separated by slash
                    * Disciplines: [CRAWL(1), BREAST(2), BUTTERFLY(3), BACKSTROKE(4)]
                """;
        System.out.println(msg);
    }

    @Override
    public void print(BackendDomain domain) {
        var id = new RegisterMemberBasicDetails().register(domain);

    }
}
