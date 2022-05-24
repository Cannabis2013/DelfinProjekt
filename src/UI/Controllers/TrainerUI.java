package UI.Controllers;

import Backend.Contracts.BackendDomain;
import UI.Contracts.Controller;
import UI.Contracts.PrintScreen;
import UI.Contracts.PrintScreenByDomain;
import UI.Contracts.ReadUserInput;
import UI.Models.CompetitionDetails;
import UI.PrintScreen.PrintMemberNotFoundScreen;
import UI.PrintScreen.PrintTop5;
import UI.PrintScreen.PrintTrainerOptions;
import UI.PrintScreen.RegisterCompetitionResultScreen;
import UI.ReadUserInput.DefaultReadUserOption;
import UI.ReadUserInput.ReadCompetitionDetails;

public class TrainerUI implements Controller {
    private final BackendDomain _backend;
    private PrintScreen _printTrainerOptions = new PrintTrainerOptions();
    private ReadUserInput <Integer> _readTrainerOption = new DefaultReadUserOption();

    private PrintScreen _registerCompetitionResultScreen = new RegisterCompetitionResultScreen();
    private PrintScreen _memberNotFoundScreen = new PrintMemberNotFoundScreen();
    private PrintScreenByDomain _printTop5 = new PrintTop5();
    private PrintScreenByDomain _printRegisterTrainingResult;
    ReadUserInput<CompetitionDetails> _readCompetitionResult = new ReadCompetitionDetails();

    public TrainerUI(BackendDomain backend) {
        _backend = backend;
    }

    private void registerCompetitionResult() {
        CompetitionDetails compDetails = _readCompetitionResult.read();
        _backend.registerCompetitionResult(compDetails.id(), compDetails.convention(), compDetails.date(), compDetails.rank(), compDetails.result());
        _registerCompetitionResultScreen.print();
    }

    public void run (){
        var running = true;
        while (running) {
            _printTrainerOptions.print();
            var command = _readTrainerOption.read();
            switch (command){
                case 1 -> _printRegisterTrainingResult.print(_backend);
                case 2 -> registerCompetitionResult();
                case 3 -> _printTop5.print(_backend);
                case 4 -> running = false;
            }
        }
    }
}
