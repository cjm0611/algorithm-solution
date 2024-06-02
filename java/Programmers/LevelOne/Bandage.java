package Programmers.LevelOne;

import java.util.*;

public class Bandage {

    static Queue<int[]> q = new LinkedList<>();
    static int hp = 0;
    static int MAX_HP = 0;
    // bandage - 시전 시간, 초당 회복량, 추가 회복량(시전 시간을 모두 채운 경우)
    // health - 최대 체력
    // attakcs - 공격 시간, 피해량

    /*
        while문으로 시간 ++
        공격을 Queue에 옮겨닮음.
        peek()을 이용해 공격이 있는지 확인
        1. 있다면 연속 = 0 초기화, 체력 감소 -> 체력이 0이하인지 확인후 return -1
        2. 없다면 체력회복++ (최대 체력 안 넘도록 주의) & 연속++
        만약 연속값이 최대값이라면, s = 0으로 초기화 후 추가 회복
    */
    public int solution(int[] bandage, int health, int[][] attacks) {
        hp = health;
        MAX_HP = health;
        for (int i = 0; i < attacks.length; i++) {
            int attackTime = attacks[i][0];
            int damage = attacks[i][1];
            q.add(new int[] {attackTime, damage});
        }

        int currentTime = 0;
        int successCount = 0;
        int maxSuccessCount = bandage[0];
        int recovery = bandage[1];
        int recoveryAfterBandage = bandage[2];
        while (!q.isEmpty()) {
            currentTime++;

            if (checkHasAttack(currentTime)) {
                int[] attack = q.poll();
                hp -= attack[1];
                successCount = 0;
                if (hp <= 0) return -1;
                continue;
            }

            addHealth(recovery);
            successCount++;
            if (successCount == maxSuccessCount) {
                addHealth(recoveryAfterBandage);
                successCount = 0;
            }
        }

        return hp;
    }

    boolean checkHasAttack(int currentTime) {
        if (q.isEmpty()) return false;

        int[] attack = q.peek();
        return attack[0] == currentTime;
    }

    void addHealth(int recovery) {
        hp += recovery;
        if (hp > MAX_HP) {
            hp = MAX_HP;
        }

    }
}
