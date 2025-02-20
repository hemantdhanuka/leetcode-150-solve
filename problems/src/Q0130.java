//130. Surrounded Regions
public class Q0130 {
    public static void main(String[] args) {
        Q0130 obj = new Q0130();
        char testCase[][] = new char[][]{{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
        obj.solve(testCase);

        for(char[] t: testCase){
            System.out.println(t);
        }
    }
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;

        // traverse first row
        for(int j=0;j<n;j++){
            if(board[0][j] == 'O'){
                dfs(0, j, board, m,n);
            }
        }

        // traverse last row
        for(int j=0;j<n;j++){
            if(board[m-1][j] == 'O'){
                dfs(m-1, j, board, m,n);
            }
        }

        // traverse first column
        for(int i=0;i<n;i++){
            if(board[i][0] == 'O'){
                dfs(i, 0, board, m,n);
            }
        }

        // traverse last column
        for(int i=0;i<n;i++){
            if(board[i][n-1] == 'O'){
                dfs(i, n-1, board, m,n);
            }
        }


        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
                else if(board[i][j] == '.'){
                    board[i][j] = 'O';
                }
            }
        }

    }

    public void dfs(int i, int j, char[][] board, int m, int n){
        if(i<0 || j<0 || i==m || j==n ){
            return;
        }

        if(board[i][j] == 'X' || board[i][j] == '.'){
            return;
        }

        board[i][j] = '.';

        dfs(i,j+1, board, m,n);
        dfs(i, j-1, board,m,n);
        dfs(i+1,j, board, m,n);
        dfs(i-1, j, board, m,n);

    }

}
