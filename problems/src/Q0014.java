public class Q0014 {
    public static void main(String[] args) {

    }


    public String longestCommonPrefix(String[] strs) {
        StringBuilder ans = new StringBuilder();

        String firstString = strs[0];
        outer: for(int i=0;i<firstString.length();i++){
            char ch = firstString.charAt(i);

            for(int j=1;j<strs.length;j++){
                String nextString = strs[j];

                if(i > nextString.length()-1){
                    break outer;
                }

                if(nextString.charAt(i) != ch){
                    break outer;
                }
            }

            ans = ans.append(ch);
        }

        return ans.toString();
    }


}
