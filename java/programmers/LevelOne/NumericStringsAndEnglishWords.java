package programmers.LevelOne;

// 숫자 문자열과 영단어
public class NumericStringsAndEnglishWords
{
//    // 첫 제출
//    public int solution(String s) {
//        String answer = s;
//        answer = answer.replaceAll("zero", "0");
//        answer = answer.replaceAll("one", "1");
//        answer = answer.replaceAll("two", "2");
//        answer = answer.replaceAll("three", "3");
//        answer = answer.replaceAll("four", "4");
//        answer = answer.replaceAll("five", "5");
//        answer = answer.replaceAll("six", "6");
//        answer = answer.replaceAll("seven", "7");
//        answer = answer.replaceAll("eight", "8");
//        answer = answer.replaceAll("nine", "9");
//        return Integer.parseInt(answer);
//    }


    // 리팩터링 후
    public int solution(String s) {
        String[] words = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

        for (int i = 0; i <= 9; i++) {
            s = s.replaceAll(words[i], String.valueOf(i));
        }
        return Integer.parseInt(s);
    }
}
