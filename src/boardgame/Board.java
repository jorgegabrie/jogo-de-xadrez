package boardgame;

public class Board {
    private Integer rows;
    private Integer columns;
    private Piece[][] pieces;

    public Board(Integer rows, Integer columns){
        if (rows < 1 || columns < 1){
            throw new BoardException("Erro criando o tabuleiro: É necessário que tenha pelo menos uma linha e uma coluna");
        }
        this.rows = rows;
        this.columns = columns;
        pieces = new Piece[rows][columns];
    }

    public Integer getColumns() {
        return columns;
    }

    public Integer getRows() {
        return rows;
    }

    public Piece piece(int rows, int columns){
        if (!positionExists(rows, columns)){
            throw new BoardException("Essa posição não está no tabuleiro");
        }
        return pieces[rows][columns];
    }
    public Piece piece(Position position){
        if (!positionExists(position)){
            throw new BoardException("Essa posição não está no tabuleiro");
        }
        return pieces[position.getRow()][position.getCollumn()];
    }

    public void placePiece(Piece piece, Position position){
        if (thereIsAPiece(position)){
            throw new BoardException("já existe uma peça em posição: "+ position);
        }
        pieces[position.getRow()][position.getCollumn()] = piece;
        piece.position = position;
    }

    public Piece removePiece(Position position){
        if (!positionExists(position)){
            throw new BoardException("Essa posição não está no tabuleiro");
        }
        if (piece(position) == null){
            return null;
        }
        Piece aux = piece(position);
        aux.position = null;
        pieces[position.getRow()][position.getCollumn()] = null;
        return aux;
    }

    private boolean positionExists(int row, int column){
        return row >= 0 && row < rows && column >= 0 && column < columns;
    }

    public boolean positionExists(Position position){
        return positionExists(position.getRow(), position.getCollumn());
    }

    public boolean thereIsAPiece(Position position){
        if (!positionExists(position)){
            throw new BoardException("Essa posição não está no tabuleiro");
        }
        return piece(position) != null;
    }


}
