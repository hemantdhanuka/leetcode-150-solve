public class Q0097 {
    public static void main(String[] args) {
        Q0097 obj = new Q0097();

        boolean result = obj.isInterleave("a", "d", "ad");
        System.out.println(result);
    }

    // Note approach 1 solution 1:- 3d dp array
//    public boolean isInterleave(String s1, String s2, String s3) {
//        int dp[][][] = new int[s1.length()+1][s2.length()+1][s3.length()+1];
//        // -1 represent not calculate yet
//        // 0 mean not interleaving
//        // 1 means interleaving
//
//        // prefill by -1
//        for(int i=0;i<dp.length;i++){
//            for(int j=0;j<dp[0].length;j++){
//                for(int k=0;k<dp[0][0].length;k++){
//                    dp[i][j][k] = -1;
//                }
//            }
//        }
//
//        return check(0,0,0,s1,s2,s3, dp);
//    }
//
//    public boolean check(int i1, int i2, int i3, String s1, String s2, String s3, int dp[][][]){
//        if(i1 == s1.length() && i2 == s2.length() && i3 == s3.length()){
//            return true;
//        }
//
//        if(dp[i1][i2][i3] != -1){
//            return dp[i1][i2][3] == 1;
//        }
//
//        boolean isInterLeave = false;
//
//        if(i1 < s1.length() && i3<s3.length() && s1.charAt(i1) == s3.charAt(i3)){
//            isInterLeave = isInterLeave || check(i1+1, i2,i3+1,s1,s2,s3,dp);
//        }
//
//        if(i2 < s2.length() && i3<s3.length() && s2.charAt(i2) == s3.charAt(i3)){
//            isInterLeave = isInterLeave || check(i1, i2+1, i3+1,s1,s2,s3,dp);
//        }
//
//        dp[i1][i2][i3] = isInterLeave ? 1 : 0;
//
//        return isInterLeave;
//    }


    // solution using 2d dp array


//    public boolean isInterleave(String s1, String s2, String s3) {
//        int dp[][] = new int[s1.length()+1][s2.length()+1];
//        // -1 represent not calculate yet
//        // 0 mean not interleaving
//        // 1 means interleaving
//
//        // prefill by -1
//        for(int i=0;i<dp.length;i++){
//            for(int j=0;j<dp[0].length;j++){
//                    dp[i][j] = -1;
//
//            }
//        }
//
//        return check(0,0,s1,s2,s3, dp);
//    }
//
//    public boolean check(int i1, int i2, String s1, String s2, String s3, int dp[][]){
//        int i3 = i1+i2;
//        if(i1 == s1.length() && i2 == s2.length() && i3 == s3.length()){
//            return true;
//        }
//
//        if(dp[i1][i2] != -1){
//            return dp[i1][i2] == 1;
//        }
//
//        boolean isInterLeave = false;
//
//        if(i1 < s1.length() && i3<s3.length() && s1.charAt(i1) == s3.charAt(i3)){
//            isInterLeave = isInterLeave || check(i1+1, i2,s1,s2,s3,dp);
//        }
//
//        if(i2 < s2.length() && i3<s3.length() && s2.charAt(i2) == s3.charAt(i3)){
//            isInterLeave = isInterLeave || check(i1, i2+1,s1,s2,s3,dp);
//        }
//
//        dp[i1][i2] = isInterLeave ? 1 : 0;
//
//        return isInterLeave;
//    }
//


    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length() + s2.length() != s3.length()){
            return false;
        }


        boolean dp[][] = new boolean[s1.length()+1][s2.length()+1];
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                    dp[i][j] = false;

            }
        }

        for(int i=0;i<=s1.length();i++){
            for(int j=0;j<=s2.length();j++){
                if(i==0 && j==0){
                    dp[i][j] = true;
                }else{
                    dp[i][j] = false;
                    if(i>0){
                        dp[i][j] = dp[i][j] || (dp[i-1][j] && (s1.charAt(i-1) == s3.charAt(i+j-1)));
                    }

                    if(j>0){
                        dp[i][j] = dp[i][j] || (dp[i][j-1] && (s2.charAt(j-1) == s3.charAt(i+j-1)));
                    }
                }

            }
        }

        return dp[s1.length()][s2.length()];

    }



}
