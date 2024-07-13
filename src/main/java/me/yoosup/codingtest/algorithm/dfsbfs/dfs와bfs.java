package me.yoosup.codingtest.algorithm.dfsbfs;

/*
https://www.acmicpc.net/problem/1260

입력 ::
첫째 줄에 정점의 개수 N(1 ≤ N ≤ 1,000), 간선의 개수 M(1 ≤ M ≤ 10,000),
탐색을 시작할 정점의 번호 V가 주어진다. 다음 M개의 줄에는 간선이 연결하는 두 정점의 번호가 주어진다.
어떤 두 정점 사이에 여러 개의 간선이 있을 수 있다. 입력으로 주어지는 간선은 양방향이다.

출력 ::
첫째 줄에 DFS를 수행한 결과를,
그 다음 줄에는 BFS를 수행한 결과를 출력한다.
V부터 방문된 점을 순서대로 출력하면 된다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class dfs와bfs {
    static StringBuilder sb = new StringBuilder();
    static int node;
    static int line;
    static int start;
    static int[][] arr;
    static boolean[] check;
    static PriorityQueue<Integer> q = new PriorityQueue<>();
    
    public static void main(String[] args) throws IOException {
        // 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 문자 하나씩 받아와서 N, M, start 만들기
        StringTokenizer st = new StringTokenizer(br.readLine());
        node = Integer.parseInt(st.nextToken());
        line = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());
        
        // 간선 정보에 맞춘 간섡정보 arr
        arr = new int[node + 1][node + 1];
        // 방문체크
        check = new boolean[node + 1];

        for(int i = 0; i < line; i++)  {
            StringTokenizer str = new StringTokenizer(br.readLine());
            
            int a = Integer.parseInt(str.nextToken());
            int b = Integer.parseInt(str.nextToken());
            
            // 인접행렬 방식
            arr[a][b] = arr[b][a] = 1;
        }
        
        dfs(start);
        check = new boolean[node + 1];
        
        bfs(start);
        System.out.println("sb = " + sb);
    }

    /*
    매개변수로 받을 것
    1. 시작점 int start
    2. boolean[] visited
    3. int[] arr
     */
    public static void dfs(int start) {
        check[start] = true;
        sb.append(start).append(" ");
        
        for(int i = 0; i <= node; i++) {
            if(arr[start][i] == 1 && !check[i]) {
                dfs(i);
            }
        }
    }

    public static void bfs(int start) {
        q.add(start);
        check[start] = true;
        
        while (!q.isEmpty()) {
            start = q.poll();
            sb.append(start).append(" ");
            
            for (int i = 1; i <= node; i++) {
                if(arr[start][i] == 1 && !check[i]) {
                    q.add(i);
                    check[i] = true;
                }
            }
        }
        
    }
}
