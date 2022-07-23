public class Board {

    private char board[][];
    private int boardSize  = 3;
    private char p1Sym , p2Sym ; 
    private int count ; // No of cells that have been marked

    public final static int PLAYER_1_WINS = 1;
    public final static int PLAYER_2_WINS = 2;
    public final static int DRAW = 3;
    public final static int INCOMPLETE = 4;
    public final static int INVALID = 5;


    public Board(char p1Sym, char p2Sym){
        board  = new char[boardSize] [boardSize];
        for(int i = 0; i < boardSize; i++){
            for(int j = 0 ; j < boardSize; j++){
            board[i][j] = ' ';
            }
        }
        this.p1Sym = p1Sym;
        this.p2Sym = p2Sym;
    }
    public int move(char Symbol , int x , int y){
        if (x< 0 || x>=boardSize || y<0 || y>=boardSize || board[x][y]!=' ' ){
            return INVALID;
        }
        board[x][y] = Symbol;
        count++;

        if ( board[x][0]==board[x][1] && board[x][0]==board[x][2] ){
            if (Symbol== p1Sym ){
                return PLAYER_1_WINS;
            }
            if (Symbol== p2Sym ){
                return PLAYER_2_WINS;
            }
        }
        if ( board[0][y]==board[1][y] && board[1][y]==board[2][y] ){
            if (Symbol== p1Sym ){
                return PLAYER_1_WINS;
            }
            if (Symbol== p2Sym ){
                return PLAYER_2_WINS;
            }
        }
        if (board[0][0]!=' ' && board[0][0]==board[1][1] && board[1][1]==board[2][2] ){
            if (Symbol== p1Sym ){
                return PLAYER_1_WINS;
            }
            if (Symbol== p2Sym ){
                return PLAYER_2_WINS;
            }
        }
        if (board[0][0]!=' ' && board[2][0]==board[1][1] && board[1][1]==board[0][2] ){
            if (Symbol== p1Sym ){
                return PLAYER_1_WINS;
            }
            if (Symbol== p2Sym ){
                return PLAYER_2_WINS;
            }
        }
        if (count == boardSize* boardSize){
            return DRAW;
        }
        return INCOMPLETE;


    }
    public void print(){
        System.out.println("---------------");
        for (int i = 0 ; i < boardSize ; i++){
            for (int j = 0 ; j< boardSize ; j++){
                System.out.print("| "+board[i][j] + " |");
            }
            System.out.println();
        }
        System.out.println("---------------");
    }

    public void map(){
        System.out.println("Map of the Board");
        System.out.println("---------------");
        for (int i = 0 ; i < boardSize ; i++){
            for (int j = 0 ; j< boardSize ; j++){
                System.out.print("| "+i+","+j + " |");
            }
            System.out.println();
        }
        System.out.println("---------------");
    }


    
}
