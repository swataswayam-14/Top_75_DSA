import java.util.ArrayList;
import java.util.HashSet;

public class NumberOfDistinctIslands {
    //Problem Statement: Given a boolean 2D matrix grid of size N x M. You have to find the number of distinct islands where a group of connected 1s (horizontally or vertically) forms an island. Two islands are considered to be distinct if and only if one island is equal to another (not rotated or reflected).
    private void dfs(int row, int col, int [][]vis, int [][]grid, ArrayList<String> vec, int row0, int col0) {
        vis[row][col] = 1;
        vec.add(toString(row-row0, col-col0));
        int n = grid.length;
        int m = grid[0].length;

        int delrow[] = {-1,0,1,0};
        int delcol[] = {0,-1,0,+1};

        for (int i=0;i<4;i++) {
            int nrow = row + delrow[i];
            int ncol = col + delcol[i];

            if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && vis[nrow][ncol] == 0 && grid[nrow][ncol] == 1) {
                dfs(nrow, ncol, vis, grid, vec, row0, col0);
            }
        }
    }
    int countDistinctIslands(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int vis[][] = new int[n][m];
        HashSet<ArrayList<String>> st = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                ArrayList<String> vec = new ArrayList<>();
                dfs(i, j, vis, grid, vec, i, j);
                st.add(vec);
            }
        }
        return st.size();
    }
    public static void main(String[] args) {
        int grid[][] = {
           {1, 1, 0, 1, 1},
           {1, 0, 0, 0, 0},
           {0, 0, 0, 0, 1},
           {1, 1, 0, 1, 1}};
   
      NumberOfDistinctIslands ob = new NumberOfDistinctIslands();
       int ans = ob.countDistinctIslands(grid);
       System.out.println(ans);
     }

    private String toString(int r, int c) {
        return Integer.toString(r) + " " + Integer.toString(c);
    }
}



class Pair {
    int first;
    int second;
    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}