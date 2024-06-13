package me.yoosup.codingtest.programmers.md0612;

public class 이웃한칸 {
    public static void main(String[] args) {

        String[][] board = {{"blue", "red", "orange", "red"}, {"red", "red", "blue", "orange"}, {"blue", "orange", "red", "red"}, {"orange", "orange", "red", "blue"}};
        int count = solution(board, 1, 1);

        System.out.println("count = " + count);
    }
    public static int solution(String[][] board, int h, int w) {
        int answer = 0;
        int[] dh = {0, 1, -1, 0};
        int[] dw = {1, 0, 0, -1};

        int count = 0;
        String base = board[h][w];

        for (int i = 0; i <= 3; i++) {
            int hh = h + dh[i];
            int ww = w + dw[i];
            System.out.println("hh = " + hh + " ww = " + ww);
            if (hh >= 0 && hh < board.length && ww >= 0 && ww < board[hh].length) {
                if (base.equals(board[hh][ww])) {
                    count++;
                }
            }
        }
        return count;
    }
}
