package goorm.LevelOne;

import java.io.*;
import java.util.*;

/*
최장 맨해튼 거리
 */
public class TheLongestManhattanDistance {
//    // 풀이 1
//    public static void main(String[] args) throws Exception {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        int[] points = new int[4];
//        for (int i = 0; i < 4; i++) {
//            points[i] = Integer.parseInt(st.nextToken());
//        }
//
//        // case1
//        int maxDistance = Math.abs(points[0] - points[1]) + Math.abs(points[2] - points[3]);
//
//        // case2
//        maxDistance = Math.max(maxDistance, Math.abs(points[0] - points[2]) + Math.abs(points[1] - points[3]));
//
//        // case3
//        maxDistance = Math.max(maxDistance, Math.abs(points[0] - points[3]) + Math.abs(points[2] - points[1]));
//
//        System.out.println(maxDistance);
//    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] points = new int[4];
        for (int i = 0; i < 4; i++) {
            points[i] = Integer.parseInt(st.nextToken());
        }

        int[][] combi = {
                {0, 1, 2, 3},
                {0, 2, 1, 3},
                {0, 3, 2, 1}
        };

        int answer = 0;
        for (int i = 0; i < 3; i++) {
            int a = points[combi[i][0]];
            int b = points[combi[i][1]];
            int c = points[combi[i][2]];
            int d = points[combi[i][3]];

            answer = Math.max(answer, Math.abs(a - b) + Math.abs(c - d));
        }

        System.out.println(answer);
    }
}
