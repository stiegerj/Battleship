import java.util.*;
import chn.util.*;

public class Player{
	LinkedList<Ship> ships;
	PlayerBoard board;
	TargetBoard targetBoard;
	ConsoleIO console;
	
	public Player(){
		ships = new LinkedList<Ship>();
		board = new PlayerBoard();
		targetBoard = new TargetBoard();
		console = new ConsoleIO();
		}
	
	public void addShip(Ship ship){
		ships.add(ship);
		}
	
	public boolean allSunk(){
		for(Ship ship: ships){
			if(!ship.isSunk())
				return false;
			}
		return true;
		}
	
	public LinkedList<Ship> getShips(){
		return ships;
		}
		
	public boolean shoot(Location loc, Player other){
		for(Ship ship: other.getShips()){
			if(ship.containsLoc(loc)){
				targetBoard.addHit(loc);
				ship.getHit(loc);
				other.getPlayerBoard().updateShips(other.getShips());
				if(ship.isSunk()){
					if(other instanceof ComputerPlayer){
						System.out.println();
						System.out.print("You sunk his ");
						System.out.print(ship.getName());
						}
					else{
						System.out.print("He sunk your ");
						System.out.print(ship.getName());
						}
					System.out.println("!");
					System.out.println("Input a key to continue");
					console.readToken();
					System.out.println();
					}
				else{
					if(other instanceof HumanPlayer){
						System.out.println("He hit your " + ship.getName() + "!");
						System.out.println("Here are your ships:");
						other.getPlayerBoard().displayBoard();
						System.out.println();
						System.out.println("Input a key to continue");
						console.readToken();
						System.out.println();
						other.getTargetBoard().displayBoard();
						System.out.println();
						}
					else{
						}
					}
				return true;
				}
			}
		targetBoard.addMiss(loc);
		return false;
		}
	
	public PlayerBoard getPlayerBoard(){
		return board;
		}
	
	public TargetBoard getTargetBoard(){
		return targetBoard;
		}		
	}