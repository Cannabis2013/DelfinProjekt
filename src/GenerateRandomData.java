import Backend.Members.CreateMembers.Discipline;
import Backend.Members.DolphinMembers;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class GenerateRandomData {
    private Discipline getDiscipline(int index){
        switch (index){
            case 1 : return Discipline.CRAWL;
            case 2 : return Discipline.BREAST;
            case 3 : return Discipline.BUTTERFLY;
            default: return Discipline.BACKSTROKE;
        }
    }

    List<Discipline> getRandomDisciplines(){
        var disciplines = new ArrayList<Discipline>();
        var ints = new ArrayList<Integer>(){{
            add(0);add(1);add(2);add(3);
        }};
        Collections.shuffle(ints);
        var rand = new Random();
        var numberOfDisciplines = rand.nextInt(disciplines.size());
        for (var i = 0;i < numberOfDisciplines;i++){
            var index = ints.get(i);
            var discipline = getDiscipline(index);
            disciplines.add(discipline);
        }
        return disciplines;
    }

    public void generateRandomUsers(int amount, DolphinMembers manager) {
        for (int i = 0; i < amount; i++) {
            int randomYear = getRandomValue(1950, 2019);
            int randomMonth = getRandomValue(1, 13);
            int randomDay = getRandomValue(1, 29);
            List<Discipline> disciplines = getRandomDisciplines();
            manager.add("RandomName", LocalDate.of(randomYear, randomMonth, randomDay), true, "");
        }
        manager.save();
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
