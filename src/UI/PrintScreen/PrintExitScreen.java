package UI.PrintScreen;

import UI.Contracts.PrintScreen;

public class PrintExitScreen implements PrintScreen {
    PrintScreen _printBlankScreen = new PrintBlankScreen();
    PrintScreen _clearScrollBuffer = new ClearScrollBuffer();

    private void clearScreen(){
        _printBlankScreen.print();
        _clearScrollBuffer.print();
    }

    @Override
    public void print() {
        clearScreen();
        System.out.println("""                                  
                                ------------------------------------------------------------
                                Have a good day. Thanks for using Dolphin Member Management.
                                
                                If you had any problems, please feel free to call our fantastic developer team:
                                
                                Stefan Jensen (Lead programming, organizing)
                                Mail: stkea@kea.com
                                
                                Martin Hansen (Software engineering)
                                Mail: MH2012@outlook.dk
                                
                                Murat Kaan (Ideas, UI design)
                                Mail: Unknown
                                
                                Nikki Delorian (UI design, analytics, organizing)
                                Mail: Unknown
                                ------------------------------------------------------------
                                """);
    }
}
