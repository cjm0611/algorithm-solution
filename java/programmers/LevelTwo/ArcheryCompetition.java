package programmers.LevelTwo;

// 양궁 대회
public class ArcheryCompetition {
    static int[] apeach;
    static int maxArrow;
    static int maxDiff = Integer.MIN_VALUE;
    static int[] maxBoard = new int[11];

    public void backTracking(int count, int[] current) {
        if (count == maxArrow) {
            int diff = calculateDiff(current);
            if (diff >= maxDiff) {
                maxDiff = diff;
                maxBoard = current.clone();
            }
            return;
        }

        for (int i = 0; i < 11 && current[i] <= apeach[i]; i++) {
            current[i] += 1;
            backTracking(count + 1, current);
            current[i] -= 1;
        }
    }

    public int[] solution(int n, int[] info) {
        apeach = info;
        maxArrow = n;
        int[] current = new int[11];
        backTracking(0, current);
        if (maxDiff <= 0) return new int[]{-1};
        return maxBoard;
    }

    public int calculateDiff(int[] lion) {
        int apeachSum = 0, lionSum = 0;
        for (int i = 0; i < 11; i++) {
            if (apeach[i] == 0 && lion[i] == 0) continue;
            if (lion[i] > apeach[i]) {
                lionSum += 10 - i; // 원래 점수
            } else {
                apeachSum += 10 - i;
            }
        }

        if (lionSum - apeachSum > 0) return lionSum - apeachSum;
        return -1;
    }
}
