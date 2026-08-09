class Solution {
    public boolean checkValidGrid(int[][] grid) {
        int n=grid.length;
        int [][] pos = new int[n*n][2];
        for(int i =0;i<n;i++){
            for(int j =0;j<n;j++){
                int step = grid[i][j];
                pos[step][0]=i;
                pos[step][1]=j;
            }
        }
        if(pos[0][0]!=0 || pos[0][1]!=0){
            return false;
        }
       for(int step = 0;step<n*n-1;step++){
        int r = pos[step][0];
        int c = pos[step][1];
        int r1= pos[step+1][0];
        int c1= pos[step+1][1];
        int dr = Math.abs(r1-r);
        int dc = Math.abs(c1-c);
        if(!(dr==2 && dc==1 || dr==1 && dc==2)){
            return false;
        }
       } 
       return true;
    }
}