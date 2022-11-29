export default function solution(array1, array2) {
  const answer = Array(array1.length).fill([]);

  return answer.map((_, rowIndex) => {
    const row = Array(array2[0].length).fill([]);

    return row.map((_, columnIndex) => (
      array1[rowIndex].reduce((accumulator, rowValue, k) => (
        accumulator + (rowValue * array2[k][columnIndex])
      ), 0)
    ));
  });
}
