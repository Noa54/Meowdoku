// colour, cellstate and guessresult enums and main

enum Colour{
    BLUE, RED, GREEN, YELLOW;
}

enum CellState{

    HIDDEN('_'), FOUND_CAT('C'), WRONG_GUESS('X');

    private final char symbol;

    private CellState(char symbol){
        this.symbol = symbol;
    }

    public char getSymbol(){
        return this.symbol;
    }

}

enum GuessResult{
    CORRECT(10, "Correct!"), WRONG(-1, "No cat there!"), ALREADY_GUESSED(0,"Position already guessed!");

    private int score;
    private final String message;

    private GuessResult(int score, String message){
        this.score = score;
        this.message = message;
    }

    public int getScore(){
        return score;
    }

    public String getMessage(){
        return message;
    }
}



public class A1 {

    public static void main(String[] args) {
        Player player = new SequentialPlayer("Player 1", 4);
        MeowdokuGame game = new MeowdokuGame(player, 4);
        game.play();

    }
}

