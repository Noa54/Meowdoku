// Cell represents one square on the board

class Cell{
    private Colour colour;
    private CellState state;

    public Cell(Colour colour){
        this.colour = colour;
        this.state = CellState.HIDDEN;
    }

    public CellState getState(){
        return this.state;
    }

    public void setState(CellState state){
        this.state = state;
    }


    public String toString(){
        if (this.state == CellState.HIDDEN){
            return colour.toString().substring(0,1);
        }
        return String.format("%c", state.getSymbol());


    }

}