export function convertToBinary(number) {
  return number.toString(2);
}

export function findTheBiggestBinaryOfEqualLength(number) {
  const binaryNumber = convertToBinary(number);
  // const theBiggestBinaryOfEqualLength = [...binaryNumber, '0']
  //   .map(() => '1')
  // .join('');
  const theBiggestBinaryOfEqualLength = [...binaryNumber, '0']
    .fill('1')
    .join('');
  return parseInt(theBiggestBinaryOfEqualLength, 2);
}

export function count1(binaryNumber) {
  return binaryNumber.replaceAll('0', '').length;
}

export function findNextBigInteger({ binaryNumber, numbers }) {
  const originalNumber1Count = count1(binaryNumber);

  return numbers.reduce((nextBigInteger, number, index, array) => {
    if (originalNumber1Count === count1(convertToBinary(number))) {
      array.splice(index);
      return number;
    }
    return nextBigInteger;
  }, numbers[0] - 1);
}

export function range({ start, end }) {
  return Array(end - start).fill(start + 1)
    .map((value, index) => value + index);
}

export default function solution(number) {
  const binaryNumber = convertToBinary(number);

  const theBiggestBinaryOfEqualLength = findTheBiggestBinaryOfEqualLength(number);

  const arrayOfNumbers = range({ start: number, end: theBiggestBinaryOfEqualLength });

  return findNextBigInteger({ binaryNumber, numbers: arrayOfNumbers });
}
