package Baekjoon.Silver;

import java.util.*;
import java.io.*;

// 바이러스 - BFS, DFS
public class Problem2606 {
    public static boolean[] visited;
    public static int[][] graph;
    public static int answer = 0;

    public static void bfs(int start) {
        Queue<Integer> q = new LinkedList();
        q.offer(start);
        visited[start] = true;

        while (!q.isEmpty())  {
            int nowVertex = q.poll();
            for (int i = 1; i < graph[nowVertex].length; i++) {
                if (graph[nowVertex][i] == 1 && !visited[i]) {
                    answer++;
                    visited[i] = true;
                    q.offer(i);
                }
            }
        }
    }

    public static void dfs(int start) {
        visited[start] = true;

        for (int i = 1; i < graph[start].length; i++) {
            if (graph[start][i] == 1 && !visited[i]) {
                answer++;
                dfs(i);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int vertexNum = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int edgeNum = Integer.parseInt(st.nextToken());

        visited = new boolean[vertexNum + 1];
        graph = new int[vertexNum + 1][vertexNum + 1];

        for (int i = 0; i < edgeNum; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            graph[s][e] = 1;
            graph[e][s] = 1;
        }

        bfs(1);
//        dfs(1);

        System.out.println(answer);
    }
}
