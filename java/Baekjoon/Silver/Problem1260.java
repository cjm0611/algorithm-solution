package Baekjoon.Silver;

import java.util.*;
import java.io.*;

// DFS와 BFS
public class Problem1260 {
    static boolean[] visited;
    static int[][] graph;
    static StringBuilder sb = new StringBuilder();

    public static void dfs(int nodeIdx) {
        visited[nodeIdx] = true;
        sb.append(nodeIdx + " ");
        for (int i = 1; i < graph[nodeIdx].length; i++) {
            if (graph[nodeIdx][i] == 1 && !visited[i]) {
                dfs(i);
            }

        }
    }

    public static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start] = true;
        while (!q.isEmpty()) {
            int nodeIdx = q.poll();
            sb.append(nodeIdx + " ");
            for (int i = 1; i < graph[nodeIdx].length; i++) {
                if (graph[nodeIdx][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    q.offer(i);
                }
            }


        }
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 정점의 개수
        int m = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());

        visited = new boolean[n + 1];
        graph = new int[n + 1][n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            graph[s][e] = 1;
            graph[e][s] = 1;
        }

        dfs(start);
        System.out.println(sb);
        sb = new StringBuilder();

        visited = new boolean[n + 1];

        bfs(start);
        System.out.println(sb);
    }
}
