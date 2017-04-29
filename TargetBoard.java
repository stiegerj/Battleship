import java.util.*;
public class TargetBoard{
	Map<Location,Character> targetBoard;
	public TargetBoard(){
		targetBoard = new HashMap<Location,Character>();
		}
	
	public boolean hasShot(Location loc){
		Location location = loc;
		for(Location loc2: targetBoard.keySet()){
			if(location.equals(loc2))
				location = loc2;
			}
		return !targetBoard.containsKey(location);
		}
		
		
	public void addHit(Location loc){
		targetBoard.put(loc,new Character('H'));
		}
	
	public void addMiss(Location loc){
		targetBoard.put(loc,new Character('M'));
		}
	
	public void displayBoard(){
		System.out.print("   ");
		for(int i = 1; i <= 10; i++)
			System.out.print(i + " ");
		System.out.println();
		for(int i = 0; i < 10; i++){
			System.out.print((char)(i + 65) + "| ");
			for(int j = 0; j < 10; j++){
				Location loc = new Location(i,j);
				for(Location loc2: targetBoard.keySet()){
					if(loc.equals(loc2))
						loc = loc2;
					}					
				if(targetBoard.containsKey(loc)){
					if(targetBoard.get(loc).equals(new Character('H')))
						System.out.print("H ");
					else if(targetBoard.get(loc).equals(new Character('M')))
						System.out.print("M ");
					}
				else System.out.print("0 ");
				}
			System.out.println();
			}
		}
	}
	
	