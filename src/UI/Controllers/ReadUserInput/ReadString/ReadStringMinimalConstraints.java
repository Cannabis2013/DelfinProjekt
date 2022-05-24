package UI.Controllers.ReadUserInput.ReadString;

import UI.Contracts.ReadUserInput;

import java.util.Scanner;

public class ReadStringMinimalConstraints implements ReadUserInput<String> {
    @Override
    public String read() {
        var string = new Scanner(System.in).nextLine();
        return string;
    }
}
