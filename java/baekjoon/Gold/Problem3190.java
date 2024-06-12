package baekjoon.Gold;

import java.io.*;
import java.util.*;

// 뱀 - 골드4, 구현
public class Problem3190 {
    static int mapSize;
    static int appleNum;
    static int[][] map;
    static final int[] dx = {-1, 0, 1, 0}; // 상, 우, 하, 좌
    static final int[] dy = {0, 1, 0, -1};

    public static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static class DirectionInfo {
        int time;
        char direction;

        public DirectionInfo(int time, char direction) {
            this.time = time;
            this.direction = direction;
        }
    }

    public static int directionTransform(int currentDirection, char direction) {
        if (direction == 'D') {
            /*
            U -> R // idx: 0 -> 1
            D -> L // idx: 2 -> 3
            L -> U // idx: 3 -> 0
            R -> D // idx: 1 -> 2
             */
            return (currentDirection + 1) % 4;
        } else {
            /*
            U -> L // idx: 0 -> 3
            L -> D // idx: 3 -> 2
            D -> R // idx: 2 -> 1
            R -> U // idx: 1 -> 0
             */
            return (currentDirection + 3) % 4;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        mapSize = Integer.parseInt(br.readLine());
        map = new int[mapSize + 1][mapSize + 1];
        appleNum = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for (int i = 0; i < appleNum; i++) {
            st = new StringTokenizer(br.readLine());
            int x, y;
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            map[x][y] = 1;
        }

        int directionNum = Integer.parseInt(br.readLine());
        Queue<DirectionInfo> q = new LinkedList<>();
        for (int i = 0; i < directionNum; i++) {
            st = new StringTokenizer(br.readLine());
            int time;
            char direction;
            time = Integer.parseInt(st.nextToken());
            direction = st.nextToken().charAt(0);
            q.add(new DirectionInfo(time, direction));
        }

        Deque<Point> dq = new ArrayDeque<>();
        dq.add(new Point(1, 1)); // head
        boolean[][] isBody = new boolean[mapSize + 1][mapSize + 1];
        isBody[1][1] = true;

        int count = 0;
        int nowDirection = 1; // 'R'
        while (true) {
            if (!q.isEmpty()) {
                DirectionInfo directionInfo = q.peek();
                if (directionInfo.time == count) {
                    q.remove();
                    nowDirection = directionTransform(nowDirection, directionInfo.direction);
                }
            }

            count++;

            Point head = dq.peekFirst();
            int newX = head.x + dx[nowDirection];
            int newY = head.y + dy[nowDirection];

            if (newX < 1 || newY < 1 || newX > mapSize || newY > mapSize || isBody[newX][newY]) {
                break;
            }

            dq.addFirst(new Point(newX, newY)); // new head
            isBody[newX][newY] = true;

            if (map[newX][newY] == 1) {
                map[newX][newY] = 0;
            } else {
                Point tail = dq.removeLast(); // tail 제거
                isBody[tail.x][tail.y] = false;
            }
        }

        System.out.println(count);
    }
}
