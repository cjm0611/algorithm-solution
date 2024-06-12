package baekjoon.Gold;

import java.util.*;
import java.io.*;

// DDR (DP)
public class Problem2342 {
    public static int size = 0;
    public static int[][][] dp;
    public static int[] step;

    public static int move(int s, int e) {
        if (s == 0) return 2;
        if (s == e) return 1;
        if (Math.abs(s - e) == 2) return 4;
        return 3;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split(" "); // 1 2 2 4 0 length = 5
        size = arr.length - 1; // size: 4 (idx: 0~3)
        step = new int[size];
        for (int i = 0; i < size; i++) {
            step[i] = Integer.parseInt(arr[i]);
        }

        dp = new int[5][5][size];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                Arrays.fill(dp[i][j], Integer.MAX_VALUE);
            }
        }

        int answer = search(0, 0, 0);
        System.out.println(answer);
    }

    public static int search(int idx, int left, int right) {
//        System.out.println("idx: " + idx + ", left: " + left + ", right: " + right);
        if (idx == size) return 0; // 마지막 step에서는 옮길 곳이 없음
        if (dp[left][right][idx] != Integer.MAX_VALUE) return dp[left][right][idx];
        int next = step[idx];
//        System.out.println("next: " + next);
        dp[left][right][idx] = Math.min(
                (search(idx + 1, next, right) + move(left, next)), //왼발을 움직인 경우
                (search(idx + 1, left, next) + move(right, next)) //오른발을 움직인 경우
        );

//        System.out.println("dp[" + idx + "][" + left + "][" + right + "]: " + dp[idx][left][right]);
        return dp[left][right][idx];
    }
}
