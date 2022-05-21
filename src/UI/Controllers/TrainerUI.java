package UI.Controllers;

import Backend.Contracts.BackendDomain;
import Backend.Members.MemberManager.MemberNotFoundException;
import UI.Contracts.Controller;
import UI.Contracts.PrintScreen;
import UI.Contracts.PrintScreenByDomain;
import UI.Contracts.ReadUserInput;
import UI.Models.CompetitionDetails;
import UI.Models.TrainingDetails;
import UI.PrintScreen.PrintMemberNotFoundScreen;
import UI.PrintScreen.PrintTop5;
import UI.PrintScreen.PrintTrainerOptions;
import UI.PrintScreen.RegisterCompetitionResultScreen;
import UI.ReadUserInput.DefaultReadUserOption;
import UI.ReadUserInput.ReadMemberCompetitionResultDetails;
import UI.ReadUserInput.ReadMemberTrainingDetails;

public class TrainerUI implements Controller {
    private final BackendDomain _backend;
    private PrintScreen _printTrainerOptions = new PrintTrainerOptions();
    private ReadUserInput <Integer> _readTrainerOption = new DefaultReadUserOption();

    private PrintScreen _registerCompetitionResultScreen = new RegisterCompetitionResultScreen();
    private PrintScreen _memberNotFoundScreen = new PrintMemberNotFoundScreen();
    private PrintScreenByDomain _printTop5 = new PrintTop5();
    ReadUserInput<TrainingDetails> _readTrainingResult = new ReadMemberTrainingDetails();
    ReadUserInput<CompetitionDetails> _readCompetitionResult = new ReadMemberCompetitionResultDetails();

    public TrainerUI(BackendDomain backend) {
        _backend = backend;
    }

    private void registerTrainingResult(){
        var details = _readTrainingResult.read();
        try {
            _backend.registerResult(details.id(),details.result(),details.discipline(),details.date());
        } catch (MemberNotFoundException e){
            _memberNotFoundScreen.print();
        }
    }

    private void registerCompetitionResult() {
        CompetitionDetails compDetails = _readCompetitionResult.read();
        _backend.registerConventionResult(compDetails.id(), compDetails.convention(), compDetails.date(), compDetails.rank(), compDetails.result());
        _registerCompetitionResultScreen.print();
    }

    public void run (){
        var running = true;
        while (running) {
            _printTrainerOptions.print();
            var command = _readTrainerOption.read();
            switch (command){
                case 1 -> registerTrainingResult();
                case 2 -> registerCompetitionResult();
                case 3 -> _printTop5.print(_backend);
                case 4 -> running = false;
            }
        }
    }
}
