package baekjoon.Bronze;

import java.util.Scanner;

// 11720 숫자의 합 (자료구조)
public class Problem11720 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String sNum = sc.next();
        char[] cNum = sNum.toCharArray();
        int answer = 0;
        for (int i = 0; i < cNum.length; i++) {
            answer += Character.getNumericValue(cNum[i]);
        }
        System.out.println(answer);
    }
}