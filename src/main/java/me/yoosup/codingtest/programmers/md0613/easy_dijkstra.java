package me.yoosup.codingtest.programmers.md0613;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class easy_dijkstra {
    // 노드의 개수
    int N;
    // 간선의 개수
    int M;

    //시작노드번호
    int start;

    //각 노드에 연결되어있는 노드 정보 리스트
    int[][] graph;

    // 방문한적 있는지 체크하는 목적의 리스트
    boolean[] visited;

    // 최단 거리 테이블을 모두 무한으로 초기화
    int[] distance;

    public int[] easy_dijkstra(int start) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(s -> s[0]));

        // 노드 방문여부 체크 배열
        boolean[] visited = new boolean[N];

        // 최단거리 배열 선언
        int[] distance = new int[N];

        // 최단거리 배열을 max_value로 초기화
        Arrays.fill(distance, Integer.MAX_VALUE);

        // 시작지점 start는 거리가 0
        distance[start] = 0;

        // 우선순위 큐에 간선정보와 노드정보를 넣는다.
        pq.add(new int[] {0, start});

        // 큐가 빌때까지
        while (!pq.isEmpty()) {
            // 큐의 맨위에 있는 것을 제거하고 cur에 대입
            int[] cur = pq.remove();
            // 노드정보 u = cur[1]
            int u = cur[1];
            // 방문한 노드라면 continue
            if(visited[u]) {
                continue;
            }

            // 방문하지 않았으면 노드정보를 true로 바꿈
            visited[u] = true;

            // 간선정보 v에 대해 v가 N이 될때까지
            for(int v = 0; v < N; v++) {
                // 만약 노드가 연결되어있지 않다면 continue;
                if(graph[u][v] == 0) {
                    continue;
                }
                
                // 만약 최단거리 배열의 u번째 값과 간선길이 graph[u][v]를 더한값이 distance[v]보다 작을경우
                if(distance[u] + graph[u][v] < distance[v]) {
                    // 최소거리 업데이트
                    distance[v] = distance[u];
                    // 우선순위 큐에 새롭게 추가
                    pq.add(new int[] {distance[v], v});
                }
            }
        }

        return distance;
    }
}
