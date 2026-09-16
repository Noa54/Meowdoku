// GameBoard represents the game board in the game
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

class GameBoard{
    private int size;
    private Cell[][] board;
    private int[] solution;
    private Colour[] colours;
    private Random random = new Random(30);

    public GameBoard(int size){
        this.size = size;
        this.board = new Cell[size][size];

        int[][] solutions = {
                {2, 0, 3, 1},
                {1, 3, 0, 2}
        };

        this.solution = solutions[random.nextInt(solutions.length)];
        this.colours = new Colour[] {Colour.BLUE, Colour.RED, Colour.GREEN, Colour.YELLOW};

        List<Colour> list = Arrays.asList(colours);
        Collections.shuffle(list, random);

        initialiseBoard();
    }

    private void initialiseBoard(){
        placeInitialColours();

        for (int row = 0; row < size; row++){
            expandRegion(row, solution[row], colours[row]);
        }
    }

    private void placeInitialColours(){
        for (int row = 0; row < size; row++){
            board[row][solution[row]] = new Cell(colours[row]);

        }
    }

    private void expandRegion(int row, int column, Colour colour){
        for (int r = row - 1; r <= row + 1; r++){
            for (int c = column - 1; c <= column + 1; c++){
                if (r >= 0 && r < size && c >=0 && c < size){
                    if (board[r][c] == null){
                        board[r][c] = new Cell(colour);
                    }
                }
            }
        }
    }
    public GuessResult checkGuess(Position position){
        int row = position.getRow();
        int column = position.getColumn();

        if (board[row][column].getState() != CellState.HIDDEN){
            return GuessResult.ALREADY_GUESSED;
        }

        if (column == solution[row]){
            board[row][column].setState(CellState.FOUND_CAT);
            return GuessResult.CORRECT;
        } else {
            board[row][column].setState(CellState.WRONG_GUESS);
            return GuessResult.WRONG;
        }
    }

    @Override
    public String toString() {
        String result = "";

        for (int row = 0; row < size; row++){
            for (int column = 0; column < size; column++){
                result += board[row][column];

                if (column < size - 1) {
                    result += "";
                }
            }
            if (row < size - 1){
                result += "\n";
            }
        }

        return result;
    }
}
