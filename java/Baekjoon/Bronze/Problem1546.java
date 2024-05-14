package Baekjoon.Bronze;

import java.util.Scanner;

// 평균 (수학)
public class Problem1546 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int subjectNum = sc.nextInt();
        int scoreSum = 0;
        int maxScore = -1;
        for (int i = 0; i< subjectNum; i++) {
            int score = sc.nextInt();
            scoreSum += score;
            if (maxScore < score) {
                maxScore = score;
            }
        }

        double originAvg = (double) scoreSum / subjectNum;
        double answer = (originAvg / maxScore) * 100;
        System.out.println(answer);
//        System.out.println(scoreSum * 100.0 / maxScore / subjectNum);
    }
}
