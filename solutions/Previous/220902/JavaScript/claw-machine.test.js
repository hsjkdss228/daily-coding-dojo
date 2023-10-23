import {
  transpose, checkPickedThings, pick, solution,
} from './claw-machine';

test('Transpose', () => {
  const array = [
    [0, 0, 0, 0, 0],
    [0, 0, 1, 0, 3],
    [0, 2, 5, 0, 1],
    [4, 2, 4, 4, 2],
    [3, 5, 1, 3, 1],
  ];

  const arrayExpect = [
    [0, 0, 0, 4, 3],
    [0, 0, 2, 2, 5],
    [0, 1, 5, 4, 1],
    [0, 0, 0, 4, 3],
    [0, 3, 1, 2, 1],
  ];

  expect(transpose(array)).toStrictEqual(arrayExpect);
});

test('pick', () => {
  const board = [
    [0, 0, 0, 4, 3],
    [0, 0, 2, 2, 5],
    [0, 1, 5, 4, 1],
    [0, 0, 0, 4, 3],
    [0, 3, 1, 2, 1],
  ];

  const pickedThings = [1, 2, 3];

  const row = 3;

  pick(board, pickedThings, row);

  expect(pickedThings.length).toBe(4);
  expect(pickedThings.pop()).toBe(1);
});

test('Check picked things when being deleted', () => {
  const pickedThings = [1, 3, 4, 2, 3, 3];

  const removedCount = {
    count: 0,
  };

  removedCount.count += checkPickedThings(pickedThings);

  expect(removedCount.count).toBe(2);
});

test('Check picked things when not being deleted', () => {
  const pickedThings = [1, 3, 4, 2, 3, 2];

  const removedCount = {
    count: 0,
  };

  removedCount.count += checkPickedThings(pickedThings);

  expect(removedCount.count).toBe(0);
});

test('Solution', () => {
  const board = [
    [0, 0, 0, 0, 0],
    [0, 0, 1, 0, 3],
    [0, 2, 5, 0, 1],
    [4, 2, 4, 4, 2],
    [3, 5, 1, 3, 1],
  ];

  const moves = [1, 5, 3, 5, 1, 2, 1, 4];

  expect(solution(board, moves)).toBe(4);
});
