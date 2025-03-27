public class Q0289 {
    public static void main(String[] args) {
        Q0289 obj = new Q0289();

        int[][] board = new int[][]{{0,1,0},{0,0,1},{1,1,1},{0,0,0}};
        obj.gameOfLife(board);


        for(int[] b: board){
            for(int a: b){
                System.out.print(a);
            }
            System.out.println();
        }

    }

    public void gameOfLife(int[][] board) {
        // replace 0 with 2
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                if(board[i][j] == 0){
                    board[i][j] = 2;
                }
            }
        }


        // logic
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                if(isLiveCell(board[i][j])){
                    // live cell formula
                    int neighbourLive = getLiveNeighbourCount(i, j, board);
                    if(neighbourLive != 2 && neighbourLive != 3){
                        board[i][j] = -1 * board[i][j];
                    }
                }else{
                    // dead cell condition
                    int neighbourLive = getLiveNeighbourCount(i, j, board);
                    if(neighbourLive == 3 ){
                        board[i][j] = -1 * board[i][j];
                    }
                }
            }
        }


        // set original values
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                if(board[i][j] == -2 || board[i][j] == 1){
                    board[i][j] = 1;
                }else{
                    board[i][j] = 0;
                }
            }
        }



    }

    public boolean isLiveCell(int value){
        return Math.abs(value) == 1;
    }

    public int getLiveNeighbourCount(int i, int j, int[][] board){
        int m = board.length;
        int n = board[0].length;

        int[] dx = new int[]{ 0, 1, -1};
        int[] dy = new int[]{ 0, 1, -1 };

        int cellCount = 0;
        for(int k=0;k<3;k++){
            for(int l=0;l<3;l++){
                if(k==0 && l==0){
                    continue;
                }

                int x = i+dx[k];
                int y=  j+dy[l];

                if(x < 0 || y < 0 || x >= m || y >= n){
                    continue;
                }

                if(Math.abs(board[x][y]) == 1){
                    cellCount++;
                }
            }
        }

        return cellCount;
    }

}
