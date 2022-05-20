package UI.PrintScreen;

import Backend.Competition.CreateTrainingResults.Discipline;
import Backend.Competition.CreateTrainingResults.TrainingResult;
import Backend.Contracts.BackendDomain;
import UI.Contracts.PrintScreenByDomain;
import UI.ReadUserInput.ReadMemberTrainingDetails;

import java.time.LocalDate;
import java.time.LocalTime;

public class RegisterTrainingResultScreen implements PrintScreenByDomain {
    ReadMemberTrainingDetails memberTrainingDetails = new ReadMemberTrainingDetails();

    @Override
    public void print(BackendDomain domain) {
        memberTrainingDetails.read();

        TrainingResult result = domain.registerResult(String id, LocalTime result, Discipline discipline, LocalDate date);
        result.forEach(r -> System.out.println(r.result()));



        /* TODO:
                - Read name from user (String)
                - Read result from user (LocalTime)
                - Read discipline from user (Discipline)
                - Read date from user (LocalDate)
                - Call registerResult from BackendDomain
         */
    }
}
