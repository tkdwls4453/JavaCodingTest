package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ9663 {
    public static int result = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] board = new int[n][n];

        for (int col = 0; col < n; col++) {
            if (board[0][col] == 0) {
                marking(0, col, board);
                dfs(1, board);
                removeMarking(0, col, board);
            }
        }

        System.out.println(result);
    }

    public static void dfs(int row, int[][] board) {
        if (row == board.length) {
            result++;
            return;
        }

        for (int i = 0; i < board.length; i++) {
            if (board[row][i] == 0) {
                marking(row, i, board);
                dfs(row+1, board);
                removeMarking(row, i, board);
            }
        }


    }

    // 현재 위치 기준 더 낮은 row 는 표시 X, 같은 행도 표시 X-> 밑으로만 내려가기 때문
    public static void marking(int r, int c, int[][] board){


        // 열 마킹
        for (int i = r; i < board.length; i++) {
            board[i][c] +=1;
        }

        for (int i = 1; i < board.length; i++) {
            if (r + i < board.length & c + i < board.length) {
                board[r+i][c+i]+=1;
            }else{
                break;
            }
        }

        for (int i = 1; i < board.length; i++) {
            if (r + i < board.length & c - i >= 0) {
                board[r+i][c-i]+=1;
            }else{
                break;
            }
        }
    }

    public static void removeMarking(int r, int c, int[][] board){

        // 열 마킹
        for (int i = r; i < board.length; i++) {
            board[i][c] -= 1;
        }

        for (int i = 1; i < board.length; i++) {
            if (r + i < board.length & c + i < board.length) {
                board[r + i][c + i] -= 1;
            }else{
                break;
            }
        }

        for (int i = 1; i < board.length; i++) {
            if (r + i < board.length & c - i >= 0) {
                board[r + i][c - i] -= 1;
            }else{
                break;
            }
        }
    }
}
