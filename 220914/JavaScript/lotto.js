export function countRightNumbers(myNumbers, winNumbers) {
  return myNumbers.reduce((accumulator, number) => (
    winNumbers.includes(number)
      ? accumulator + 1
      : accumulator
  ), 0);
}

export function countZeroNumbers(myNumbers) {
  return myNumbers.reduce((accumulator, number) => (
    number === 0
      ? accumulator + 1
      : accumulator
  ), 0);
}

export function rank(rightNumbersCount, zeroCount) {
  const theLowestRanking = rightNumbersCount === 0
    ? 6
    : 7 - rightNumbersCount;

  const theHighestRanking = rightNumbersCount === 0 && zeroCount === 6
    ? 1
    : theLowestRanking - zeroCount;

  return [theHighestRanking, theLowestRanking];
}

export function solution(myNumbers, winNumbers) {
  const rightNumbersCount = countRightNumbers(myNumbers, winNumbers);

  const zeroCount = countZeroNumbers(myNumbers);

  return rank(rightNumbersCount, zeroCount);
}
