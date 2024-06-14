package me.yoosup.codingtest.programmers.md0613;

import java.util.Arrays;

public class 완주하지못한선수 {
    class Solution {
        /*
        정렬후 for문 i를 인덱스로 비교

        */
        public String solution(String[] participant, String[] completion) {
            String answer = "";

            Arrays.sort(participant);
            Arrays.sort(completion);
            int idx = 0;

            if(participant.length == 1) {
                return participant[0];
            }

            while(participant[idx].equals(completion[idx])){
                if(idx == completion.length-1) {
                    return participant[idx+1];
                }
                idx++;
            }
            return participant[idx];
        }
    }
}
