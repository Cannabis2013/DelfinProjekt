package UI.PrintScreen;

import UI.Contracts.PrintScreen;

public class PrintDolphinWelcomeScreen implements PrintScreen {
    PrintScreen _printBlank = new PrintBlankScreen();
    PrintScreen _clearScrollBuffer = new ClearScrollBuffer();
    private final String hideCursor = "\33[?25l";
    private final String showCursor = "\33[?25h";
    private final String greenFont = "\33[32m";
    private final String reset = "\33[m";
    private final int LOAD_LIMIT = 4;
    private final int SLEEP_DURATION = 400;

    private void printLogo(){
        var logo = """
                    ---------------------
                    [ DELFIN - DATABASE ]
                    ---------------------
                """;
        System.out.println(greenFont + logo + reset);
    }

    private void eraseDots(){
        System.out.print("\33[3D");
        System.out.print("\33[K");
    }

    private void printLoading(){
        System.out.print("\33[?25l");
        var i = 0;
        System.out.print("Loading");
        while (i++ < LOAD_LIMIT){
            if(i % 4 == 0)
                eraseDots();
            else
                System.out.print(".");
            try {
                Thread.sleep(SLEEP_DURATION);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.print("\33[?25h");
    }

    @Override
    public void print() {
        _printBlank.print();
        printLogo();
        _clearScrollBuffer.print();
        printLoading();
        _printBlank.print();
    }
}
