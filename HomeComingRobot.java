/* There is an m x n grid, where (0, 0) is the top-left cell and (m - 1, n - 1) is the bottom-right cell. You are 
given an integer array startPos where startPos = [startrow, startcol] indicates that initially, a robot is at the 
cell (startrow, startcol). You are also given an integer array homePos where homePos = [homerow, homecol] indicates 
that its home is at the cell (homerow, homecol). The robot needs to go to its home. It can move one cell in four 
directions: left, right, up, or down, and it can not move outside the boundary. Every move incurs some cost. You are 
further given two 0-indexed integer arrays: rowCosts of length m and colCosts of length n.
1)- If the robot moves up or down into a cell whose row is r, then this move costs rowCosts[r].
2)- If the robot moves left or right into a cell whose column is c, then this move costs colCosts[c].
Return the minimum total cost for this robot to return home.
* Eg 1 :  start = [1,0]  home = [2,3]     rowCost = [5,4,3]     colCost = [8,2,6,7]     Output = 18 
* Eg 2 :  start = [0,0]  home = [0,0]     rowCost = [5]         colCost = [28]          Output = 0  
*/
import java.util.*;
public class HomeComingRobot
{
      public static int MinimumCost(int start[], int home[], int rowCost[], int colCost[])
      {     // The shortest path is the most optimal solution...
            if((rowCost.length == 0) && (colCost.length == 0))    return 0;      // base case...
            if((rowCost.length == 1) && (colCost.length == 1))    return 0;      // base case...
            int rowSum = 0, colSum = 0;      //*  Variable Declaration -> O(1)
            if(start[0] < home[0])      // If Robot is above the house...
            {
                  for(int i = start[0] + 1; i <= home[0]; i++)     //! Downward Row Iteration -> O(N)
                        rowSum += rowCost[i];
            }
            else if(start[0] > home[0])    // If Robot is below the house...
            {
                  for(int i = start[0] - 1; i >= home[0]; i--)     //! Upward Row Iteration -> O(N)
                        rowSum += rowCost[i];
            }
            if(start[1] < home[1])     // If Robot is left to the house...
            {
                  for(int j = start[1] + 1; j <= home[1]; j++)     //! Rightward Column Iteration -> O(M)
                        colSum += colCost[j];
            }
            else if(start[1] > home[1])     // If Robot is right to the house...
            {
                  for(int j = start[1] - 1; j >= home[1]; j--)     //! Leftward Column Iteration -> O(M)
                        colSum += colCost[j];
            }
            return rowSum + colSum;    // Returning the summed cost...
      }
      public static void main(String args[])
      {
            Scanner sc = new Scanner(System.in);
            int x;
            int start[] = new int[2];
            System.out.print("Enter Starting row index : ");
            start[0] = sc.nextInt();
            System.out.print("Enter Starting column index : ");
            start[1] = sc.nextInt();
            int home[] = new int[2];
            System.out.print("Enter Home row index : ");
            home[0] = sc.nextInt();
            System.out.print("Enter Home column index : ");
            home[1] = sc.nextInt();
            System.out.print("Enter number of rows : ");
            x = sc.nextInt();
            int rows[] = new int[x];
            for(int i = 0; i < rows.length; i++)
            {
                  System.out.print("Enter row cost : ");
                  rows[i] = sc.nextInt();
            }
            System.out.print("Enter number of columns : ");
            x = sc.nextInt();
            int cols[] = new int[x];
            for(int i = 0; i < cols.length; i++)
            {
                  System.out.print("Enter row cost : ");
                  cols[i] = sc.nextInt();
            }
            System.out.println("Minimum Cost of Robot to Reach House : "+MinimumCost(start, home, rows, cols));
            sc.close();
      }
}



//! Time Complexity -> O(N)
//* Space Complexity -> O(1)