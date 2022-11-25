import solution from './targetNumber';

test('solution', () => {
  const numbers = [4, 1, 2, 1];
  const target = 4;
  expect(solution(numbers, target)).toBe(2);
});
