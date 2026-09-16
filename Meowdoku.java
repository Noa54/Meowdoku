// MeowdokuGame controls the overall game loop

class MeowdokuGame{

    private final int numberOfCats;
    private final GameBoard board;
    private final Player player;

    public MeowdokuGame(Player player, int size){
        this.player = player;
        this.board = new GameBoard(size);
        this.numberOfCats = size;
    }

    public void play(){
        while (!player.allCatsFound(numberOfCats)){
            System.out.println(board);
            Position guess = player.makeGuess();
            GuessResult result = board.checkGuess(guess);

            player.recordGuess(result);

            System.out.println(result.getMessage());
            System.out.println("Score: " + player.getScore());
        }

        System.out.println("Congratulations!");
        player.printStatistics();
    }
}