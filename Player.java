// Player stores player information and statistics

abstract class Player{
    private String name;
    private int guesses, catsFound, score;
    protected int size;

    public Player(String name, int size){
        this.name = name;
        this.guesses = 0;
        this.catsFound = 0;
        this.score = 0;
        this.size = size;
    }

    public int getScore(){
        return score;
    }

    public void recordGuess(GuessResult result){
        guesses += 1;
        if (result == GuessResult.CORRECT){
            catsFound += 1;
            score += result.getScore();
        }

        if (result == GuessResult.WRONG){
            score += result.getScore();
        }

    }

    public boolean allCatsFound(int numberOfCats){
        return catsFound == numberOfCats;
    }

    public void printStatistics(){
        String current = String.format(
                "Player: %s\nNumber of guesses: %d\nCats found: %d\nScore: %d\n",
                name, guesses, catsFound, score);

        System.out.print(current);
    }

    abstract Position makeGuess();

    @Override
    public String toString(){
        return String.format("%s (Score: %d)", name, score);
    }
}