import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Q0036 {
    public static void main(String[] args) {
        Q0036 obj = new Q0036();
        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '.', '8', '.', '.', '.', '.', '6', '.'},
                {'.', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        System.out.println(obj.isValidSudoku(board)); // Output: true or false
    }

    public boolean isValidSudoku(char[][] board) {

        Set<Character> rowsMap[] = new Set[9];
        for(int i=0;i<9;i++){
            rowsMap[i] = new HashSet<>();
        }

        Set<Character> columnMap[] = new Set[9];
        for(int i=0;i<9;i++){
            columnMap[i] = new HashSet<>();
        }


        Set<Character> matrixMap[][] = new Set[3][3];
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                matrixMap[i][j] = new HashSet<>();
            }
        }

        // logic
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){

                char value = board[i][j];
                if(value == '.'){
                    continue;
                }else{
                    // rowsMap check
                    if(rowsMap[i].contains(value)){
                        return false;
                    }else{
                        rowsMap[i].add(value);
                    }

                    // columnMap check
                    if(columnMap[j].contains(value)){
                        return false;
                    }else{
                        columnMap[j].add(value);
                    }

                    // 3*3 matric map
                    int matrixI = i/3;
                    int matrixJ = j/3;
                    if(matrixMap[matrixI][matrixJ].contains(value)){
                        return false;
                    }else{
                        matrixMap[matrixI][matrixJ].add(value);
                    }
                }

            }
        }

        return true;
    }

}
