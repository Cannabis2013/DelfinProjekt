import UI.*;

public class Program {
    public static void main(String[] args) {
        try {
            new UI().displayUI_delfin();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
