import java.util.Arrays;

public class Q0063 {
    public static void main(String[] args) {
        Q0063 obj = new Q0063();
        System.out.println(obj.uniquePathsWithObstacles(new int[][]{ {0,1}, {0, 0}}));
    }
//    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
//        int dp[][] = new int[obstacleGrid.length][obstacleGrid[0].length];
//        for(int d[]:dp){
//            Arrays.fill(d, -1);
//        }
//
//        return getPathCount(0,0,obstacleGrid, dp);
//    }
//
//    public int getPathCount(int i, int j, int[][] obstacleGrid, int dp[][]){
//        if(i<0 || j<0 || i>= obstacleGrid.length || j>=obstacleGrid[0].length){
//            return 0;
//        }
//
//        if(obstacleGrid[i][j] == 1){
//            return 0;
//        }
//
//        if( i == obstacleGrid.length-1 && j== obstacleGrid[0].length-1){
//            return 1;
//        }
//
//        if(dp[i][j] != -1){
//            return dp[i][j];
//        }
//
//        int ans = getPathCount(i+1, j, obstacleGrid,dp) + getPathCount(i, j+1, obstacleGrid, dp);
//        dp[i][j] = ans;
//
//        return ans;
//    }


        // approach 2:- bottom up dp
        public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int dp[][] = new int[obstacleGrid.length+1][obstacleGrid[0].length+1];

        for(int i=obstacleGrid.length-1; i>=0;i--){
            for(int j=obstacleGrid[i].length-1;j>=0;j--){
                if(obstacleGrid[i][j] == 1){
                    dp[i][j] = 0;
                }
                else {
                    // obstacleGrid[i][j] = 0
                    if(i == obstacleGrid.length-1 && j== obstacleGrid[i].length-1){
                        dp[i][j] = 1;
                    }else{
                        dp[i][j] = dp[i+1][j] + dp[i][j+1];
                    }
                }
            }
        }


        return dp[0][0];

       }


}
