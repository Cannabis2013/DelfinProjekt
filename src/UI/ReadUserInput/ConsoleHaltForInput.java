package UI.ReadUserInput;

import UI.Contracts.ReadUserInput;

import java.util.Scanner;

public class ConsoleHaltForInput implements ReadUserInput<String> {
    private final String HIDE_CURSOR = "\33[?25l";
    private final String SHOW_CURSOR = "\33[?25h";
    private final String _reset = "\33[m";
    @Override
    public String read() {
        System.out.print(HIDE_CURSOR);
        System.out.print("PRESS A KEY..");
        var result = new Scanner(System.in).nextLine();
        System.out.println(SHOW_CURSOR);
        return result;
    }
}
