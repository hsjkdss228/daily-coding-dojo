import solution from './findKim';

test('solution', () => {
  const seoul = ['Jane', 'Ronaldo', 'Kim', 'Park', 'Judge'];

  expect(solution(seoul)).toBe('김서방은 2에 있다');
});
