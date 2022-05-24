package UI.Controllers;

import Backend.Contracts.BackendDomain;
import UI.Contracts.Controller;
import UI.Contracts.PrintScreen;
import UI.Contracts.PrintScreenByDomain;
import UI.Contracts.ReadUserInput;
import UI.Controllers.PrintScreen.PrintMemberNotFoundScreen;
import UI.Controllers.PrintScreen.PrintTop5;
import UI.Controllers.PrintScreen.PrintTrainerOptions;
import UI.Controllers.ReadUserInput.DefaultReadUserOption;
import UI.Controllers.RegisterCompetitionResult.RegisterCompetitionResultScreen;
import UI.Controllers.RegisterTrainingResult.PrintRegisterTrainingResult;

public class TrainerUI implements Controller {
    private final BackendDomain _backend;
    private PrintScreen _printTrainerOptions = new PrintTrainerOptions();
    private ReadUserInput <Integer> _readTrainerOption = new DefaultReadUserOption();

    private PrintScreen _memberNotFoundScreen = new PrintMemberNotFoundScreen();
    private PrintScreenByDomain _printTop5 = new PrintTop5();
    private PrintScreenByDomain _printRegisterTrainingResult = new PrintRegisterTrainingResult();
    PrintScreenByDomain _readCompetitionResult = new RegisterCompetitionResultScreen();

    public TrainerUI(BackendDomain backend) {
        _backend = backend;
    }

    public void run (){
        var running = true;
        while (running) {
            _printTrainerOptions.print();
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
