package me.yoosup.codingtest.algorithm.dfsbfs;

import java.awt.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 미로탐색 {
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static Queue<Point> q = new LinkedList<>();
    static boolean[][] visited;
    public static void main(String[] args) {
        //
//        int[][] maze = {{1,0,1,1,1,1},{1,0,1,0,1,0},{1,0,1,0,1,1},{1,1,1,0,1,1}};
        int[][] maze = {{1,0,1,1,1,0,1,1,1,0,1,1,1,0,1,1,1,0,1,1,1,0,1,1,1}, {1,1,1,0,1,1,1,0,1,1,1,0,1,1,1,0,1,1,1,0,1,1,1,0,1}};

        // 1. 1,1에서부터 시작
        bfs(maze);

        System.out.println(maze[maze.length - 1][maze[0].length - 1]);

        // 2. 좌표대로 움직이기
        // 3. 움직인 좌표가 1이면 이전 숫자들 더하기 0이면 패스
        // 4. 맨 마지막 좌표의 숫자를 프린트 아웃
    }

    public static void bfs(int[][] maze) {
        Point point = new Point(0, 0);
        q.offer(point);

        visited = new boolean[maze.length][maze[0].length];
        for(int i = 0; i < maze.length; i++) {
            for(int j = 0; j < maze[0].length; j++) {
                if(maze[i][j] == 0) {
                    visited[i][j] = true;
                }
            }
        }

        // q가 비워질때까지 반복
        while(!q.isEmpty()) {
            Point currentPoint = q.poll();

            for(int i = 0; i < 4; i++) {
                int newX = currentPoint.x + dx[i];
                int newY = currentPoint.y + dy[i];

                if(newX < 0 || newX >= maze[0].length) {
                    continue;
                } else if (newY < 0 || newY >= maze.length) {
                    continue;
                }

                if(maze[newY][newX] != 0 && !visited[newY][newX]) {
                    Point newPoint = new Point(newX, newY);
                    maze[newY][newX] = maze[currentPoint.y][currentPoint.x] + 1;
                    visited[newY][newX] = true;
                    q.offer(newPoint);
                }
            }
        }
    }
}
