package UI.Controllers.ConsoleUtils;


import UI.Contracts.ConsoleCursorConfig;

public class ConsoleCSICursorConfig implements ConsoleCursorConfig {
    private final String HIDE_CURSOR = "\33[?25l";
    private final String SHOW_CURSOR = "\33[?25h";

    @Override
    public void hideCursor() {
        System.out.printf(HIDE_CURSOR);
    }

    @Override
    public void showCursor() {
        System.out.printf(SHOW_CURSOR);
    }
}
