package UI.PrintScreen;

import UI.Contracts.PrintScreen;

public class PrintTrainerOptions implements PrintScreen {
    @Override
    public void print() {
        var menu = """
                1). Register training result
                2). Register competition result
                3). Print top five best swimmers
                4). Back
                """;
        System.out.println(menu);
    }
}
