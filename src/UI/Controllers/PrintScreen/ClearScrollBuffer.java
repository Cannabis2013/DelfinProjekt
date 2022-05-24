package UI.Controllers.PrintScreen;

import UI.Contracts.PrintScreen;

public class ClearScrollBuffer implements PrintScreen {
    @Override
    public void print() {
        System.out.print("\33[3J");
    }
}
