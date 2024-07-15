package me.yoosup.codingtest.programmers.md0627;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class 개인정보수집유효기간 {
    /*
    1. 유의사항 모든달은 28일까지 있음
    2. today는 2022.05.19 string으로 입력받음
    3. term은 약관종류와 약관 유효기간을 개월수로 표현. A 6
    4. privacies는 가입한 날짜와 약관 종류를 받음
    5. result는 파기해야할 privacies 배열에서 idx+1 한 int배열로 준다.
     */
    public static void main(String[] args) {
        String today = "2022.05.19";
        String[] terms = {"A 6", "B 12", "C 3"};
        String[] privacies = {"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"};
        HashMap<String, Integer> termMap = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        int index = 1;

        for(String term : terms) {
            termMap.put(term.split(" ")[0], Integer.valueOf(term.split(" ")[1]));
        }


        // 기준을 privacies 배열의 요소를 split(" ")을 한 것의 앞의 값을 가져와서
        for (String privacy : privacies) {
            String date = privacy.split(" ")[0];
            String term = privacy.split(" ")[1];

            int dateYear = Integer.parseInt(date.split("\\.")[0]);
            int dateMonth = Integer.parseInt(date.split("\\.")[1]);
            int dateDay = Integer.parseInt(date.split("\\.")[2]);

            int todayYear = Integer.parseInt(today.split("\\.")[0]);
            int todayMonth = Integer.parseInt(today.split("\\.")[1]);
            int todayDay = Integer.parseInt(today.split("\\.")[2]);

            int diffY = todayYear - dateYear;
            int diffM = (diffY * 12) + todayMonth - dateMonth;
            int diffD = (diffM * 28) + todayDay - dateDay;

            int customerTermDate = termMap.get(term) * 28;

            if(diffD >= customerTermDate) {
                result.add(index);
            }
            index++;
        }
        System.out.println("result = " + result);

        // today와의 날짜의 차이를 구한다.
        /*
        년도를 먼저 비교함. 같으면 continue
        다르면 month 값에 12 추가
        month값은 today의 month값으로 계산하고 privacies의 monthh값을 뺀다.

        계산된 month값을 x28을 한후 today

         */

        // privacies배열 요소의 split(" ") 두번째 값을 비교해서 약관 값을 28 x 개월수로 큰지 작은지 구한다.


    }
}
