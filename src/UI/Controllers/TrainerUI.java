package UI.Controllers;

import Backend.Contracts.BackendDomain;
import UI.Contracts.PrintScreen;
import UI.Contracts.PrintScreenByDomain;
import UI.Contracts.ReadUserInput;
import UI.PrintScreen.PrintTrainerOptions;
import UI.PrintScreen.RegisterTrainingResultScreen;
import UI.ReadUserInput.DefaultReadUserOption;

public class TrainerUI {
    private final BackendDomain _backend;
    private PrintScreen _printTrainerOptions = new PrintTrainerOptions();
    private ReadUserInput <Integer> _readTrainerOption = new DefaultReadUserOption();
    private PrintScreenByDomain _registerTrainingResultScreen = new RegisterTrainingResultScreen();
    private PrintScreenByDomain _registerCompetitionResultScreen;
    private PrintScreenByDomain _printTop5;

    public TrainerUI(BackendDomain backend) {
        _backend = backend;
    }

    public void run (){
        var running = true;
        while (running) {
            _printTrainerOptions.print();
            var command = _readTrainerOption.read();
            switch (command){
                case 1 -> _registerTrainingResultScreen.print(_backend);
                case 2 -> _registerCompetitionResultScreen.print(_backend);
                case 3 -> _printTop5.print(_backend);
                case 4 -> running = false;
            }
        }
    }


}
