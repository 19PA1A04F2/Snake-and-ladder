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
        List<Snakeandladder> snakes = new ArrayList<>();
        while(numberofsnakes>0){
            int startpoint=sc.nextInt();
            int endpoint=sc.nextInt();
            Snakeandladder snake=new Snakeandladder(startpoint,endpoint);
            snakes.add(snake);
            numberofsnakes--;
        }
        int numberofladders=sc.nextInt();
        List<Snakeandladder> ladders = new ArrayList<>();
        while(numberofladders>0){
            int startpoint=sc.nextInt();
            int endpoint=sc.nextInt();
            Snakeandladder ladder=new Snakeandladder(startpoint,endpoint);
            ladders.add(ladder);
            numberofladders--;
        }
        GameBoard gb=new GameBoard(dice,allPlayers,snakes,ladders,playersCurrentPosition,boardsize);
        gb.startGame();
    }
}
