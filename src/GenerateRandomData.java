import MemberManagement.Discipline;
import MemberManagement.MemberManager.MemberManager;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GenerateRandomData {

    public void generateRandomUsers(int amount, MemberManager manager) {
        for (int i = 0; i < amount; i++) {
            int randomYear = getRandomValue(1950, 2019);
            int randomMonth = getRandomValue(1, 13);
            int randomDay = getRandomValue(1, 29);
            boolean hasPaid = getRandomValue(2) == 1;
            List<Discipline> disciplines = new ArrayList<>();
            disciplines.add(Discipline.BACKSTROKE);
            disciplines.add(Discipline.BREAST);
            manager.add("RandomName", LocalDate.of(randomYear, randomMonth, randomDay), hasPaid, disciplines);
        }
        manager.csvSave();
    }


    private int getRandomValue(int lowerBound, int upperBound) {
        Random random = new Random();
        return random.nextInt(lowerBound, upperBound);
    }
    private int getRandomValue(int upperBound) {
        Random random = new Random();
        return random.nextInt(upperBound);
    }


}
