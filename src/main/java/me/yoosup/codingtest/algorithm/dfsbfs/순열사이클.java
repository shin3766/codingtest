package me.yoosup.codingtest.algorithm.dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 순열사이클 {
    // 순열 사이클의 개수를 구하는 프로그램
    // dfs로 하나의 사이클을 다돌고 visited가 모두 true가 될때 까지 반복
    // visited가 모두 true 이면 answer++

    static boolean[] visited;
    static int[] map;
    static int[][] arr;
    static int cycle;
    public static void main(String[] args) throws IOException {
        // 첫째줄은 테스트케이스의 개수 :: T
        // 둘째줄에는 순열의 크기
        // 셋째줄에는 술열의 요소

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int testCase = Integer.parseInt(br.readLine());

        // testNum이 testCase보다 작을때 반복
        for(int test = 0; test < testCase; test++) {
            // 순열의 최대개수를 입력 받음 -> arr과 visited의 크기 결정
            int node = Integer.parseInt(br.readLine());
            map = new int[node + 1];
            cycle = 0;
            // 순열의 요소를 입력받음
            st = new StringTokenizer(br.readLine());
            for(int i = 1; i <= node; i++) {
                map[i] = Integer.parseInt(st.nextToken());
            }

            visited = new boolean[node + 1];

            // 입력받은 arr을 기준으로 visited체크를 한후 dfs 적용하는 과정
            for(int i = 1; i <= node; i++) {
                if(!visited[i]) {
                    dfs(i);
                    cycle++;
                }
            }
            System.out.println(cycle);
        }
    }

    public static void dfs(int start) {
        visited[start] = true;
        int next = map[start];
        if(!visited[next]) {
            dfs(map[start]);
        }
    }
}
