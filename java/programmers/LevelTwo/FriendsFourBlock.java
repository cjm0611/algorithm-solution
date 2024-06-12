package programmers.LevelTwo;

import java.util.*;

// 프렌즈4블록
public class FriendsFourBlock {
    static int M;
    static int N;
    static char[][] map;
    static Set<Point> removedPoints = new HashSet<>();

    public static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (!(o instanceof Point)) return false;
            Point point = (Point) o;
            return x == point.x && y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    public int solution(int m, int n, String[] board) {
        int answer = 0;
        M = m;
        N = n;
        map = new char[M][N];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = board[i].charAt(j);
            }
        }

        do {
            answer += removedPoints.size();
            removedPoints.clear();

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (isFourBlockSame(i, j)) {
                        deleteFourBlocks(i, j);
                    }
                }
            }

            for (Point removedPoint: removedPoints) {
                map[removedPoint.x][removedPoint.y] = 'X';
            }

            for (int j = 0; j < n; j++) {
                for (int i = m - 1; i >= 0; i--) {
                    if (map[i][j] == 'X') {
                        int start = i;
                        int count = 1;
                        while (isMapRange(start - 1, j) && map[start - 1][j] == 'X') {
                            start--;
                            count++;
                        }

                        if (start == 0) continue;

                        for (int k = i - count; k >= 0; k--) {
                            map[k + count][j] = map[k][j];
                            map[k][j] = 'X';
                        }
                    }

                    continue;
                }
            }
        } while (!removedPoints.isEmpty());

        return answer;
    }

    // 인접한 4개의 블록 삭제
    public void deleteFourBlocks(int x, int y) {
        removedPoints.add(new Point(x, y));
        removedPoints.add(new Point(x, y + 1));
        removedPoints.add(new Point(x + 1, y));
        removedPoints.add(new Point(x + 1, y + 1));
    }

    // 인접한 4개의 점이 같은 값을 가지는지 확인
    public boolean isFourBlockSame(int x, int y) {
        return isFourPointsInMap(x, y) && isFourPointsValueSame(x, y) && isFourPointsNotRemoved(x, y);
    }

    public boolean isFourPointsInMap(int x, int y) {
        return isMapRange(x, y) && isMapRange(x + 1, y) && isMapRange(x, y + 1) && isMapRange(x + 1, y + 1);
    }

    public boolean isMapRange(int x, int y) {
        return x >= 0 && x < M && y >= 0 && y < N;
    }

    public boolean isFourPointsValueSame(int x, int y) {
        return map[x][y] == map[x + 1][y] && map[x][y] == map[x][y + 1] && map[x][y] == map[x + 1][y + 1];
    }

    public boolean isFourPointsNotRemoved(int x, int y) {
        return map[x][y] != 'X' && map[x][y + 1] != 'X' && map[x + 1][y] != 'X' && map[x + 1][y + 1] != 'X';
    }
}
