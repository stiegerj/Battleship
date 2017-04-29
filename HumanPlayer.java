import chn.util.*;
import java.util.*;

public class HumanPlayer extends Player{
		
	public HumanPlayer(){
		super();
		}
	
	public void addShip(String name, int length){
		ConsoleIO console = new ConsoleIO();
		System.out.println();
		System.out.println("Letter/number combination of where you want the head of the ship to be: ");
		String a = console.readToken();
		System.out.println();
		char b = a.charAt(0);
		int c;
		if((int)b < 91)
 			c = (int) b - 64;
		else c = b - 96;
		int d;
		if(a.length() < 3){
			b = a.charAt(1);
			d = (int)b - 48;
			}
		else d = 10;
		c--;
		d--;
		System.out.println("Cardinal direction that the ship is facing: (north,south,east,west) ");
		int dir;
		boolean valid = true;
		switch(console.readToken().charAt(0)){ 
			case 'n': dir = 90; break;
			case 'N': dir = 90; break;
			case 's': dir = -90; break;
			case 'S': dir = -90; break;
			case 'e': dir = 0; break;
			case 'E': dir = 0; break;
			case 'w': dir = 180; break;
			case 'W': dir = 180; break;
			default: 
				System.out.println("Invalid direction");
				dir = 1;
				valid = false;
				break;
			}
		LinkedList<Location> locations = new LinkedList<Location>();
		switch(dir){
			case -90:
				locations.add(new Location(c,d));
				for(int i = 0; i < length - 1; i++)
					locations.add(new Location(c-1-i,d));
				break;
			case 0:
				locations.add(new Location(c,d));
				for(int i = 0; i < length - 1; i++)
					locations.add(new Location(c,d-1-i));
				break;
			case 90:
				locations.add(new Location(c,d));
				for(int i = 0; i < length - 1; i++)
					locations.add(new Location(c+1+i,d));
				break;
			case 180:
				locations.add(new Location(c,d));
				for(int i = 0; i < length - 1; i++)
					locations.add(new Location(c,d+i+1));
				break;
			default:
				valid = false;
				break;
			}
		if(valid){
			ships.add(new Ship(name,length,locations));
			board.addShip(new Ship(name,length,locations));
			}
		else addShip(name,length,c,d);
		}	
		
	public void addShip(String name, int length, int c, int d){
		ConsoleIO console = new ConsoleIO();
		System.out.println("Cardinal direction that the ship is facing: (north,south,east,west) ");
		int dir;
		boolean valid = true;
		switch(console.readToken().charAt(0)){ 
			case 'n': dir = 90; break;
			case 'N': dir = 90; break;
			case 's': dir = -90; break;
			case 'S': dir = -90; break;
			case 'e': dir = 0; break;
			case 'E': dir = 0; break;
			case 'w': dir = 180; break;
			case 'W': dir = 180; break;
			default: 
				System.out.println("Invalid direction");
				dir = 1;
				break;
			}
		LinkedList<Location> locations = new LinkedList<Location>();
		switch(dir){
			case -90:
				locations.add(new Location(c,d));
				for(int i = 0; i < length - 1; i++)
					locations.add(new Location(c-1-i,d));
				break;
			case 0:
				locations.add(new Location(c,d));
				for(int i = 0; i < length - 1; i++)
					locations.add(new Location(c,d-1-i));
				break;
			case 90:
				locations.add(new Location(c,d));
				for(int i = 0; i < length - 1; i++)
					locations.add(new Location(c+1+i,d));
				break;
			case 180:
				locations.add(new Location(c,d));
				for(int i = 0; i < length - 1; i++)
					locations.add(new Location(c,d+i+1));
				break;
			default:
				valid = false;
				break;
			}
		if(valid){
			ships.add(new Ship(name,length,locations));
			board.addShip(new Ship(name,length,locations));
			}
		else addShip(name,length,c,d);
		}
		
	public boolean shoot(Player other){
		ConsoleIO console = new ConsoleIO();
		System.out.println();
		System.out.println("Letter/number combination of where you want to shoot: ");
		String a = console.readToken();
		int c; int d;
		if(a.length() < 2){
			c = 0; d = 0;
			System.out.println("Incorrect combination. Please try again.");
			return shoot(other);
			}
		else{
			System.out.println();
			char b = a.charAt(0);
			if((int)b < 91)
	 			c = (int) b - 64;
			else c = b - 96;
			if(a.length() < 3){
				b = a.charAt(1);
				d = (int)b - 48;
				}
			else d = 10;
			c--;
			d--;
			if(!getTargetBoard().hasShot(new Location(c,d))){
				System.out.println("You already shot there!");
				return shoot(other);
				}
			else return super.shoot(new Location(c,d),other);
			}
		}
	}	
		