export function greatestCommonDenominator(a, b) {
  const smaller = a >= b ? b : a;
  const commonDenominators = [];
  Array(smaller).fill(0).forEach((_, index) => {
    const denominator = index + 1;
    if (a % denominator === 0 && b % denominator === 0) {
      commonDenominators.push(denominator);
    }
  });
  return commonDenominators[commonDenominators.length - 1];
}

export function leastCommonMultiple(a, b) {
  return (a * b) / greatestCommonDenominator(a, b);
}

export default function solution(numbers) {
  return numbers.reduce((a, b) => leastCommonMultiple(a, b));
}
