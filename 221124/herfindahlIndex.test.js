import solution from './herfindahlIndex';

test('solution case 1', () => {
  expect(solution([102, 2, 2, 2, 101])).toBe(2);
});

test('solution case 2', () => {
  expect(solution([0, 0, 0, 0, 0])).toBe(0);
});
