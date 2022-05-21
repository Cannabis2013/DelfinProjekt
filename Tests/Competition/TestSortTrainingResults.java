package Competition;

import Backend.Competition.SortCompetitors.Predicates.SortByAgeAndResults;
import Backend.Competition.SortCompetitors.TrimSortedSwimmers.TrimDolphinTrainingResults;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class TestSortTrainingResults {
    @Test
    public void testSorting(){
        String[] ids = {"8","7","9","15","11","14","13","16","10","12","6","3",
                "1","2","5","4","24","23","25","31","27","30","29","32","26","28",
                "22","19","17","18","21","20"};
        var exp = List.of(ids).stream().toList();
        var predicate = new SortByAgeAndResults();
        var results = new CreateBadgeOfResults().createBadgeOne();
        results.sort(predicate);
        var act = results.stream().map(r -> r.subscriberID).toList();
        Assertions.assertTrue(exp.equals(act));
    }

    @Test
    public void testTrim(){
        String[] ids = {"8","7","9","15","11","14","13","16","6","3",
                "1","2","5","24","23","25","31","27","30","29","32",
                "22","19","17","18","21"};
        var exp = List.of(ids).stream().toList();
        var predicate = new SortByAgeAndResults();
        var results = new CreateBadgeOfResults().createBadgeOne();
        results.sort(predicate);
        var trimmer = new TrimDolphinTrainingResults();
        var trimmed = trimmer.trim(results);
        var act = trimmed.stream().map(t -> t.subscriberID).toList();
        Assertions.assertTrue(exp.equals(act));
    }
}
