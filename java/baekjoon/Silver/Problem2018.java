package baekjoon.Silver;

import java.io.*;

// 수들의 합 - 투포인터
public class Problem2018 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int startIdx = 1;
        int endIdx = 1;
        int sum = 1;
        int count = 1;

        while (endIdx != N) {
            if (sum < N) {
                endIdx++;
                sum += endIdx;
            } else if (sum > N) {
                sum -= startIdx;
                startIdx++;
            } else { // sum == N
                count++;
                endIdx++;
                sum += endIdx;
            }
        }

        System.out.println(count);
    }
}
