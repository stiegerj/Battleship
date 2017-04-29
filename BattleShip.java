import java.util.*;
import chn.util.*;

public class BattleShip{
	ConsoleIO console;
	boolean gameOver;
	HumanPlayer human;
	ComputerPlayer computer;

	
	public BattleShip(){
		console = new ConsoleIO();
		gameOver = false;
		human = new HumanPlayer();
		computer = new ComputerPlayer();
		}
	
	public void setUp(){
		setUp(human);
		setUp(computer);
		}
	
	public void setUp(ComputerPlayer player){
		player.addShip("Aircraft Carrier",5);
		player.addShip("Battleship",4);
		player.addShip("Destroyer",3);
		player.addShip("Submarine",3);
		player.addShip("Patrol Boat",2);
		}
	
	public void setUp(HumanPlayer player){
		System.out.println();
		player.getPlayerBoard().displayBoard();
		System.out.println("First ship is your Aircraft Carrier of size 5 ");
		player.addShip("Aircraft Carrier",5);
		System.out.println();
		player.getPlayerBoard().displayBoard();
		System.out.println("Next ship is your Battleship of size 4 ");
		player.addShip("Battleship",4);
		System.out.println();
		player.getPlayerBoard().displayBoard();
		System.out.println("Next ship is your Destroyer of size 3 ");
		player.addShip("Destroyer",3);
		System.out.println();
		player.getPlayerBoard().displayBoard();
		System.out.println("Next ship is your Submarine of size 3 ");
		player.addShip("Submarine",3);
		System.out.println();
		player.getPlayerBoard().displayBoard();
		System.out.println("Last ship is your Patrol boat of size 2 ");
		player.addShip("Patrol Boat",2);
		System.out.println();
		player.getPlayerBoard().displayBoard();
		}
			
	public HumanPlayer getHuman(){
		return human;
		}
	
	public ComputerPlayer getComputer(){
		return computer;
		}
	
	public void displayPlayerBoard(Player player){
		player.getPlayerBoard().displayBoard();
		}
	
	public void displayTargetBoard(Player player){
		player.getTargetBoard().displayBoard();
		}
		
	public void play(){
		while(!human.allSunk() && !computer.allSunk()){
			human.shoot(computer);
			System.out.println();
			boolean heHit = computer.shoot(human);
			if(!heHit){
				System.out.println("Your hits and misses:");
				System.out.println();
				displayTargetBoard(human);
				}
			}
		if(human.allSunk())
			System.out.println("LOSER!");
		else System.out.println("Winner!");
		}
		
		
	public static void main(String[] args){
		BattleShip bs = new BattleShip();
		HumanPlayer human = bs.getHuman();
		ComputerPlayer computer = bs.getComputer();
		bs.setUp();
		bs.play();			
		}
		
	}
		
		
	
	