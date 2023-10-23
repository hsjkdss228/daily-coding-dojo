export default function solution(givenNumber) {
  let dividend = givenNumber;

  const array = [];

  let index = 0;
  while (dividend > 0) {
    array[index] = dividend % 10;
    index += 1;
    dividend = parseInt(dividend / 10, 10);
  }

  return array;
}
