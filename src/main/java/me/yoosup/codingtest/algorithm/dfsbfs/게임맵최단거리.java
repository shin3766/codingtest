package me.yoosup.codingtest.algorithm.dfsbfs;

import java.util.*;

class 게임맵최단거리 {
    static int[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) {
        int[][] maps = new int[][] {{1,0,1,1,1}, {1,0,1,0,1}, {1,0,1,1,1}, {1,1,1,0,1}, {0,0,0,0,1}};
        visited = new int[maps.length][maps[0].length];
        int answer;

        bfs(maps, 0, 0);
        answer = visited[maps.length - 1][maps[0].length - 1];

        if (answer == 0) {
            answer = -1;
        }

        System.out.println(answer);
    }

    public static void bfs(int[][] maps, int x, int y) {
        int cx = x;
        int cy = y;
        visited[cx][cy] = 1;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {cx, cy});

        while(!q.isEmpty()) {
            int[] now = q.poll();

            for(int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];

                if(nx < 0 || nx >= maps.length || ny < 0 || ny >= maps[0].length) {
                    continue;
                }

                if(maps[nx][ny] != 0 && visited[nx][ny] == 0) {
                    visited[nx][ny] = visited[now[0]][now[1]] + 1;
                    q.offer(new int[] {nx, ny});
                }
            }
        }

    }
}