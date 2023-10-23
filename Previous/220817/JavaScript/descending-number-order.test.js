import {
  convertToString,
  convertToArray,
  sortInDescendingOrder,
  convertToNumber,
  solution,
} from './descending-order';

test('convertToString', () => {
  expect(convertToString(242535)).toBe('242535');
});

test('convertToArray', () => {
  expect(convertToArray('242535')).toStrictEqual([
    '2', '4', '2', '5', '3', '5',
  ]);
});

test('sortInDescendingOrder', () => {
  expect(sortInDescendingOrder([
    '2', '4', '2', '5', '3', '5',
  ])).toStrictEqual([
    '5', '5', '4', '3', '2', '2',
  ]);
});

test('convertToNumber', () => {
  expect(convertToNumber([
    '5', '5', '4', '3', '2', '2',
  ])).toBe(554322);
});

test('solution', () => {
  expect(solution(242535)).toBe(554322);
});
