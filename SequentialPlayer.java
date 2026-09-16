// SequentialPlayer automatically guesses every board position

class SequentialPlayer extends Player{

    private int nextPosition;

    public SequentialPlayer(String name, int size){
        super(name, size);
        this.nextPosition = 0;
    }

    @Override
    public Position makeGuess(){
        int position = nextPosition % (size * size);
        int row = position / size;
        int column = position % size;

        nextPosition++;

        return new Position(row, column);
    }
}
