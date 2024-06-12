package programmers.LevelTwo;

import java.util.*;

// 거리두기 확인하기
public class CheckDistancing {
    public static int mapSize = 5;
    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, 1, 0, -1};
    public class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int[] solution(String[][] places) {
        int[] answer = new int[5];

        for (int i = 0; i < 5; i++) {
            answer[i] = checkKeepDistance(places[i]);
        }

        return answer;
    }

    public int checkKeepDistance(String[] place) {
        for (int i = 0; i < mapSize; i++) {
            for (int j = 0; j < mapSize; j++) {
                if (place[i].charAt(j) == 'P') {
                    boolean isKeepDistance = bfs(i, j, place);
                    if (!isKeepDistance) {
                        return 0;
                    }
                }

            }
        }

        return 1;

    }

    public boolean bfs(int x, int y, String[] place) {
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(x, y));
        boolean[][] visited = new boolean[5][5];
        int[][] distance = new int[5][5];

        visited[x][y] = true;

        while (!q.isEmpty()) {
            Point current = q.poll();

            for (int i = 0; i < 4; i++) {
                int newX = current.x + dx[i];
                int newY = current.y + dy[i];

                if (isPointInMap(newX, newY) && !visited[newX][newY]) {
                    if (place[newX].charAt(newY) == 'O') {
                        q.add(new Point(newX, newY));
                        visited[newX][newY] = true;
                        distance[newX][newY] = distance[current.x][current.y] + 1;
                    } else if (place[newX].charAt(newY) == 'P') {
                        if ((distance[current.x][current.y] + 1) <= 2) {
                            return false;
                        }
                    }
                }
            }
        }

        return true;
    }

    public boolean isPointInMap(int x, int y) {
        return x >= 0 && x < mapSize && y >= 0 && y < mapSize;
    }
}
