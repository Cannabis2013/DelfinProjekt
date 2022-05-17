import MemberManagement.MemberManager.MemberManager;

import java.time.LocalDate;
import java.util.Random;

public class Program {
    public static void main(String[] args) {
        Program pg = new Program();
        MemberManager manager = new MemberManager();

        for (int i = 0; i < 1000; i++) {
            int randomYear = pg.getRandomValue(1950, 2019);
            int randomMonth = pg.getRandomValue(1, 13);
            int randomDay = pg.getRandomValue(1, 29);
            manager.add("fornavn efternavn mellemnavn", LocalDate.of(randomYear, randomMonth, randomDay));
        }
        manager.csvSave();
    }

    public int getRandomValue(int lowerBound, int upperBound) {
        Random random = new Random();
        return random.nextInt(lowerBound, upperBound);
    }
}
