package UI.Controllers.ReadUserInput;

import UI.Contracts.ReadUserInput;

import java.util.Scanner;

public class ReadConfirmation implements ReadUserInput<Boolean> {
    @Override
    public Boolean read() {
        var input = new Scanner(System.in).nextLine();
        return input.equals("y") || input.equals("Y");
    }
}
