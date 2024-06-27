package me.yoosup.codingtest.programmers.md0626;

import java.lang.reflect.Array;
import java.util.Arrays;

public class 실패율 {
    /*
    스테이지에 도달한 사람, 클리어하지 못한 사람/ 스테이지에 도달한 사람

    전체 스테이지는 N
    stages배열의 요소는 한 사람이 머무르고 있는 스테이지 == 도달했지만 클리어하지 못한사람
    stages배열의 길이는 전체 사람수
    스테이지에 도달한 유저가 없는 경우 실패율은 0

    전체 사람수는 매번 업데이트 되는 challenger라고하면,

    첫번째 안 ::
    순서는 중요하지 않으므로 정렬한 후,

    int[] 을 확인하여 도전하는 사람들 수 c 확인하고
    첫번째 요소를 확인하고 (도전하는 스테이지 확인용) ->stageNow
    건너뛰는 요소가 있다면 실패율 0을 적용한다.
    같은 요소의 갯수 dp를 센 다음
    challenger int[]을 매번 substring을 통해 새롭게 업데이트하고

    중간배열 int[] mid는
    index가 현재 스테이지 == stageNow로 적용하고
    실패율은 위에서 계산한걸로 넣는다. faliRate

    끝배열 int[] result는
    int[] calc에서 실패율이 가장 높은 값의 index + 1을 해서 맨앞부터 채워넣는다.
     */

    // FailRate 배열을 만드는 메서드
    public static int[] createFailRateArr(int stageNum, int[] stages) {
        int countStage = 1;
        double failRate;
        int[] failRateArr = new int[stageNum];
        int[] updatedStage = stages.clone();

        Arrays.sort(updatedStage);
        // 실패율을 계산하는 메서드 보완점 :: countStage는 계속 늘어나야한다.
        failRate = calculateFailRate(updatedStage, countStage);

        // 업데이트 배열을 만드는 메서드 :: stageNum이 계속 업데이트 되어야한다.
        updateStageArr(failRateArr, countStage - 1);


        return failRateArr;
    }



    // (테스트 완) 실패율을 계산하는 메서드
    public static double calculateFailRate(int[] updatedStage, int stageNum) {
        if(updatedStage[0] != stageNum) {
            return 0;
        }
        // 실패율의 분모
        int stageTrier = updatedStage.length;
        int idx = 0;
        int failTrier = 0;
        // 스테이지에 도달했지만 못깬사람을 센다. 실패율의 분자
        while (stageNum == updatedStage[idx]) {
            failTrier++;
            idx++;
        }

        return (double) failTrier / stageTrier;
    }

    // (테스트 완) 업데이트 배열을 만드는 메서드
    public static int[] updateStageArr(int[] updatedStage, int stageNum) {
        int idx = 0;
        for(int u : updatedStage) {
            if(stageNum == u) {
                idx++;
            } else break;
        }

        return Arrays.copyOfRange(updatedStage, idx, updatedStage.length);
    }


    public static void main(String[] args) {
        int N = 5;
        int[] stages = {2, 1, 2, 6, 2, 4, 3, 3};
        int[] mid;

        Arrays.sort(stages);
        System.out.println("calculateFailRate(stages, 1) = " + calculateFailRate(stages, 1));
        System.out.println(Arrays.toString(updateStageArr(stages, 1)));
    }
}
