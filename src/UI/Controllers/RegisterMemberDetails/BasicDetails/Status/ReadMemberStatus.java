package UI.Controllers.RegisterMemberDetails.BasicDetails.Status;

import UI.Contracts.ReadUserInput;
import java.util.Scanner;

public class ReadMemberStatus implements ReadUserInput<Boolean> {
    @Override
    public Boolean read() {
        var scanner = new Scanner(System.in);
        var input = scanner.nextLine();
        return input.matches("1");
    }
}
