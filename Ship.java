import java.util.*;
public class Ship{
	String myName;
	int myLength;
	LinkedList<Location> locationsOccupied;
	LinkedList<Location> locationsHit;
	
	public Ship(String name, int length, LinkedList<Location> occupied){
		myName = name;
		myLength = length;
		locationsHit = new LinkedList<Location>();
		locationsOccupied = occupied;
		}
	
	public String getName(){
		return myName;
		}
	
	public String toString(){
		return myName.substring(0,1);
		}
	
	public boolean containsLoc(Location loc){
		for(Location location: locationsOccupied)
			if(location.equals(loc)) return true;
		return false;
		}
	
	public boolean containsHitLoc(Location loc){
		for(Location location: locationsHit)
			if(location.equals(loc)) return true;
		return false;
		}
	
	public boolean isSunk(){
		return myLength == locationsHit.size();
		}
	
	public void getHit(Location location){
		locationsHit.add(location);
		}
	
	public LinkedList<Location> getOccLocs(){
		return locationsOccupied;
		}
	
	public LinkedList<Location> getHitLocs(){
		return locationsHit;
		}
	
	



	/* Type of ships:
	Carrier size 5
	Battleship size 4
	Destroyer size 3
	Submarine size 3
	Patrol boat size 2 */
	
	
	
	
	}