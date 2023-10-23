// 문제 URL: https://school.programmers.co.kr/learn/courses/30/lessons/12933?language=javascript

function convertToString(number) {
  return String(number);
}

function convertToArray(numberString) {
  const digits = [];

  for (let i = 0; i < numberString.length; i += 1) {
    digits[i] = numberString.charAt(i);
  }

  return digits;
}

function sortInDescendingOrder(digits) {
  return digits.sort((a, b) => b - a);
}

function convertToNumber(digits) {
  return parseInt(digits.join(''), 10);
}

function solution(number) {
  const numberString = convertToString(number);

  let digits = convertToArray(numberString);

  digits = sortInDescendingOrder(digits);

  const answer = convertToNumber(digits);

  return answer;
}

// 숫자.toString()이 왜 작동하지 않는지 모르겠다.
// String(숫자)로 해결.
