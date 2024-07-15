package me.yoosup.codingtest.algorithm.dfsbfs;

import java.awt.Point;
import java.util.*;

/*
bfs로 풀어보자

https://velog.io/@warmsy/%EB%B0%B1%EC%A4%80-2178%EB%B2%88-%EB%AF%B8%EB%A1%9C%ED%83%90%EC%83%89-java
1. 백준 7/4일자 풀이 보고 풀어봄 -> 과정을 적고 코드로 옮겨 보기
 */
public class 미로탐색_백준 {
    static int count = 0;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static boolean[][] visited;

    public static void main(String[] args) {
        int[][] rows = {{1, 0, 1, 1, 1, 1}, {1, 0, 1, 0, 1, 0}, {1, 0, 1, 0, 1, 1}, {1, 1, 1, 0, 1, 1}};
        int[][] arr = new int[4][6];

        bfs(0,0, rows);

        System.out.println(rows[rows.length - 1][rows[0].length - 1]);
    }

    // bfs 알고리즘 짜기
    static void bfs(int x, int y, int[][] rows) {
        // 큐 생성
        Queue<Point> queue = new LinkedList<>();
        // 큐에 현재 인수로 받은 위치 저장
        queue.offer(new Point(x, y));

        // 방문처리
        visited = new boolean[rows.length][rows[0].length];
        visited[x][y] = true;

        // 큐가 전부 비워질때까지 반복
        while (!queue.isEmpty()) {
            Point currentPoint = queue.poll();
            // 현재 point x,y 에서 사방위 체크 int i -> 3까지
            for (int i = 0; i < 3; i++) {
                int next_x = currentPoint.x + dx[i];
                int next_y = currentPoint.y + dy[i];

                // 만약 rows[x][y]가 범위를 벗어나면 continue;
                if (next_x < 0 || next_y < 0 || next_x >= rows.length || next_y >= rows[0].length) continue;

                // 만약 rows[x][y]가 0이면 continue;
                if (rows[next_x][next_y] == 0) continue;

            // 만약 rows[x][y]가 방문한 곳이면 continue;
                if (visited[next_x][next_y]) continue;

            // 위 조건을 충족하지 않으면 새로운 길이므로 새로운 x, y를 큐에 삽입
                queue.offer(new Point(next_x, next_y));
            // 방문처리
                visited[next_x][next_y] = true;
            // 최소 칸수를 구하기 위해 이전칸수 + 1하기
                rows[next_x][next_y] = rows[currentPoint.x][currentPoint.y] + 1;
            }
        }
    }
}
