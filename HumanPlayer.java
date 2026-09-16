// HumanPlayer gets row and column guesses from the user

import java.util.Scanner;

class HumanPlayer extends Player{
    private Scanner scanner;

    public HumanPlayer(String name, int size){
        super(name, size);
        this.scanner = new Scanner(System.in);
    }

    @Override
    public Position makeGuess(){
        int row = getValidPosition("Enter Row: ", size);
        int column = getValidPosition("Enter Column: ", size);

        return new Position(row, column);
    }

    private int getValidPosition(String prompt, int size){
        int position;

        do {
            System.out.print(prompt);
            position = scanner.nextInt();
        } while (position < 0 || position >= size);

        return position;
    }
}