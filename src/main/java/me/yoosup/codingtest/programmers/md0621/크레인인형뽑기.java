package me.yoosup.codingtest.programmers.md0621;

/**
 * 주어지는것 :: board[][], moves[]
 * board[][]는 위에서부터 상자에 담겨있는 인형을 나타낸다.
 * moves[]는 세로 축을 나타낸다.
 *
 * 문제는 2가지
 * 1. 보드에서 숫자를 뽑아내기
 *  -> 비어있는 경우 0으로 표시되기 때문에,
 *  -> for문으로 가로축을 하나씩 세면서, 세로축은 moves[]에서 뽑아와서 고정시키고,
 *  -> 0이 아니면 숫자를 뽑아온 후 0으로 만든다.
 *
 * 2. 뽑아낸 숫자를 stack에 저장한 후 위아래 숫자가 같으면 삭제.
 *  -> 이 과정은 하나가 삭제됐을때 연속적으로 진행될 수 있다.
 *  -> while문으로 겹쳐진 숫자가 있는지 확인하고 없으면 다시 보드에서 숫자를 뽑아낸다.
 */
public class 크레인인형뽑기 {
}
