// 현재 미완성 상태
//
// 문제 해결 과정
// 1. Java에서는 for문에서 배열을 종으로 참조하기 위해 인덱스 변수값을 계속해서 바꿔가며 사용했다.
//    JavaScript에서는 선언형 방식을 사용하기 위해 foreach를 이용해 배열을 횡으로 참조할 수 있도록
//
// (아래 내용은 일단 Java 풀이에서 그대로 가져왔으나 구조는 거의 그대로 가되 선언형 풀이 방식에 맞게 조금씩 바뀔 예정)
// 2. 이제 아래 과정을 moves의 모든 숫자들에 대해 순차적으로 수행한다.
//   2-1. moves에서 숫자를 하나 가져온다.
//   2-2. board 배열을 횡으로 돌면서 0이 아닌 숫자를 찾으면  (숫자 - 1인 이유: 인덱스니까!)
//      그 숫자를 다른 List에 넣고 board에서 찾은 위치에는 그 숫자 대신 0을 재할당
//   2-3. List에서 앞엣놈랑 방금 List에 넣은 놈이랑 같은지 검사한다. ([size - 2] ?= [size - 1])
//      같다? 방금 List에 넣은 놈이랑 앞엣놈을 제거하고, 제거한 인형 숫자 변수에 + 2
// 제거한 인형 숫자 변수를 반환한다.

// reduce 메서드 활용법 reference
// https://www.zerocho.com/category/JavaScript/post/5acafb05f24445001b8d796d
// https://velog.io/@dyongdi/JS-2%EC%B0%A8%EC%9B%90-%EB%B0%B0%EC%97%B4%EC%9D%98-%ED%96%89%EA%B3%BC-%EC%97%B4-%EB%B0%94%EA%BE%B8%EA%B8%B0-Transposing-a-2D-array-in-JavaScript

export default function transpose(board) {
  return board.reduce((newBoard, row) => (
    row.map((_, index) => (
      [
        ...(newBoard[index] || []), row[index],
      ]
    ))
  ), []);
}

function solution(board, moves) {
  const boardTransposed = transpose(board);

  const removedCount = {
    count: 0,
  };

  moves.foreach((column) => {
    console.log(column);
  });

  return removedCount.count;
}
