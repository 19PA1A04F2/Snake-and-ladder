package Snakeandladdergame;
import java.util.*;

class PlaySnakeAndLadder {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int noofdice=sc.nextInt();
        Dice dice = new Dice(noofdice);
        int numberofplayers=sc.nextInt();
        int boardsize=sc.nextInt();
        int id=0;
        Queue<Player> allPlayers = new LinkedList<>();
        Map<String,Integer> playersCurrentPosition = new HashMap<>();
        while(numberofplayers>0){
            String name=sc.next();
            Player p1 = new Player(name,id++);
            allPlayers.offer(p1);
            playersCurrentPosition.put(name,0);
            numberofplayers--;
        }
        int numberofsnakes=sc.nextInt();
        Map<Integer,Integer> snakes = new HashMap<>();
        while(numberofsnakes>0){
            int startpoint=sc.nextInt();
            int endpoint=sc.nextInt();
            Snakeandladder snake=new Snakeandladder(startpoint,endpoint);
            snakes.put(startpoint,endpoint);
            numberofsnakes--;
        }
        int numberofladders=sc.nextInt();
        Map<Integer,Integer> ladders = new HashMap<>();
        while(numberofladders>0){
            int startpoint=sc.nextInt();
            int endpoint=sc.nextInt();
            Snakeandladder ladder=new Snakeandladder(startpoint,endpoint);
            ladders.put(startpoint,endpoint);
            numberofladders--;
        }
        GameBoard gb=new GameBoard(dice,allPlayers,snakes,ladders,playersCurrentPosition,boardsize);
        gb.startGame();
    }
}
