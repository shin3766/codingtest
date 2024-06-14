package me.yoosup.codingtest.programmers.md0613;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class solution {
    // 노드의 갯수
    int N;

    // fares의 크기
    int E;

    // 배열
    int[][] matrix;

    public int solution(int n, int s, int a, int b, int[][] fares) {
        N = n;
        E = fares.length;
        // 다익스트라를 위한 배열
        matrix = new int[n][n];

        // fares배열을 다 돌면서
        for (int i = 0; i < E; i++) {
            // u는 fares[i] 의 첫번째 요소 시작지점 - 1 :: 배열에 사용하기위해 변환
            int u = fares[i][0] - 1;
            // u는 fares[i] 의 두번째 요소 도착지점 - 1 :: 배열에 사용하기위해 변환
            int v = fares[i][1] - 1;
            int cost = fares[i][2];

            // 2차원배열에 정보 추가
            matrix[u][v] = cost;
            matrix[v][u] = cost;
        }

        // 잘 모르겠는 부분
        int[] together = dijkstra(s - 1);
        int minCost = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            int[] alone = dijkstra(i);
            int cost = together[i] + alone[a - 1] + alone[b - 1];
            if (cost < minCost) {
                minCost = cost;
            }
        }
        return minCost;
    }

    public int[] dijkstra(int start) {
        // 우선순위 큐(뒤에 comparator 사용)
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        // 방문정보를 담는 visited
        boolean[] visited = new boolean[N];

        // 거리정보를 담는 distance
        int[] distance = new int[N];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[start] = 0;
        pq.add(new int[]{0, start});

        while (!pq.isEmpty()) {
            int[] cur = pq.remove();
            int u = cur[1];
            if (visited[u]) {
                continue;
            }

            visited[u] = true;
            for (int v = 0; v < N; v++) {
                if (matrix[u][v] == 0) {
                    continue;
                }
                if (distance[u] + matrix[u][v] < distance[v]) {
                    distance[v] = distance[u] + matrix[u][v];
                    pq.add(new int[] {distance[v], v});
                }
            }
        }

        return distance;
    }
}

public class 합승택시요금 {
    public static void main(String[] args) {
        solution sol = new solution();

        int[][] fares = {{4, 1, 10}, {3, 5, 24}, {5, 6, 2}, {3, 1, 41}, {5, 1, 24}, {4, 6, 50}, {2, 4, 66}, {2, 3, 22}, {1, 6, 25}};

        int answer = sol.solution(6, 4, 6, 2, fares);

        System.out.println(answer);
    }
}