package goorm.LevelOne;

import java.io.*;
import java.util.*;

// 가장 큰 사각형
public class TheLargestSquare {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int max = -1;
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            if (x * y > max) {
                max = x * y;
            }
        }
        System.out.println(max);
    }
}
