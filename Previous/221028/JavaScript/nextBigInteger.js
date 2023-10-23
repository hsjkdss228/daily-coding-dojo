export function count1(binaryNumber) {
  return binaryNumber.replaceAll('0', '').length;
}

export function findNextBigInteger({ oneCountOfOriginal, number }) {
  if (count1(number.toString(2)) === oneCountOfOriginal) {
    return number;
  }

  return findNextBigInteger({ oneCountOfOriginal, number: number + 1 });
}

export default function solution(number) {
  return findNextBigInteger({ oneCountOfOriginal: count1(number.toString(2)), number: number + 1 });
}
