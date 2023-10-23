import solution, {
  filter,
  numberToArray, oddNumber,
} from './expressions';

test('numberToArray', () => {
  expect(numberToArray(15)).toStrictEqual([1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15]);
});

test('oddNumber', () => {
  expect(oddNumber([1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15]))
    .toStrictEqual([1, 3, 5, 7, 9, 11, 13, 15]);
});

test('filter', () => {
  expect(filter([1, 3, 5, 7, 9, 11, 13, 15], 15)).toBe(4);
});

test('solution', () => {
  expect(solution(15)).toBe(4);
});
