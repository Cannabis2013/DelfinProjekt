import UI.Controllers.MainUI;

public class Program {
    public static void main(String[] args) {
        try {
            new MainUI().displayUI_delfin();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
