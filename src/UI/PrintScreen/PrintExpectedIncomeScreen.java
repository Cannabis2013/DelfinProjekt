package UI.PrintScreen;

import Backend.Contracts.BackendDomain;
import UI.Contracts.PrintScreen;
import UI.Contracts.PrintScreenByDomain;
import UI.Contracts.ReadUserInput;
import UI.ReadUserInput.ConsoleHaltForInput;

import java.util.Scanner;

public class PrintExpectedIncomeScreen implements PrintScreenByDomain {
    private PrintScreen _printBlankScreen = new PrintBlankScreen();
    private ReadUserInput<String> _haltScreen = new ConsoleHaltForInput();
    @Override
    public void print(BackendDomain domain) {
        var incomeInfo = domain.expectedEarnings();
        System.out.println(String.format("""
                -----------------
                You can expect %s
                income this year
                -----------------
                """, incomeInfo));

        Scanner keyboard = new Scanner(System.in);
        _haltScreen.read();
        _printBlankScreen.print();
    }
}
