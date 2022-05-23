package UI.PrintScreen;

import UI.Contracts.PrintScreen;

import java.awt.*;

public class PrintBlankScreen implements PrintScreen {
    private void printBlank(){
        var dim = Toolkit.getDefaultToolkit().getScreenSize();
        int screenHeight = dim.height;
        for (var i = 0;i <screenHeight;i++)
            System.out.println();
    }

    @Override
    public void print() {
        System.out.print("\33[2J\33[2H");
        printBlank();
        System.out.flush();
    }
}
