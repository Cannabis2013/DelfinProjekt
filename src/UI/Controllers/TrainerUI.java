package UI.Controllers;

import Backend.Contracts.BackendDomain;
import UI.Contracts.PrintScreen;
import UI.Contracts.PrintScreenByDomain;
import UI.Contracts.ReadUserInput;
import UI.Models.TrainingDetails;
import UI.PrintScreen.PrintTop5;
import UI.PrintScreen.PrintTrainerOptions;
import UI.ReadUserInput.DefaultReadUserOption;
import UI.ReadUserInput.ReadMemberTrainingDetails;

public class TrainerUI {
    private final BackendDomain _backend;
    private PrintScreen _printTrainerOptions = new PrintTrainerOptions();
    private ReadUserInput <Integer> _readTrainerOption = new DefaultReadUserOption();
    private PrintScreenByDomain _registerCompetitionResultScreen;
    private PrintScreenByDomain _printTop5 = new PrintTop5();
    ReadUserInput<TrainingDetails> _readTrainingResult = new ReadMemberTrainingDetails();

    public TrainerUI(BackendDomain backend) {
        _backend = backend;
    }

    private void registerTrainingResult(){
        var details = _readTrainingResult.read();
        _backend.registerResult(details.id(),details.result(),details.discipline(),details.date());
    }

    public void run (){
        var running = true;
        while (running) {
            _printTrainerOptions.print();
            var command = _readTrainerOption.read();
            switch (command){
                case 1 -> registerTrainingResult();
                case 2 -> _registerCompetitionResultScreen.print(_backend);
                case 3 -> _printTop5.print(_backend);
                case 4 -> running = false;
            }
        }
    }


}
