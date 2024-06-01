package Programmers.LevelTwo;

// 멀쩡한 사각형
public class FineSquare {
    class Solution {
        public long solution(int w, int h) {
            long deletedSquareNum = 0;
            if (w == h) return w * h - w;

            for (int i = 1; i <= w; i++) {
                double y = (double) h * i / w;
                double previousY = (double) h * (i - 1) / w;

                if (Math.floor(y) != Math.floor(previousY)) {
                    deletedSquareNum += Math.ceil(y) - Math.floor(previousY);
                } else {
                    deletedSquareNum += 1;
                }
            }

            return (long) w * h - deletedSquareNum;
        }
    }

}
