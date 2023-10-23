import solution, { greatestCommonDenominator, leastCommonMultiple } from './theLeastCommonMultiple';

test('최대공약수 계산', () => {
  expect(greatestCommonDenominator(12, 8)).toBe(4);
  expect(greatestCommonDenominator(2, 6)).toBe(2);
  expect(greatestCommonDenominator(8, 14)).toBe(2);
});

test('최소공배수 계산', () => {
  expect(leastCommonMultiple(12, 8)).toBe(24);
  expect(leastCommonMultiple(2, 6)).toBe(6);
  expect(leastCommonMultiple(8, 14)).toBe(56);
});

test('solution', () => {
  expect(solution([2, 6, 8, 14])).toBe(168);
  expect(solution([1, 2, 3])).toBe(6);
});
