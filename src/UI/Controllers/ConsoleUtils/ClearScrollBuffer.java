package UI.Controllers.ConsoleUtils;

import Backend.Contracts.BackendDomain;
import UI.Contracts.PrintScreen;

public class ClearScrollBuffer implements PrintScreen {
    @Override
    public void print(BackendDomain domain) {
        System.out.print("\33[3J");
    }
}
