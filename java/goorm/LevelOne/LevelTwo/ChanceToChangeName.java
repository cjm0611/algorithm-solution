package goorm.LevelOne.LevelTwo;

import java.io.*;

/*
걸린 시간: 30m
개명 찬스
설계: 문자열 앞에서부터 for문으로 돌면서, 다음 Index와 compareTo를 한다.
그 값이 음수거나 0이면 패스하고, 처음으로 양수가 되는 값을 뺀다.
 */
public class ChanceToChangeName {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        char[] arr = input.toCharArray();

        int deleteIdx = -1;
        for (int i = 0; i < arr.length; i++) {
            if (i == arr.length - 1) break;
            if (arr[i] > arr[i + 1]) {
                deleteIdx = i;
                break;
            }
        }

        if (deleteIdx != -1) {
            StringBuilder answer = new StringBuilder(input);
            answer.deleteCharAt(deleteIdx);
            // answer.append(arr, 0, deleteIdx);
            // answer.append(arr, deleteIdx + 1, arr.length - deleteIdx - 1);
            System.out.println(answer);
        } else {
            StringBuilder answer = new StringBuilder();
            answer.deleteCharAt(deleteIdx);
            // answer.append(arr, 0, arr.length - 1);
            System.out.println(answer);
        }
    }
}
