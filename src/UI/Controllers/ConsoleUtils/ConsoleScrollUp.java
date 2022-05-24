package UI.Controllers.ConsoleUtils;

import UI.Contracts.ClearLines;

public class ConsoleScrollUp implements ClearLines {
    @Override
    public void clear(int lines) {
        for (var i = 0;i < lines;i++)
            System.out.print("\33[2K");
        System.out.printf("\33[%dT",lines);
        System.out.printf("\33[3J");
    }
}
