package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem1388 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        char[][] floor = new char[N][M];
        int count = 0;

        for (int i = 0; i < N; i++) {
            floor[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (floor[i][j] == '-') {
                    if (j == M - 1 || floor[i][j + 1] == '|') {
                        count++;
                    }
                }

                if (floor[i][j] == '|') {
                    if (i == N - 1 || floor[i + 1][j] == '-') {
                        count++;
                    }
                }
            }
        }
        
        System.out.println(count);
    }
}
