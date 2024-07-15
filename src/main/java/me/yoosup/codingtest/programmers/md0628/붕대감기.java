package me.yoosup.codingtest.programmers.md0628;

import java.util.Arrays;

public class 붕대감기 {
    /*
    1. 붕대감기는 t초동안 붕대를 감으면서 1초마다 x만큼의 체력을 회복함
    2. t초 연속으로 붕대를 감는데 성공한다면 y만큼의 체력을 추가로 회복
    3. 최대체력이 존재해서 현재 체력이 최대 체력보다 커질 수 없음
    4. 공격당하면 기술이 취소됨. 붕대감기를 즉시 다시 시전하며 연속 성공 시간이 0으로 초기화됨
    5. 몬스터의 공격을 받으면 피해량만큼 현재체력이 줄어든다. 0 이하가 되면 캐릭터가 죽으며 더이상 회복불가
    6. 생존할 수 있는지 없는지 알아보자.
    7. int[] bandage는 기술 시전 시간, 1초당 회복량, 추가 회복량
    8. 최대체력 health
    9. int[][] attacks는 몬스터 공격시간과 피해량을 담음
    10. 체력이 0이하가 되면 -1
     */
    public static void main(String[] args) {
        int answer = 0;
        int[] bandage = {1, 1, 1};
        int currentHealth = 5;
        final int MAX_HEALTH = 5;

        int[][] attacks = {{1, 2},{3, 2}};

        // 제한 시간은 attack 배열의 맨 마지막 첫번째 요소
        int duration = attacks[attacks.length - 1][0];

        // while문으로 돌려서 sec이 duration이 될때까지
        int sec = 0;
        // 붕대감기 연속 시전 시간
        int cont = 0;

        // (완) 매 루프마다 sec은 1씩 증가한다
        // (완) 매 루프마다 cont는 1씩 증가한다.
        while (sec <= duration) {
            // sec을 확인해서 attacks의 첫번째 값과 같으면
            if(sec == attacks[0][0]) {
                // 연속 시전 시간 초기화 :: cont
                cont = 0;
                // 체력을 데미지 만큼 깎는다.
                currentHealth -= attacks[0][1];
                // 만약 health가 0보다 작아지면
                // answer = -1 로 바꿔서 출력
                if (currentHealth <= 0) {
                    answer = -1;
                    break;
                };

                // attacks 업데이트
                attacks = Arrays.copyOfRange(attacks, 1, attacks.length);

                // 만약 몬스터에 공격 받지 않는다면
            } else {
                // bandage[1]의 값만큼 최대 체력에 더한다.
                currentHealth += bandage[1];
                // 만약 연속시전시간 cont가 bandage[0]와 같다면
                if (cont == bandage[0]) {
                    // health에 bandage[2]만큼 더한다.
                    currentHealth += bandage[2];
                    // 연속시전시간 0으로 초기화
                    cont = -1;
                }
                // 만약 최대체력보다 높다면 health값을 MAX_HEALTH로 바꿈
                if(currentHealth > MAX_HEALTH) {
                    currentHealth = MAX_HEALTH;
                }
                cont++;
            }
            sec++;
        }
        answer = answer == - 1 ? -1 : currentHealth;
        System.out.println("answer = " + answer);
    }
}
