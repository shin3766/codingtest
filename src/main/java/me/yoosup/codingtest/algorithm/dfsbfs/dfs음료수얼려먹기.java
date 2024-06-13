package me.yoosup.codingtest.algorithm.dfsbfs;

public class dfs음료수얼려먹기 {
    public static int n = 4;
    public static int m = 5;
    static int[][] input = new int[][] {{0,0,1,1,0} , {0,0,0,1,1}, {1,1,1,1,1}, {0,0,0,0,0}};
    public static void main(String[] args) {
        int result = 0;

        for(int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[0].length; j++) {
                // 현재 위치에서 dfs 수행
                // 만약 0을만나면 dfs를 수행하여 0과 연결된 모든 0을 1로 만들고 result에 +1하기
                if(dfs(i, j)) {
                    result += 1;
                }
            }
        }
        System.out.println(result);
    }

    public static boolean dfs(int x, int y) {
        if(x <= -1 || x >= n || y <= -1 || y >= m) {
            return false;
        }

        // 현재노드를 방문하지 않았다면
        if(input[x][y] == 0) {
            // 방문처리후 모든 방위로 재귀적인 호출
            input[x][y] = 1;
            dfs(x - 1, y);
            dfs(x, y - 1);
            dfs(x +1, y);
            dfs(x, y +1);
            return true;
        }
        return false;
    }
}
