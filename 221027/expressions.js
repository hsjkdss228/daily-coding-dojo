export function numberToArray(number) {
  return Array(number).fill().map((value, index) => index + 1);
}

export function oddNumber(numbers) {
  return numbers.filter((number) => number % 2);
}

export function filter(oddNumbers, initialNumber) {
  return oddNumbers.filter((number) => !(initialNumber % (number))).length;
}

export default function solution(n) {
  const numbers = numberToArray(n);

  const oddNumbers = oddNumber(numbers);

  return filter(oddNumbers, n);
}
