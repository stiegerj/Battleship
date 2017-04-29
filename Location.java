public class Location implements Comparable{
	int myRow; 
	int myColumn;
	
	public Location(int row, int column){
		myRow = row;
		myColumn = column;
		}

	public int getRow(){
		return myRow;
		}
	
	public int getColumn(){
		return myColumn;
		}
		
	public boolean equals(Location other){
		return (myRow == other.getRow() && myColumn == other.getColumn());
		}
	
	public int compareTo(Object other){
		return ((((Location)other).getRow() - myRow) + (((Location)other).getColumn() - myColumn));
		}
	}