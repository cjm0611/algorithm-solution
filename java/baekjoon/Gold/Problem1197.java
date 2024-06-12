package baekjoon.Gold;

import java.util.*;

class Problem1197 {
    static int[] parent;
    static class Edge implements Comparable<Edge> {
        int s, e, cost;

        public Edge(int s, int e, int cost) {
            this.s = s;
            this.e = e;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge other) {
            return Integer.compare(this.cost, other.cost);
            // this > other이면 1을 반환 => 순서 바뀜.
        }
    }

    static int find(int v) {
        if (parent[v] == v) {
            return v;
        }

        return parent[v] = find(parent[v]); // 경로 압축
    }

    static void union(int x, int y) {
        parent[find(x)] = find(y);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int vNum = sc.nextInt();
        int eNum = sc.nextInt();
        List<Edge> edges = new ArrayList<>();
        for (int i = 0; i < eNum; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            int cost = sc.nextInt();
            edges.add(new Edge(s, e, cost));
        }

        // 각 정점의 parent 자기 자신으로 설정
        parent = new int[vNum + 1];
        for (int i = 1 ; i <= vNum; i++) {
            parent[i] = i;
        }

        // 간선 cost 낮은 순으로 정렬
        Collections.sort(edges);
        int answer = 0;

        for (Edge edge : edges) {
            boolean IS_SAME_PARENT = find(edge.s) == find(edge.e);
            if (IS_SAME_PARENT) {
                continue;
            }

            union(edge.s, edge.e);
            answer += edge.cost;
        }

        System.out.println(answer);
    }
}
