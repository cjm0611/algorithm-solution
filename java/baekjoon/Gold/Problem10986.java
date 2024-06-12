package baekjoon.Gold;

import java.util.*;
import java.io.*;

// 나머지 합 (누적 합)
/*
    대략적인 문제 풀이
    1. 각 원소까지의 누적합을 구한다.
    2. 각각의 누적합을 M으로 나눈다. 나머지를 저장한다.
    3. 나머지가 0인 개수를 정답에 더한다. 나머지가 0인 것은 1부터 해당 값까지의 합이 나누어 떨어진다.
    4. 0~M-1 각각의 나머지의 개수를 센다.
    5. 4에서 센 개수에 대해 nC2의 개수를 센다. 범위의 시작과 끝을 지정하는 것으로, S[j] - S[i] = 0 이려면 S[j] = S[i]라는 것을 이용함.
    6. 5에서 센 값을 정답에 더한다.
 */
public class Problem10986 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N, M;
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        long[] S = new long[N+1];

        st = new StringTokenizer(br.readLine());
        int numOfZero = 0; // 누적합을 M으로 나누었을 때 나머지가 0인 것의 개수
        long answer = 0; // 10^6개의 수에 대한 (i, j) 쌍의 개수는 int의 범위를 벗어남.
        for (int i = 1; i <= N; i++) {
            int a = Integer.parseInt(st.nextToken());
            S[i] = S[i-1] + a;
            S[i] %= M;
            if (S[i] == 0) numOfZero++;
        }

        answer += numOfZero;
        long[] mods = new long[M];
        /*
            mods를 long으로 선언해야 하는 것에 주의.
            mods[i] * (mods[i] - 1) / 2;
            과정에서 int 범위를 초과할 가능성이 있음. (최악의 경우 10^6 * 10^6)
        */

        for (int i = 1; i <= N; i++) {
            int idx = (int) S[i];
            mods[idx]++;
        }

        for (int i = 0; i < M; i++) {
            if (mods[i] == 0 || mods[i] == 1) continue;
            answer += mods[i] * (mods[i] - 1) / 2;
        }

        System.out.println(answer);
    }
}
