package UI.Controllers.RegisterCompetitionResult.CompetitionResult.Rank;

import UI.Contracts.ReadUserInput;

import java.util.Scanner;

public class ReadCompetitionRank implements ReadUserInput<Integer> {
    private boolean validate(int rank){
        return rank == -1 || rank >= 1;
    }

    @Override
    public Integer read() {
        var input = new Scanner(System.in).nextLine();
        int rank;
        try {
            rank = Integer.parseInt(input);
        } catch (NumberFormatException e){
            return -1;
        }
        if(!validate(rank))
            return -1;
        return rank;
    }
}
