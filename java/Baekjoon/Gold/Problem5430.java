package Baekjoon.Gold;

import java.util.*;
import java.io.*;
import java.util.stream.*;

// AC - deque
public class Problem5430 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            String function = br.readLine();
            int n = Integer.parseInt(br.readLine());
            String str = br.readLine();

            Deque<Integer> dq = new ArrayDeque<>();
            if (n == 0) {
                if (function.contains("D")) {
                    System.out.println("error");
                } else {
                    System.out.println("[]");
                }
                continue;
            }

            String[] strList = str.substring(1, str.length() - 1).split(",");
            for (String num : strList) {
                dq.add(Integer.parseInt(num));
            }

            boolean isError = false; // D 때문에 오류가 생긴건지, 아님 그냥 빈 배열인지 판단하기 위함.
            boolean isReversed = false;
            for (int j = 0; j < function.length(); j++) {
                char action = function.charAt(j);
                if (action == 'R') {
                    if (j + 1 < function.length() && function.charAt(j + 1) == 'R') {
                        j++;
                    } else {
                        isReversed = !isReversed;
                    }
                } else {
                    if (dq.isEmpty()) {
                        isError = true;
                        break;
                    }
                    if (isReversed) {
                        dq.removeLast();
                    } else {
                        dq.removeFirst();
                    }
                }
            }

            if (dq.isEmpty()) {
                if (isError) {
                    System.out.println("error");
                    continue;
                }

                System.out.println("[]");
                continue;
            }

            List<Integer> resultList = new ArrayList<>(dq);
            if (isReversed) {
                Collections.reverse(resultList);
            }

            String result = resultList.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(",", "[", "]"));
            System.out.println(result);
        }
    }
}
