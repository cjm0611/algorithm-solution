package baekjoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem11660 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int mapSize = Integer.parseInt(st.nextToken());
        int quizNum = Integer.parseInt(st.nextToken());
        int sum = 0;
        int[][] map = new int[mapSize + 1][mapSize + 1];
        int[][] D = new int[mapSize + 1][mapSize + 1]; // (0, 0) -> (i, j)까지의 sum의 합
        for (int i = 1; i <= mapSize; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= mapSize; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 합 배열 저장하기
        for (int i = 1; i <= mapSize; i++) {
            for (int j = 1; j <= mapSize; j++) {
                D[i][j] = D[i - 1][j] + D[i][j - 1] - D[i - 1][j - 1] + map[i][j];
            }
        }

        for (int i = 0; i < quizNum; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            // 결과 계산하기
            System.out.println(D[x2][y2] - D[x1 - 1][y2] - D[x2][y1 - 1] + D[x1 - 1][y1 - 1]);
        }

    }
}
