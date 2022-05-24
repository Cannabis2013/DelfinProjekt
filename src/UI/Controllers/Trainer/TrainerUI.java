package UI.Controllers.Trainer;

import Backend.Contracts.BackendDomain;
import UI.Contracts.Controller;
import UI.Contracts.PrintScreen;
import UI.Contracts.ReadUserInput;
import UI.Controllers.ConsoleUtils.PrintMemberNotFoundScreen;
import UI.Controllers.ReadUserInput.DefaultReadUserOption;
import UI.Controllers.Trainer.RegisterCompetitionResult.RegisterCompetitionResultScreen;
import UI.Controllers.Trainer.RegisterTrainingResult.PrintRegisterTrainingResult;
import UI.Controllers.Trainer.Screens.PrintTop5;
import UI.Controllers.Trainer.Screens.PrintTrainerOptions;

public class TrainerUI implements Controller {
    private final BackendDomain _backend;
    private PrintScreen _printTrainerOptions = new PrintTrainerOptions();
    private ReadUserInput <Integer> _readTrainerOption = new DefaultReadUserOption();

    private PrintScreen _memberNotFoundScreen = new PrintMemberNotFoundScreen();
    private PrintScreen _printTop5 = new PrintTop5();
    private PrintScreen _printRegisterTrainingResult = new PrintRegisterTrainingResult();
    PrintScreen _readCompetitionResult = new RegisterCompetitionResultScreen();

    public TrainerUI(BackendDomain backend) {
        _backend = backend;
    }

    public void run (){
        var running = true;
        while (running) {
            _printTrainerOptions.print(null);
            var command = _readTrainerOption.read();
            switch (command){
                case 1 -> _printRegisterTrainingResult.print(_backend);
                case 2 -> _readCompetitionResult.print(_backend);
                case 3 -> _printTop5.print(_backend);
                case 4 -> running = false;
            }
        }
    }
}
