package UI.Controllers.Cashier.Screens;

import Backend.Contracts.BackendDomain;
import UI.Contracts.PrintScreen;
import UI.Contracts.PrintScreenByDomain;
import UI.Contracts.ReadUserInput;
import UI.Controllers.ConsoleUtils.PrintBlankScreen;
import UI.Controllers.ReadUserInput.ConsoleHaltForInput;

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
        _haltScreen.read();
        _printBlankScreen.print();
    }
}
