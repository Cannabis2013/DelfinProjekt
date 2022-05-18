package Backend.Members.Persistence;


import Backend.Members.CreateMembers.CreateDolphinMember;
import Backend.Members.CreateMembers.Discipline;
import Backend.Members.CreateMembers.Member;
import Backend.Members.CreateMembers.TrainingResult;
import Backend.Members.CreateTrainingResults.CreateDolphinResult;
import Backend.Members.CreateTrainingResults.CreateTrainingResult;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class SaveTrainingResultsAsCSV implements TrainingPersistence {

    @Override
    public void save(List<Member> members) {
        PrintStream stream = null;
        try {
            stream = new PrintStream("resources/training_results.csv");
        } catch (FileNotFoundException e) {
            return;
        }
        PrintStream finalStream = stream;

        members.forEach(member -> {
            member.trainingResults().forEach(result -> {
                String id = result.subscriberID;
                String team = result.team.toString();
                String discipline = result.discipline.toString();
                String time = result.result.toString();
                String queryString = String.format("%s;%s;%s;%s;\n", id, team, discipline, time);
                finalStream.print(queryString);
            });
        });
        finalStream.close();
        stream.close();
    }

    @Override
    public void load(List<Member> members) {
        File file = new File("resources/training_results.csv");
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            return;
        }

        while(scanner.hasNextLine()) {
            String line = scanner.nextLine();
            Scanner lineScanner = new Scanner(line).useDelimiter(";");

            String id = lineScanner.next();
            TrainingResult.Team team = teamStringToEnum(lineScanner.next());
            Discipline discipline = disciplineStrToEnum(lineScanner.next());
            LocalTime time = LocalTime.parse(lineScanner.next());


            TrainingResult newResult = resultCreator(id, team, discipline, time);

            members.forEach(member -> {
                Optional<Member> streamedMember = members.stream()
                        .filter(m -> m.subscriptionID().equals(newResult.subscriberID))
                        .findFirst();
                streamedMember.ifPresent(foundMember -> foundMember.trainingResults().add(newResult));
            });
        }
        scanner.close();

    }

    private TrainingResult resultCreator(String id, TrainingResult.Team team, Discipline discipline, LocalTime time) {
        TrainingResult newResult = new TrainingResult();
        newResult.subscriberID = id;
        newResult.discipline = discipline;
        newResult.result = time;
        newResult.team = team;
        return newResult;
    }

    private TrainingResult.Team teamStringToEnum(String stringified) {
        switch (stringified) {
            case "JUNIOR" -> {return TrainingResult.Team.JUNIOR;}
            case "SENIOR" -> {return TrainingResult.Team.SENIOR;}
            default -> {return null;}
        }
    }

    private Discipline disciplineStrToEnum(String stringEnum) {
        switch (stringEnum) {
            case "BREAST" -> {
                return Discipline.BREAST;
            }
            case "CRAWL" -> {
                return Discipline.CRAWL;
            }
            case "BACKSTROKE" -> {
                return Discipline.BACKSTROKE;
            }
            case "BUTTERFLY" -> {
                return Discipline.BUTTERFLY;
            }
            default -> {
                return null;
            }
        }
    }
}
