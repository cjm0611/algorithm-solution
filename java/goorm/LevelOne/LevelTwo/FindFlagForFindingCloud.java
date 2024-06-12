package goorm.LevelOne.LevelTwo;

import java.io.*;
import java.util.*;

// 걸린 시간: 13분
// 구름 찾기 깃발
/*
	각 격자판을 돌면서, 구름이 없는 칸이라면 주변의 8칸을 찾는다.
	8칸은 dx, dy 배열로 저장한다.
	map size안에 있고, 그 칸에 구름이 있는 경우 count를 ++
*/
class FindFlagForFindingCloud {
    public static int[] dx = {1, -1, 0, 0, 1, -1, 1, -1};
    public static int[] dy = {0, 0, 1, -1, 1, -1, -1, 1};
    public static int mapSize;
    public static int[][] map;

    public static int findGoorm(int x, int y) {
        int sum = 0;
        for (int i = 0; i < 8; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];

            if (newX >= 0 && newX < mapSize && newY >= 0 && newY < mapSize && map[newX][newY] == 1) {
                sum++;
            }
        }

        return sum;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        mapSize = Integer.parseInt(st.nextToken()); // 게임판의 크기
        int K = Integer.parseInt(st.nextToken()); // 깃발의 값

        map = new int[mapSize][mapSize];

        for (int i = 0; i < mapSize; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < mapSize; j++) {
                int num = Integer.parseInt(st.nextToken());
                map[i][j] = num;
            }
        }

        int answer = 0;
        for (int i = 0; i < mapSize; i++) {
            for (int j = 0; j < mapSize; j++) {
                if (map[i][j] == 1) continue;
                int sum = findGoorm(i, j);
                if (sum == K) {
                    answer++;
                }
            }
        }

        System.out.println(answer);
    }
}