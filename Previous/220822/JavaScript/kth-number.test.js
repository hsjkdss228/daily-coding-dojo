import solution from './kth-number';

test('Test cases', () => {
  const array = [1, 5, 2, 6, 3, 7, 4];
  const commands = [[2, 5, 3], [4, 4, 1], [1, 7, 3]];

  expect(solution(array, commands)).toStrictEqual([5, 6, 3]);
});
