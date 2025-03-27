import java.util.Arrays;

public class Q0006 {
    public static void main(String[] args) {
        Q0006 obj = new Q0006();
        System.out.println(obj.convert("PAYPALISHIRING", 3));
    }

    public String convert(String s, int numRows) {
        if(numRows == 1){
            return s;
        }

        StringBuilder strings[] = new StringBuilder[numRows];
        for(int i=0;i<strings.length;i++){
            strings[i] = new StringBuilder();
        }


        int rowNo =0;
        int direction = 1;
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);

            strings[rowNo].append(ch);

            if(rowNo == 0){
                direction = 1;
            }
            else if(rowNo == numRows -1){
                direction = -1;
            }
            else{
                // keep same direction.
            }

            rowNo = rowNo + direction;
        }

        StringBuilder ans = new StringBuilder();
        for(StringBuilder ansPart: strings){
            ans.append(ansPart);
        }

        return ans.toString();
    }

}
