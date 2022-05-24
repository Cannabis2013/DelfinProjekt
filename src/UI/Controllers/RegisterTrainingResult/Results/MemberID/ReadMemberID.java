package UI.Controllers.RegisterTrainingResult.Results.MemberID;

import UI.Contracts.ReadUserInput;

import java.util.Scanner;

public class ReadMemberID implements ReadUserInput<String> {
    @Override
    public String read() {
        var id = new Scanner(System.in).nextLine();
        return id;
    }
}
