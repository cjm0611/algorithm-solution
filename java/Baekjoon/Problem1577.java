package Baekjoon;

import java.util.*;
import java.io.*;

public class Problem1577 {
    public static long[][] dp;
    public static boolean[][][] road;
    public static int N, M;

    public static int[] dx = {1, 0};
    public static int[] dy = {0, 1};

    public static long calculateDistance(int y, int x) {
        if (y == M && x == N) return 1L;
        if (dp[y][x] != -1) return dp[y][x];

        long count = 0L;
        for (int i = 0; i < 2; i++) {
            if (road[y][x][i]) continue; // 갈 수 없는 경우면 pass

            int newX = x + dx[i];
            int newY = y + dy[i];
            if (newY <= M && newX <= N) {
                count += calculateDistance(newY, newX);
            }
        }

        return dp[y][x] = count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        dp = new long[M + 1][N + 1];
        road = new boolean[M + 1][N + 1][2];
        for (int i = 0; i < M + 1; i++) {
            Arrays.fill(dp[i], -1);
        }

        st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        for (int i = 0; i < K; i++) {
            int a, b, c, d;
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());

            // 방향이 우측 상단으로 진행되려면 a < c, b < d 여야 함.(도착점이 시작점보다 우측 상단)
            if (a > c) { // b == d
                int temp = a;
                a = c;
                c = temp;
            } else if (b > d) { // a == c
                int temp = b;
                b = d;
                d = temp;
            }

            if (a < c) {
                road[b][a][0] = true; // 오른쪽 이동(road[b][a + 1]) 불가
            } else {
                road[b][a][1] = true; // 상단 이동(road[b + 1][a] 불가
            }
        }

        long answer = calculateDistance(0, 0);
        System.out.println(answer);
    }
}
