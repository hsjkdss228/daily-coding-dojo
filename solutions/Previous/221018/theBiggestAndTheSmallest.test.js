import solution, {
  convertToArray, findTheBiggestNumber, findTheSmallestNumber, concatenate,
} from './theBiggestAndTheSmallest';

test('문자열을 숫자 배열로 만들기', () => {
  expect(convertToArray('-1 -2 -3 -4')).toStrictEqual([-1, -2, -3, -4]);
});

test('숫자 배열에서 최대값 추출', () => {
  expect(findTheBiggestNumber([-1, -2, -3, -4])).toBe(-1);
});

test('숫자 배열에서 최대값 추출 (같은 수인 경우)', () => {
  expect(findTheBiggestNumber([-1, -1, -1])).toBe(-1);
});

test('숫자 배열에서 최소값 추출', () => {
  expect(findTheSmallestNumber([-1, -2, -3, -4])).toBe(-4);
});

test('숫자 배열에서 최소값 추출 (같은 수인 경우)', () => {
  expect(findTheSmallestNumber([-1, -1, -1])).toBe(-1);
});

test('최대값과 최소값을 이어붙여서 문자열로 변환', () => {
  expect(concatenate(-1, -4)).toBe('-4 -1');
});

test('solution', () => {
  expect(solution('1 2 3 4')).toBe('1 4');
  expect(solution('-1 -2 -3 -4')).toBe('-4 -1');
  expect(solution('1 1 1 1')).toBe('1 1');
});
