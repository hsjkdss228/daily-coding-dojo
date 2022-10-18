export function convertToArray(numbers) {
  return numbers.split(' ').map((number) => Number(number));
}

export function findTheBiggestNumber(numbers) {
  return numbers.reduce((previous, current) => (
    previous >= current
      ? previous
      : current
  ), Number.MIN_SAFE_INTEGER);
}

export function findTheSmallestNumber(numbers) {
  return numbers.reduce((previous, current) => (
    previous <= current
      ? previous
      : current
  ), Number.MAX_SAFE_INTEGER);
}

export function concatenate(biggest, smallest) {
  return `${smallest} ${biggest}`;
}

export default function solution(numbers) {
  const convertedNumbers = convertToArray(numbers);

  const biggest = findTheBiggestNumber(convertedNumbers);
  const smallest = findTheSmallestNumber(convertedNumbers);

  return concatenate(biggest, smallest);
}
