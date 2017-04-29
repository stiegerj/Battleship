import java.util.*;
public class PlayerBoard{
	LinkedList<Ship> ships;
	Location[][] board;
	
	
	public PlayerBoard(){
		board = new Location[10][10];
		for(int i = 0; i < 10; i++){
			for(int j = 0; j < 10; j++)
				board[i][j] = new Location(i,j);
			}
		ships = new LinkedList<Ship>();
		}
	
	public boolean validPlacement(Location loc, int dir, int length){
		LinkedList<Location> locations = new LinkedList<Location>();
		int row; int col;
		switch(dir){
			case(0):
				row = loc.getRow();
				col = loc.getColumn();
				locations.add(new Location(row,col));
				for(int i = 0; i < length - 1; i++)
					locations.add(new Location(row+1+i,col));
				break;
			case(1):
				row = loc.getRow();
				col = loc.getColumn();
				locations.add(new Location(row,col));
				for(int i = 0; i < length - 1; i++)
					locations.add(new Location(row-i-1,col));
				break;
			case(2):
				row = loc.getRow();
				col = loc.getColumn();
				locations.add(new Location(row,col));
				for(int i = 0; i < length - 1; i++)
					locations.add(new Location(row,col-1-i));
				break;
			case(3):
				row = loc.getRow();
				col = loc.getColumn();
				locations.add(new Location(row,col));
				for(int i = 0; i < length - 1; i++)
					locations.add(new Location(row,col+1+i));
				break;
			}
		for(Location location: locations){
			if(hasShip(location)) return false;
			}
		return true;
		}
		
	public void updateShips(LinkedList<Ship> ships2){
		ships = ships2;
		}			
			
	public void addShip(Ship ship){
		ships.add(ship);
		}
		
	public boolean hasShip(Location loc){
		for(Ship ship: ships)
			if(ship.containsLoc(loc)) return true;
		return false;
		}
	
	public Ship getShip(Location loc){
		for(Ship ship: ships)
			if(ship.containsLoc(loc)) return ship;
		return null;
		}
		
	public void displayBoard(){
		System.out.print("   ");
		for(int i = 1; i <= 10; i++)
			System.out.print(i + " ");
		System.out.println();
		for(int i = 0; i < 10; i++){
			System.out.print((char)(i + 65) + "| ");
			for(int j = 0; j < 10; j++){
				Location loc = board[i][j];
				if(hasShip(loc)){
					Ship ship = getShip(loc);
					if(!ship.containsHitLoc(loc)) System.out.print(ship + " ");
					else System.out.print((char)(ship.getName().charAt(0) + 32) + " ");
					}
				else System.out.print("0 ");
				}
			System.out.println();
			}
		}
	}