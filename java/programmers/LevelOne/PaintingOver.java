package programmers.LevelOne;

import java.util.*;

public class PaintingOver {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        boolean[] isPainted = new boolean[n + 1];
        Arrays.fill(isPainted, true);

        for (int sectionNum : section) {
            isPainted[sectionNum] = false;
        }

        for (int i = n; i >= 1; i--) {
            if (isPainted[i]) continue;

            int start = i;
            int end = i - m + 1;

            answer++;
            for (int j = start; j >= end; j--) {
                if (j <= 0) continue;
                isPainted[j] = true;
            }
        }

        return answer;
    }
}
