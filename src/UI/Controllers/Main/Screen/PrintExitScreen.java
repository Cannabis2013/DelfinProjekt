package UI.Controllers.Main.Screen;

import Backend.Contracts.BackendDomain;
import UI.Contracts.PrintScreen;
import UI.Controllers.ConsoleUtils.ClearScrollBuffer;

public class PrintExitScreen implements PrintScreen {
    PrintScreen _clearScrollBuffer = new ClearScrollBuffer();


    @Override
    public void print(BackendDomain domain) {
        System.out.println("""                                  
                                ------------------------------------------------------------
                                Have a good day. Thanks for using Dolphin Member Management.
                                
                                Dolphin Member Management is developed by TEAM SCUFFED.
                                Founded in 2022 April 12. by two dedicated developers Martin Hansen and Stefan
                                Jensen. Both known and feared for writing really scuffed code.
                                
                                The former was responsible for halting the train system in New York for several
                                weeks back in 2016, as he was the lead programmer on a new software project. 
                                He, and his group of scuffed developers, developed a controller software,
                                that was meant to prevent collisions with other trains. He caused havoc on several 
                                stations as trains collided due to his insistence on really scuffed code. 
                                Because of this incident, Martin Hansen is banned in the United States of America, 
                                and is prohibited work and development on any software that involves trains, busses, 
                                flights, and other areas that could cause harm on people. Also, he must not use the 
                                train anymore.
                                
                                Stefan Jensen, the apprentice of Martin Hansen, was a big admirer of Martins
                                somewhat scuffed approach to project structure. Writing scuffed code was a
                                domain that he sincerely opted for. He was involved in various scandals when
                                he was an employee at CSC in Copenhagen. Scandals that resulted in great losses
                                for CSC and they were also involved in several stock market manipulation scandals.
                                As of this, no one must ever hire Stefan Jensen again.
                                
                                Now Martin and Stefan runs a dark empire where they ensnares other young developers
                                into writing really bad code. Scuffed code.
                                
                                Martin Hansen (Scuff coder)
                                Stefan Jensen (Scuff master)
                                Murat Kaan (Provider of scuffed ideas)
                                Nikki Delorian (Scuffed UI design, scuffed analytics, scuffed organizing)
                                ------------------------------------------------------------
                                """);
        _clearScrollBuffer.print(null);
    }
}
