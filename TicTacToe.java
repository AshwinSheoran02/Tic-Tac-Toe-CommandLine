import java.util.*;
public class TicTacToe {
    public static void main(String[] args){

        
        
        TicTacToe t = new TicTacToe();
        t.startGame();
    }
    
    private Player player1 , player2;
    private Board board;

    public void startGame(){
        Scanner sc = new Scanner(System.in);
        player1 = takeinput(1);
        player2 = takeinput(2);
        while (player1.getSymbol() == player2.getSymbol()){
            System.out.println("Both have taken same symbol !! Choose Different Symbol for Player 2 :");
            char Symbol=sc.next().charAt(0);
            player2.setSymbol(Symbol);

        }
        board = new  Board(player1.getSymbol() , player2.getSymbol());
        board.map();
        
        boolean player1turn = true;
        int status = board.INCOMPLETE;
        while(status == board.INCOMPLETE || status==board.INVALID){
            if (player1turn){
                System.out.println("Player-1 "+player1.getName()+"'s turn");
                System.out.println("Enter x:");
                int x = sc.nextInt();
                System.out.println("Enter y:");
                int y = sc.nextInt();
                status = board.move(player1.getSymbol() , x , y);
                if (status != board.INVALID){
                    player1turn = false;
                    board.print();
                }
                else{
                    System.out.println("Invalid Move Try again! ");
                }
            }
            else{
                System.out.println("Player-2s "+player2.getName()+"'s turn");
                System.out.println("Enter x:");
                int x = sc.nextInt();
                System.out.println("Enter y:");
                int y = sc.nextInt();
                status = board.move(player2.getSymbol() , x , y);
                if (status != board.INVALID){
                    player1turn = true;
                    board.print();
                }
                else{
                    System.out.println("Invalid Move Try again! ");
                }
                

            }
           

        }
        if (status == board.PLAYER_1_WINS){
            System.out.println("-----------");
            System.out.println("Player 1 - "+ player1.getName() +" Wins !!");

        }
        else if (status == board.PLAYER_2_WINS){
            System.out.println("-----------");
            System.out.println("Player 2 - "+ player2.getName() +" Wins !!");

        }
        else {
            System.out.println("-----------");
            System.out.println("DRAW !!");
        }


    }

    private Player takeinput(int num){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Player "+num+" name: ");
        String name = sc.nextLine();
        System.out.println("Enter Player "+num+" Symbol: ");
        char Symbol = sc.next().charAt(0);
        Player p = new Player(name , Symbol);
        return p;

    }
    
}
