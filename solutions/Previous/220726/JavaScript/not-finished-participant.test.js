import solution from './not-finished-participant';

test('Test Cases', () => {
  expect(solution(['leo', 'kiki', 'eden'], ['eden', 'kiki'])).toBe('leo');

  expect(solution(
    ['marina', 'josipa', 'nikola', 'vinko', 'filipa'],
    ['josipa', 'filipa', 'marina', 'nikola'],
  )).toBe('vinko');

  expect(solution(
    ['mislav', 'stanko', 'mislav', 'ana'],
    ['stanko', 'ana', 'mislav'],
  )).toBe('mislav');
});
