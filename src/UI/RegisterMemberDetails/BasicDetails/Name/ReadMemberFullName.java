package UI.RegisterMemberDetails.BasicDetails.Name;

import UI.Contracts.ReadUserInput;

import java.util.Scanner;

public class ReadMemberFullName implements ReadUserInput<String> {
    private final String REGEX = "^\\w*\\s+[A-z ]*\\w*$";

    @Override
    public String read() {
        var reader = new Scanner(System.in);
        var input = reader.nextLine();
        if(input.matches(REGEX))
            return input;
        throw new MemberNameNotValid();
    }
}
