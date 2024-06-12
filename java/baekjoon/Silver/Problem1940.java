package baekjoon.Silver;

import java.io.*;
import java.util.*;

// 주몽 - 실버, 투포인터
public class Problem1940 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 재료의 개수
        int M = Integer.parseInt(br.readLine()); // 목표가 되는 합
        ArrayList<Integer> arr = new ArrayList<>(N);

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            int num = Integer.parseInt(st.nextToken());
            arr.add(num);
        }

        Collections.sort(arr);

        int startIdx = 0;
        int endIdx = N - 1;
        int count = 0;
        while (startIdx != endIdx) {
            int sum = arr.get(startIdx) + arr.get(endIdx);
            if (sum < M) {
                startIdx++;
            } else if (sum > M) {
                endIdx--;
            } else {
                count++;
                endIdx--;
            }
        }

        System.out.println(count);
    }
}
