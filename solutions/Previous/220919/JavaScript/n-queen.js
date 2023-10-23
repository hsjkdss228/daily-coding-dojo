function isPromising({ x, y, columns }) {
  for (let i = 0; i < x; i += 1) {
    if (columns[i] === y || Math.abs(x - i) === Math.abs(y - columns[i])) {
      return false;
    }
  }

  return true;
}

function depthFirstSearch({
  length, columns, row, answer,
}) {
  if (length === row) {
    answer += 1;
    return answer;
  }

  for (let i = 0; i < length; i += 1) {
    columns[row] = i;

    if (isPromising({ x: row, y: i, columns })) {
      answer = depthFirstSearch({
        length,
        columns,
        row: row + 1,
        answer,
      });
    }
  }

  return answer;
}

export default function solution(length) {
  let answer = 0;

  const columns = Array(length).fill(0);

  answer = depthFirstSearch({
    length,
    columns,
    row: 0,
    answer,
  });

  return answer;
}
