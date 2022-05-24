package UI.Controllers.RegisterMemberDetails.ContactInformation.ID;

import UI.Contracts.ReadUserInput;

import java.util.Scanner;

public class ReadID implements ReadUserInput<String> {
    @Override
    public String read() {
        return new Scanner(System.in).nextLine();
    }
}
