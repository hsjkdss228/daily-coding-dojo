export function makeSubmultiples(yellowCount) {
  const descendings = Array(yellowCount).fill(0)
    .map((_, index, array) => (
      array.length - index
    ));

  return descendings.filter((value) => yellowCount % value === 0);
}

export function compareToBrownCount({ combination, brownCount }) {
  return ((combination[0] * 2) + (combination[1] * 2)) + 4 === brownCount;
}

export function process({ submultiples, brownCount }) {
  return submultiples.reduce((answer, leftSubmultiple, index, array) => {
    const rightSubmultiple = array[array.length - index - 1];
    if (leftSubmultiple < rightSubmultiple) {
      return answer;
    }

    const combination = [leftSubmultiple, rightSubmultiple];
    if (compareToBrownCount({ combination, brownCount })) {
      return [leftSubmultiple + 2, rightSubmultiple + 2];
    }

    return answer;
  }, [0, 0]);
}

export default function solution(brownCount, yellowCount) {
  const submultiples = makeSubmultiples(yellowCount);

  return process({ submultiples, brownCount });
}
