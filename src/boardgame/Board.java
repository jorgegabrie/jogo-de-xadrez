package boardgame;

public class Board {
    private Integer rows;
    private Integer columns;
    private Piece[][] pieces;

    public Board(Integer rows, Integer columns){
        this.rows = rows;
        this.columns = columns;
        pieces = new Piece[rows][columns];
    }

    public Integer getColumns() {
        return columns;
    }
    public void setColumns(Integer columns) {
        this.columns = columns;
    }

    public Integer getRows() {
        return rows;
    }
    public void setRows(Integer rows) {
        this.rows = rows;
    }

    public Piece piece(int rows, int columns){
        return pieces[rows][columns];
    }
    public Piece piece(Position position){
        return pieces[position.getRow()][position.getCollumn()];
    }

    public void placePiece(Piece piece, Position position){
        pieces[position.getRow()][position.getCollumn()] = piece;
        piece.position = position;
    }
}
