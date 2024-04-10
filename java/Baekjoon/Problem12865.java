package Baekjoon;

import java.util.*;
import java.io.*;

// 평범한 배낭 - DP, 냅색
public class Problem12865 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N, K; // 물품의 수, 배낭의 크기
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int[] weight = new int[N + 1];
        int[] value = new int[N + 1];
        // 또는 arr[N + 1][2];로 해서 arr[i][0] = w, arr[i][1] = v로 저장
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int W, V; // 무게, 가치
            W = Integer.parseInt(st.nextToken());
            V = Integer.parseInt(st.nextToken());
            weight[i] = W;
            value[i] = V;
        }

        int[][] dp = new int[N + 1][K + 1];
        // 무게가 0일때는 초기값 0 그대로
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= K; j++) {
                int w = weight[i];
                if (w > j) { // 무게가 지금 배낭의 크기보다 크면, 못 넣음.
                    dp[i][j] = dp[i - 1][j];
                    continue;
                }

                int k = value[i];
                dp[i][j] = Math.max(dp[i - 1][j], k + dp[i - 1][j - w]);
            }
        }

        System.out.println(dp[N][K]);
    }
}