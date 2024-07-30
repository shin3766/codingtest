package me.yoosup.codingtest.algorithm.dfsbfs;

import java.awt.*;
import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class 단지번호붙이기 {
    static boolean[][] visited;
    static int[][] houses;
    // 참고
    static List<Integer> result = new LinkedList<>();

    static int cnt;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        // 참고
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(bf.readLine());
        houses = new int[N][N];
        visited = new boolean[N][N];
        cnt = 1;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < N; j++) {
                houses[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(houses[i][j] == 1 && !visited[i][j]) {
                    dfs(i,j);
                    result.add(cnt);
                    cnt = 1;
                }
            }
        }
        System.out.println("result = " + result);
    }

    public static void dfs(int x, int y) {
        // 현재 지점인 포인트를 visited에서 방문
        visited[x][y] = true;

        for(int i=0;i<4;i++) {
            int nx = dx[i]+x;
            int ny = dy[i]+y;

            if(nx>=0 && ny>=0 && nx<N && ny<N && !visited[nx][ny] && houses[nx][ny]==1) {
                cnt++;
                dfs(nx,ny);
            }
        }
    }
}
