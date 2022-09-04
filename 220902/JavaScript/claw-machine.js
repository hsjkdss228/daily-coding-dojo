// 문제 해결 과정
// 1. Java에서는 for문에서 배열을 종으로 참조하기 위해 인덱스 변수값을 계속해서 바꿔가며 사용했다.
//    JavaScript에서는 선언형 방식을 사용하기 위해 foreach를 이용해 배열을 횡으로 참조할 수 있도록
//    배열의 횡방향과 종방향을 바꾼다.
//
// 2. 이제 아래 과정을 moves의 모든 숫자들에 대해 순차적으로 수행한다.
//   2-1. moves에서 숫자를 하나 가져온다. 그 숫자는 board에서 살펴볼 행(row)
//   2-2. 행의 값을 순차적으로 하나씩 꺼내보는데 0이 아닌 숫자가 나오면
//      그 숫자를 뽑은 인형 List에 넣고, 찾은 위치에는 찾은 숫자 대신 0을 재할당
//   2-3. 뽑은 인형 List에서 방금 List에 넣은 숫자랑 앞 숫자가 같은지 검사한다. ([size - 2] ?== [size - 1])
//      같다? 방금 List에 넣은 숫자랑 앞 숫자를 제거하고, 제거한 인형 숫자 변수에 +2
//
// 3. 제거한 인형 숫자 변수를 반환한다.

// reduce 메서드 활용법 reference
// https://www.zerocho.com/category/JavaScript/post/5acafb05f24445001b8d796d
// https://velog.io/@dyongdi/JS-2%EC%B0%A8%EC%9B%90-%EB%B0%B0%EC%97%B4%EC%9D%98-%ED%96%89%EA%B3%BC-%EC%97%B4-%EB%B0%94%EA%BE%B8%EA%B8%B0-Transposing-a-2D-array-in-JavaScript

export function transpose(board) {
  return board.reduce((newBoard, row) => (
    row.map((_, index) => (
      [
        ...(newBoard[index] || []), row[index],
      ]
    ))
  ), []);
}

export function pick(boardTransposed, pickedThings, row) {
  const pickedThing = boardTransposed[row - 1].find((element) => element > 0);

  if (pickedThing === undefined) {
    return;
  }

  pickedThings.push(pickedThing);

  const indexOfPickedThing = boardTransposed[row - 1].findIndex((element) => element > 0);
  boardTransposed[row - 1][indexOfPickedThing] = 0;
}

export function checkPickedThings(pickedThings) {
  if (pickedThings.length > 1
    && pickedThings[pickedThings.length - 1] === pickedThings[pickedThings.length - 2]) {
    pickedThings.pop();
    pickedThings.pop();

    return 2;
  }

  return 0;
}

export function solution(board, moves) {
  const boardTransposed = transpose(board);

  const pickedThings = [];

  const removedCount = {
    count: 0,
  };

  moves.forEach((row) => {
    pick(boardTransposed, pickedThings, row);

    removedCount.count += checkPickedThings(pickedThings);
  });

  return removedCount.count;
}
