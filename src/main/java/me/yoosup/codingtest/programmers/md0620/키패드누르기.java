package me.yoosup.codingtest.programmers.md0620;

/*
    왼손은  *에서 시작 1, 4, 7
    오른손은 #에서 시작 3, 6, 9
    2,5 , 8, 0은 두손 중 가까운 손이 누름
    두손의 거리가 같다면 오른손잡이는 오른손 엄지, 왼손잡이는 왼손 엄지를 사용
    */

// 왼손배열 1, 4, 7
// 오른손 배열 3, 6, 9
// 현재 왼손 오른손 위치 배열 new int[2]

import java.util.stream.IntStream;

/*
1 이나 3일 때
2로 가면 이동 1,
5로가면 이동 2,
8로가면 이동 3

1이나 3일때 3씩 더해서 도착 숫자 비교
작으면 1더해서 도착 숫자면 3을 n번 더한만큼 +1이나 -1을 했을경우 -> n + 1
새로로 움직을때는 -> n = a + 3 해서 목표숫자 m 과 비교후 크면 -1, 작으면 +1

{1, 4, 7}의 값이 들어오면 현위치 배열 1번째 자리를 1, 4, 7로 바꿈
{3, 6, 9}의 값이 들어오면 현위치 배열 2번째 자리를 3, 6, 9로 바꿈
{2, 5, 8, 0}의 값이 들어오면 현위치 배열 1번째 자리와 2번째자리에 요구 이동거리를 계산한후
둘이 같으면 왼손잡이인지 오른손잡이인지 확인 후 그 손으로 자리옮기고 현위치 배열에 적용

// 경우 1
147 이나 369가 들어오는 경우 -> 분류해서 L이나 R 넣으면 됨

// 경우 2
2580이 들어오는 경우
현재 손위치 배열에서 가장 가까운 거리를 계산한후 거리가 작은 손을 입력

그렇다면 거리를 계산하는 방법
2580을 현재위치에서 뺀값의 절대값을 3으로 나누고 그값을 Math.ceil() 한다.
누른손은 누른 번호로 이동한다.

-> 경우 1 :: 현재위치가 같은 경우 -> hand를 보고 그손으로 누름
예) 현위치 1, 이동 2 -> 2 -1 / 3 + 1 = 1 (필요이동거리)
    현위치 9, 이동 2 -> 9 - 2 / 3 + 1 = 3

*/
public class 키패드누르기 {
    // 현재위치 배열 now -> now[0]이 왼손, now[1]이 오른손
    static int[] now = {10, 12};

    // 계산 후 배열을 업데이트하고 L인지 R인지 확인하는 메서드
    static String calcMove(int[] now, int goal, boolean isLeft) {
        //now[0]을 왼손으로 저장하고 (leftmove함수사용)
        int req_L = leftMove(now[0], goal);
        //now[1]을 오른손으로 저장하고 (move함수 사용)
        // ********************************** 오른손일때 작동을안함
        int req_R = rightMove(now[1], goal);

        // 왼쪽move가 오른쪽move보다 작다면
        if(req_L < req_R) {
            // L리턴, now[0] 업데이트
            now[0] = goal;
            return "L";
        // 오른쪽move가 왼쪽 move보다 작다면
        } else if (req_R < req_L) {
            // R리턴, now[1] 업데이트
            now[1] = goal;
            return "R";
        // 둘이같다면
        } else {
        // isleft확인후 true면 L 리턴 후 now[0] 업데이트
            if(isLeft) {
                now[0] = req_L;
                return "L";
            // false면 R 리턴 후 now[1] 업데이트
            } else {
                now[1] = req_R;
                return "R";
            }
        }
    }

    public static int leftMove(int start, int end) {
        // end가 0면 11로 간주
        int s = start == 0 ? 11 : start;
        int e = end == 0 ? 11 : end;
        int count = 0;

        while(s != e) {
            if(s < e) {
                if(e - s <= 2) {
                    count += e - s;
                    return count;
                } else {
                    s += 3;
                    count++;
                }
            } else {
                s -= 3;
                count++;
            }
        }
        return count;
    }

    public static int rightMove(int start, int end) {
        // end가 0면 11로 간주
        int s = start == 0 ? 11 : start;
        int e = end == 0 ? 11 : end;
        int count = 0;

        while(s != e) {
            if(s > e) {
                if(s - e <= 2) {
                    count += s - e;
                    return count;
                } else {
                    s -= 3;
                    count++;
                }
            } else {
                s += 3;
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        // 키패드 누름 배열
        int[] numpad = {7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2};

        String hand = "left";
        // 왼손잡이 오른손 잡이
        boolean isLeft = hand.equals("left");

        // 리턴 스트링
        StringBuffer sb = new StringBuffer();

        // numpad 의 값을 돌면서
        for(int num : numpad) {
            // 만약 1, 4, 7이면 now[0] 업데이트 후 L반환 -> sb.append
            if (num == 1 ||
            num == 4 ||
            num == 7) {
                now[0] = num;
                sb.append("L");
            }
            // 만약 3, 6, 9이면 now[1] 업데이트 후 R반환 -> sb.append
            else if (num == 3 ||
            num == 6 ||
            num == 9) {
                now[1] = num;
                sb.append("R");
            }
            // 만약 2, 5, 8, 0이면 calcMove() 적용후 L이나 R반환 -> sb.append
            else {
                String LorR = calcMove(now, num, isLeft);
                sb.append(LorR);
            }
        }
        // 완성된 sb 스트링으로 리턴
        String answer = sb.toString();
        System.out.println("answer = " + answer);
    }
}
