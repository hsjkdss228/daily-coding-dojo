// 문제 URL: https://school.programmers.co.kr/learn/courses/30/lessons/12931?language=javascript

export default function solution(number) {
  const digits = [];

  let dividend = number;

  while (dividend >= 1) {
    const digit = dividend % 10;

    digits.push(digit);

    dividend = parseInt(dividend / 10, 10);
  }

  let sum = 0;

  digits.forEach((digit) => { sum += digit; });

  return sum;
}
