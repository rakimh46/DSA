
class Solution {
    private int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private int[][] grid;
    private int rows, cols;

    public int[] hitBricks(int[][] grid, int[][] hits) {
        rows = grid.length;
        cols = grid[0].length;
        this.grid = grid;
        
        UnionFind uf = new UnionFind(rows * cols + 1);
        
        for (int[] hit : hits) {
            if (grid[hit[0]][hit[1]] == 1) grid[hit[0]][hit[1]] = 2;
        }
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j ++) {
                if (grid[i][j] == 1) unionAround(i, j, uf);
            }
        }
        
        int numBricksLeft = uf.size[uf.find(0)]; 
        int i = hits.length - 1; 
        int[] ans = new int[hits.length]; 
        
        while (i >= 0) {
            int x = hits[i][0];
            int y = hits[i][1];
            if (grid[x][y] == 2) {
                grid[x][y] = 1;
                unionAround(x, y, uf);
                int newNumBricksLeft = uf.size[uf.find(0)];
                ans[i] = Math.max(newNumBricksLeft - numBricksLeft - 1, 0); 
                numBricksLeft = newNumBricksLeft;
            }
            i--;
        }
        
        return ans;
    }
    
    private void unionAround(int x, int y, UnionFind uf) {   
        int curMark = x * cols + y + 1;
        
        for (int[] d : dir) {
            int nx = x + d[0];
            int ny = y + d[1];
            if (nx >= 0 && nx < rows && ny >= 0 && ny < cols && grid[nx][ny] == 1) {
                int newmark=nx * cols + ny + 1;
                uf.union(curMark, newmark);
            }
        }
        
        if(x == 0) uf.union(0, curMark); // Connect to the top of the grid.
    }
    
    class UnionFind {
        int[] par, size;
        
        public UnionFind(int n) {
            par = new int[n];
            size = new int[n];
            Arrays.fill(size, 1);
            for (int i = 0; i < n; i++) { // 0 indicates top of the grid.
                par[i] = i;
            }
            size[0]=0;
        }
        
        public int find(int x) {
            if (x == par[x]) return x;
            return par[x] = find(par[x]);
        }
        
        public void union(int x, int y) {
            int p1 = find(x);
            int p2 = find(y);
            if (p1 != p2) {
                par[p2] = p1;
                size[p1] += size[p2];
            }
        }
    }
}