// RandomPlayer randomly generates a row and column

import java.util.Random;

class RandomPlayer extends Player{
    private Random random;


    public RandomPlayer(String name, int size, int seed){
        super(name, size);
        this.random = new Random(seed);
    }

    public Position makeGuess(){
        int row = random.nextInt(size);
        int column = random.nextInt(size);
        return new Position(row, column);
    }
}