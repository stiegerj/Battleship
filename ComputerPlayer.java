import chn.util.*;
import java.util.*;
import java.lang.Math;

public class ComputerPlayer extends Player{
		
	public ComputerPlayer(){
		super();
		}
		
	public void addShip(String name, int length){
		int dir = (int)(Math.random() * 3);
		LinkedList<Location> locations = new LinkedList<Location>();
		int row; int col;
		//0 North 1 South 2 East 3 West
		switch(dir){
			case(0):
				do{
					row = (int)(Math.random() * (10 - length));
					col = (int)(Math.random() * 9);
					}
				while(!board.validPlacement(new Location(row,col),dir,length));
				locations.add(new Location(row,col));
				for(int i = 0; i < length - 1; i++)
					locations.add(new Location(row+1+i,col));
				break;
			case(1):
				do{
					row = 9 - (int)(Math.random() * (10 - length));
					col = (int)(Math.random() * 9);
					}
				while(!board.validPlacement(new Location(row,col),dir,length));
				locations.add(new Location(row,col));
				for(int i = 0; i < length - 1; i++)
					locations.add(new Location(row-i-1,col));
				break;
			case(2):
				do{
					row = (int)(Math.random() * 9);
					col = 9 - (int)(Math.random() * (10 - length));
					}
				while(!board.validPlacement(new Location(row,col),dir,length));
				locations.add(new Location(row,col));
				for(int i = 0; i < length - 1; i++)
					locations.add(new Location(row,col-1-i));
				break;
			case(3):
				do{
					row = (int)(Math.random() * 9);
					col = (int)(Math.random() * (10 - length));
					}
				while(!board.validPlacement(new Location(row,col),dir,length));
				locations.add(new Location(row,col));
				for(int i = 0; i < length - 1; i++)
					locations.add(new Location(row,col+1+i));
				break;
			}
		ships.add(new Ship(name,length,locations));
		board.addShip(new Ship(name,length,locations));
		}
		
	public boolean shoot(Player other){
	int row; int col;
		do{
			row = (int)(Math.random() * 9);
			col = (int)(Math.random() * 9);
			}
		while(!getTargetBoard().hasShot(new Location(row,col)));
		Location loc = new Location(row,col);
		return super.shoot(loc,other);
		}
	}				
				