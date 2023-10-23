export function toArray(brackets) {
  return [...brackets];
}

export function checkOpenBracketCount(bracketsArray) {
  return bracketsArray.reduce((count, bracket) => {
    if (count < 0) {
      return -100000;
    }

    return bracket === '('
      ? count + 1
      : count - 1;
  }, 0);
}

export default function solution(brackets) {
  if (brackets.startsWith(')')) {
    return false;
  }

  const bracketsArray = toArray(brackets);

  const openBracketCount = checkOpenBracketCount(bracketsArray);

  return openBracketCount === 0;
}
