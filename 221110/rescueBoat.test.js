import solution from './rescueBoat';

test('solution case 1', () => {
  const weights = [70, 50, 80, 50];
  const limit = 100;
  expect(solution(weights, limit)).toBe(3);
});

test('solution case 2', () => {
  const weights = [70, 50, 80];
  const limit = 100;
  expect(solution(weights, limit)).toBe(3);
});
