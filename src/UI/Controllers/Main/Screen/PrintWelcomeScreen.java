package UI.Controllers.Main.Screen;

import Backend.Contracts.BackendDomain;
import UI.Contracts.PrintScreen;
import UI.Controllers.ConsoleUtils.ClearScrollBuffer;
import UI.Controllers.ConsoleUtils.PrintBlankScreen;

public class PrintWelcomeScreen implements PrintScreen {
    PrintScreen _printBlank = new PrintBlankScreen();
    PrintScreen _clearScrollBuffer = new ClearScrollBuffer();

    private void printLogo(){
        var logo = """
                    ---------------------
                    [ DELFIN - DATABASE ]
                    ---------------------
                """;
        String greenFont = "\33[32m";
        String reset = "\33[m";
        System.out.println(greenFont + logo + reset);
    }

    private void eraseDots(){
        System.out.print("\33[3D");
        System.out.print("\33[K");
    }

    private void printLoading(){
        var i = 0;
        System.out.print("Loading");
        int LOAD_LIMIT = 3;
        while (i++ < LOAD_LIMIT){
            if(i % 4 == 0)
                eraseDots();
            else
                System.out.print(".");
            try {
                int SLEEP_DURATION = 400;
                Thread.sleep(SLEEP_DURATION);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public void print(BackendDomain domain) {
        _printBlank.print(null);
        printLogo();
        _clearScrollBuffer.print(null);
        printLoading();
        _printBlank.print(null);
    }
}
