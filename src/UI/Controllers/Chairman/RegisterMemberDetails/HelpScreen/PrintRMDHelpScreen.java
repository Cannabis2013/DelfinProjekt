package UI.Controllers.Chairman.RegisterMemberDetails.HelpScreen;

import Backend.Contracts.BackendDomain;
import UI.Contracts.PrintScreen;

public class PrintRMDHelpScreen implements PrintScreen {
    @Override
    public void print(BackendDomain domain) {
        var msg = """
                Dolphin member registration.
                
                * Please provide full name
                  Ex. of accepted formats : Martin Hansen, Murat Kaan Arici
                  Ex. of not accepted formats: Martin, Murat, Nikki
                  
                * Accepted date formats: 3 feb 2012, 3 february 2012, 03-02-2012
                  
                  Note: Months in letters are matched against danish and english abbreviations/names
                  
                  Ex. : January and Januar always match. Likewise for abbreviations.
                  
                * Disciplines:
                  
                  The following disciplines are all marked with a number id:
                    
                  CRAWL(1) BREAST(2) BUTTERFLY(3) BACKSTROKE(4)
                  
                  You can use numbers or names (case insensitive), but don't mix. Please see examples below:
                  
                  Accepted formats:
                    
                  Ex.: 2 3 4 (BREAST, BUTTERFLY,BACKSTROKE)
                  Ex.: BREAST BACKSTROKE CRAWL
                  
                  Not accepted formats:
                  
                  Ex.: 2 CRAWL 3
                """;
        System.out.println(msg);
    }
}
