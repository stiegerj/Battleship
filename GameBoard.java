public class GameBoard{
	Location[][] gameBoard;
	
	public GameBoard(){
		gameBoard = new Location[10][10];
		}
	
	public Location getLeftNeighbor(Location location){
		if(location.getX() > 0)
		return gameBoard[location.getX() -1][location.getY()];
		else return null;
		}
	public Location getRightNeighbor(Location location){
		if(location.getX() < 9)
		return gameBoard[location.getX() + 1][location.getY()];
		else return null;
		}
	public Location getUpNeighbor(Location location){
		if(location.getY() > 0)
		return gameBoard[location.getX()][location.getY() + 1];
		else return null;
		}
	public Location getDownNeighbor(Location location){
		if(location.getY() < 9)
		return gameBoard[location.getX() -1][location.getY() - 1];
		else return null;
		}
	
	public Location[][] getBoard(){
		return gameBoard;
		}
	
	public void displayBoard(){
		}
	
	}
	
	