package Snakeandladdergame;
import java.util.List;
import java.util.Map;
import java.util.Queue;


class GameBoard {
    private Dice dice;
    private Queue<Player> nextTurn;
    private Map<Integer,Integer> snakes;
    private  Map<Integer,Integer> ladders;
    private  Map<String,Integer> playersCurrentPosition;
    int boardSize;

     GameBoard(Dice dice, Queue<Player> nextTurn, Map<Integer,Integer> snakes, Map<Integer,Integer> ladders,Map<String,Integer> playersCurrentPosition,int boardSize) {
        this.dice = dice;
        this.nextTurn = nextTurn;
        this.snakes = snakes;
        this.ladders = ladders;
        this.playersCurrentPosition = playersCurrentPosition;
        this.boardSize = boardSize;
    }

     void startGame(){
        while(nextTurn.size()>1) {
            Player player = nextTurn.poll();
            int currentPosition = playersCurrentPosition.get(player.getPlayerName());
            int diceValue = dice.rollDice();
            int nextCell = currentPosition + diceValue;
            if (nextCell > boardSize) nextTurn.offer(player);
            else if (nextCell == boardSize) {
                System.out.println( player.getPlayerName() + " won the game");
            }else{
               int[] nextPosition= new int[1];
               int c=0;
                nextPosition[0]= nextCell;
                if(snakes.containsKey(nextCell)){
                    nextPosition[0]=snakes.get(nextCell);
                }
               if(nextPosition[0] != nextCell) System.out.println(player.getPlayerName() + " Bitten by Snake present at: "+ nextCell);
                if(ladders.containsKey(nextCell)){
                    nextPosition[0]=ladders.get(nextCell);
                    c=1;
                }
                if(nextPosition[0] != nextCell && c==1) System.out.println(player.getPlayerName() + " Got ladder present at: "+ nextCell);
                if(nextPosition[0] == boardSize){
                    System.out.println(player.getPlayerName() + " won the game");
                }else{
                    playersCurrentPosition.put(player.getPlayerName(),nextPosition[0]);
                    System.out.println(player.getPlayerName() + " is at position "+ nextPosition[0]);
                    nextTurn.offer(player);
                }
            }
        }
    }
}
