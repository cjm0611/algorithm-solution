package Baekjoon.Silver;

import java.util.*;
import java.io.*;

// 유기농 배추 - BFS, DFS
public class Problem1012 {
    private static boolean[][] visited;
    private static boolean[][] graph;
    private static int answer = 0;
    private static int[] dx = { 0, 1, 0, -1 };
    private static int[] dy = { 1, 0, -1, 0 };
    private static int m;
    private static int n;


//    public static void dfs(int x, int y) {
//        visited[x][y] = true;
//
//        for (int i = 0; i < 4; i++) {
//            int newX = x + dx[i];
//            int newY = y + dy[i];
//
//            if (newX >= 0 && newX < m && newY >= 0 && newY < n) {
//                if (graph[newX][newY] && !visited[newX][newY]) {
//                    dfs(newX, newY);
//                }
//
//            }
//        }
//    }

    public static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<int[]>();
        q.offer(new int[] {x, y});
        visited[x][y] = true;

        while (!q.isEmpty()) {
            int[] now = q.poll();

            for (int i = 0; i < 4; i++) {
                int newX = now[0] + dx[i];
                int newY = now[1] + dy[i];

                if (newX >= 0 && newX < m && newY >= 0 && newY < n) {
                    if (graph[newX][newY] && !visited[newX][newY]) {
                        q.offer(new int[] {newX, newY});
                        visited[newX][newY] = true;
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int testcaseNum = Integer.parseInt(br.readLine());

        for (int t = 0; t < testcaseNum; t++) {
            answer = 0;
            st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            visited = new boolean[m][n];
            graph = new boolean[m][n];
            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                graph[x][y] = true;
            }

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (graph[i][j] && !visited[i][j]) {
                        answer++;
//                        dfs(i, j);
                        bfs(i, j);
                    }
                }
            }

            System.out.println(answer);
        }

    }
}
