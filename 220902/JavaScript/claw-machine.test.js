import transpose from './claw-machine';

test('transpose', () => {
  const array = [
    [1, 2, 3, 999],
    [4, 5, 6, 7],
    [8, 9, 10, 11],
    [12, 13, 14, 15],
  ];

  const arrayExpect = [
    [1, 4, 8, 12],
    [2, 5, 9, 13],
    [3, 6, 10, 14],
    [999, 7, 11, 15],
  ];

  expect(transpose(array)).toStrictEqual(arrayExpect);
});
