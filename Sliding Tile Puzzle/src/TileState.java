import java.util.ArrayList;
import java.util.List;

public class TileState {
   private int[][] board;			// locations of tiles
   private TileState parent;			// board which generated this one
   private int emptyR, emptyC;			// location of empty tile

   public TileState(int[][] initial) {
       board = copy(initial);
       setEmptyLocation();
       parent = null;
   }

   // This is called a copy constructor.  
   // It instantiates a new object that’s a copy
   // of the argument.
   public TileState(TileState toCopy) {
       this.board = copy(toCopy.board);
       this.parent = toCopy.parent;
       this.emptyC = toCopy.emptyC;
       this.emptyR = toCopy.emptyR;
   }

   // return a copy of the input array
   public int[][] copy(int[][] arr) {
        int[][] returnArr = new int[arr.length][arr[0].length];
        for (int i = 0; i < returnArr.length; i++) {
            for (int j = 0; j < returnArr.length; j++) {
                returnArr[i][j] = arr[i][j];
            }
        }
        return returnArr;
   }

   // Warning!  Very slow!
   private void setEmptyLocation() {
       for (int r = 0; r < board.length; r++) {
           for (int c = 0; c < board[r].length; c++) {
               if (board[r][c] == 0) {
                   this.emptyR = r;
                   this.emptyC = c;
               }
           }
       }
   }

   public void setParent(TileState p) {
       this.parent = p;
   }

   public boolean isGoal() {
       return isGoal(this.board);
   }

 
  public boolean isGoal(int[][] board) {
       int correctVal = 1;
       for (int r = 0; r < board.length; r++) {
           for (int c = 0; c < board[r].length; c++) {
// for lower right corner val
               if (correctVal == board.length*board[0].length) correctVal = 0;                 
   if (board[r][c] != correctVal) return false;
               correctVal++;
           }
       }
       return true;
   }

   // NOTE:  if you wish, you can make a getNextState() that returns a single next
   // state or null if there are no remaining next states.

   public List<TileState> getNextStates() {
       ArrayList<TileState> nextTileState = new ArrayList<>();
       
	/* you do this one! */

      /* 
      Pseudocode idea:
		For each neighbor of the blank square:
			if ( it’s a valid move (not out of bounds) ) {
				nextState = copy current object
				Make the move on the nextState
				Set current object as nextState’s parent
				Add nextState to the list of return states.
			}
		}
		
		return list of next states.
      */

      for (int r = 0; r < board.length; r++) {
        for (int c = 0; c < board[0].length; c++) {
            if(r != emptyR && c != emptyC) {
                int[][] newArr = moveTile(r, c);
                if(newArr != null) {
                    TileState t = new TileState(newArr);
                    nextTileState.add(t);
                }
            }
        }
      }

      return nextTileState;
   }

   // Move the tile at (r, c) into the blank square if it’s adjacent.
   public int[][] moveTile(int r, int c) {
       if (!isAdjacent(r, c, emptyR, emptyC)) return null;

       /* you do this one if you want */
       int[][] newArr = copy(board);
       int currVal = newArr[r][c];
       newArr[emptyR][emptyC] = currVal;
       newArr[r][c] = 0;
       return newArr;
   }

   // Check if (r, c) is adjacent to (r2, c2)
   private boolean isAdjacent(int r, int c, int r2, int c2) {
       int rDiff = Math.abs(r - r2);
       int cDiff = Math.abs(c - c2);
       return rDiff + cDiff == 1;
   }

   // Return true if this objects represents the same state as other
   public boolean equals(TileState other) {
       for (int i = 0; i < board.length; i++) {
        for (int j = 0; j < board[0].length; j++) {
            if(board[i][j] != other.board[i][j]) return false;
        }
       }
       return true;
   }

   // return a copy of the current TileState object (copy self)
   public TileState copy() {
       return new TileState(this);
   }

   public String toString() {
       String out = "";
       for (int r = 0; r < board.length; r++) {
           for (int c = 0; c < board[r].length; c++) {
               out += "[ " + board[r][c] + "] ";
           }
           out += "\n";
       }
       return out;
   }

   private boolean isInBounds(int r, int c) {
       if (r < 0 || c < 0) return false;
       if (r >= board.length || c >= board[0].length) return false;
       return true;
   }
}