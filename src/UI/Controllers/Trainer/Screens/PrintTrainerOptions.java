package UI.Controllers.Trainer.Screens;

import Backend.Contracts.BackendDomain;
import UI.Contracts.PrintScreen;

public class PrintTrainerOptions implements PrintScreen {
    @Override
    public void print(BackendDomain domain) {
        var menu = """
                1). Register training result
                2). Register competition result
                3). Print top five best swimmers
                4). Back to Main Menu
                """;
        System.out.println(menu);
    }
}
