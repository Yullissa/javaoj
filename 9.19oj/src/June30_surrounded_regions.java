public class June30_surrounded_regions {
        private int raw;
        private int col;

        public void solve(char[][] board) {
            this.raw = board.length;
            if (raw < 1) {
                return;
            }
            this.col = board[0].length;
            if (raw <= 1 || col <= 1) {
                return;
            }

            for (int i = 0; i < col; i++) {
                dfs(board, 0, i);
                dfs(board, raw - 1, i);
            }

            for (int i = 0; i < raw; i++) {
                dfs(board, i, 0);
                dfs(board, i, col - 1);
            }

            for (int i = 0; i < raw; i++)
                for (int j = 0; j < col; j++) {
                    if (board[i][j] == '*')
                        board[i][j] = 'O';
                    else
                        board[i][j] = 'X';
                }
//        for (int i = 0; i < raw; i++){
//            for (int j = 0; j < col; j++) {
//                System.out.print(board[i][j]);
//            }
//            System.out.println();
//        }

        }

        private void dfs(char[][] board, int raw, int col) {
            if (raw < 0 || raw >= this.raw || col < 0 || col >= this.col) {
                return;
            }
            if (board[raw][col] == 'O') {
                board[raw][col] = '*';
                dfs(board, raw + 1, col);
                dfs(board, raw - 1, col);
                dfs(board, raw, col - 1);
                dfs(board, raw, col + 1);
            }

    }
}
