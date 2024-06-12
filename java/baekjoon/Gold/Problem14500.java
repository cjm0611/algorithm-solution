package baekjoon.Gold;

import java.util.*;
import java.io.*;

// 테트로미노 - 골드4
public class Problem14500 {
    static int N, M; // 가로 세로
    static int[][] map;
    static int maxSum = -1;

    public static void calculateSum() {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
                if (i + 2 <= N) {
                    int sum = map[i][j] + map[i + 1][j] + map[i + 2][j];
                    if (j + 1 <= M) {
                        pq.add(sum + map[i][j + 1]);
                        pq.add(sum + map[i + 1][j + 1]);
                        pq.add(sum + map[i + 2][j + 1]);
                    }

                    if (j - 1 >= 1) {
                        pq.add(sum + map[i][j - 1]);
                        pq.add(sum + map[i + 1][j - 1]);
                        pq.add(sum + map[i + 2][j - 1]);
                    }

                    if (i + 3 <= N) {
                        pq.add(sum + map[i + 3][j]);
                    }
                }

                if (j + 2 <= M) {
                    int sum = map[i][j] + map[i][j + 1] + map[i][j + 2];
                    if (i - 1 >= 1) {
                        pq.add(sum + map[i - 1][j]);
                        pq.add(sum + map[i - 1][j + 1]);
                        pq.add(sum + map[i - 1][j + 2]);
                    }

                    if (i + 1 <= N) {
                        pq.add(sum + map[i + 1][j]);
                        pq.add(sum + map[i + 1][j + 1]);
                        pq.add(sum + map[i + 1][j + 2]);
                    }

                    if (j + 3 <= M) {
                        pq.add(sum + map[i][j + 3]);
                    }
                }

                if (i + 1 <= N && j + 1 <= M) {
                    pq.add(map[i][j] + map[i][j + 1] + map[i + 1][j] + map[i + 1][j + 1]);
                }

                if (i - 1 >= 1 && i + 1 <= N && j + 1 <= M) {
                    int sum = map[i][j] + map[i][j + 1];
                    pq.add(sum + map[i - 1][j] + map[i + 1][j + 1]);
                    pq.add(sum + map[i + 1][j] + map[i - 1][j + 1]);
                }

                if (i + 1 <= N && j - 1 >= 1 && j + 1 <= M) {
                    int sum = map[i][j] + map[i + 1][j];
                    pq.add(sum + map[i + 1][j - 1] + map[i][j + 1]);
                    pq.add(sum + map[i][j - 1] + map[i + 1][j + 1]);
                }

                if (!pq.isEmpty()) {
                    int localMaxSum = pq.remove();
                    if (localMaxSum > maxSum) {
                        maxSum = localMaxSum;
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                int num = Integer.parseInt(st.nextToken());
                map[i][j] = num;
            }
        }
        calculateSum();
        System.out.println(maxSum);
    }
}
