package baekjoon.Gold;

import java.util.*;
import java.io.*;

public class Problem10282 {
    static ArrayList<Node>[] graph;
    static class Node implements Comparable<Node>{
        int index;
        int cost;

        public Node(int index, int cost) {
            this.index = index;
            this.cost = cost;
        }

        /**PriorityQueue<Node> pq = new PriorityQueue<Node>
         ((o1, o2) -> Integer.compare(o1.cost, o2.cost));
         **/
        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.cost, other.cost);
            // cost가 낮은 순으로 정렬
        }
    }

    public static void Dijkstra(int vertexNum, int start) {
        boolean[] visited = new boolean[vertexNum + 1];
        int[] dist = new int[vertexNum + 1];
        int INF = Integer.MAX_VALUE;
        Arrays.fill(dist, INF);
        dist[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>(); // 오른쪽은 타입 추론되어서 안적는거임. (java 7이후)
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            int current = pq.poll().index;
            if (visited[current]) continue;
            visited[current] = true;

            // 현재 정점과 연결된 정점들 확
            for (Node next : graph[current]) {
                if (dist[next.index] > dist[current] + next.cost) {
                    dist[next.index] = dist[current] + next.cost;
                    pq.offer(new Node(next.index, dist[next.index]));
                }
            }
        }

        int answer = 0;
        int maxCost = -1;
        for (int i : dist) {
            if (i != INF) {
                answer++;
                if (maxCost < i) {
                    maxCost = i;
                }
            }
        }
        System.out.println(answer + " " + maxCost);
    }

    // INF가 아닌 수가 감염된 컴퓨터의 개수
    // 그리고 거리 중에 최댓값을 노출해야 함.
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCaseNum = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for (int i = 0; i < testCaseNum; i++) {
            st = new StringTokenizer(br.readLine());
            int nodeNum = Integer.parseInt(st.nextToken());
            int edgeNum = Integer.parseInt(st.nextToken());
            int startNode = Integer.parseInt(st.nextToken());
            graph = new ArrayList[nodeNum + 1];
            for (int j = 0; j <= nodeNum; j++) {
                graph[j] = new ArrayList<>();
            }


            for (int k = 0; k < edgeNum; k++) {
                st = new StringTokenizer(br.readLine());
                int e = Integer.parseInt(st.nextToken()); // 함정, e를 먼저 받음
                int s = Integer.parseInt(st.nextToken());
                int cost = Integer.parseInt(st.nextToken());
                graph[s].add(new Node(e, cost));
            }

            Dijkstra(nodeNum, startNode);
        }
    }
}
