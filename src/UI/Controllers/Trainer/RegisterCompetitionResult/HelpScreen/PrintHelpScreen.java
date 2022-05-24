package UI.Controllers.Trainer.RegisterCompetitionResult.HelpScreen;

import Backend.Contracts.BackendDomain;
import UI.Contracts.PrintScreen;

public class PrintHelpScreen implements PrintScreen {
    @Override
    public void print(BackendDomain domain) {
        var screen = """
                Dolphin results registration
                
                * Type in id as usual
                
                * Competition name
                  
                  Name of competition required.
                  
                  Ex.: Hillerød Svømme Stævne 2022
                
                * Time results
                  
                  Please enter results in accepted format as shown below:
                  
                  m:ss:CC (minutes, seconds, centi seconds)
                  
                  Examples of accepted results:
                  
                  Ex.: 0:24.44
                  Ex.: 12:01.12
                  
                * Date formats:
                
                  Examples of accepted date formats:
                  
                  5 august 2000
                  5 aug 2000
                  05-05-2000 (feel free to use your own delimiter)
                """;
        System.out.println(screen);
    }
}
