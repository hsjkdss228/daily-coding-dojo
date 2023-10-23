import solution, {
  convertToBinary, findTheBiggestBinaryOfEqualLength, range, count1, findNextBigInteger,
} from './nextBigIntegerFailed';

test('숫자를 2진수로 변환', () => {
  expect(convertToBinary(78)).toBe('1001110');
});

test('자연수 n과 2진수 길이가 1 길은 가장 큰 수를 정의', () => {
  expect(findTheBiggestBinaryOfEqualLength(78)).toBe(255);
});

test('자연수 n부터 큰 수까지 사이의 배열을 정의', () => {
  expect(range({ start: 5, end: 7 })).toStrictEqual([6, 7]);
});

test('2진수에서 1 숫자 세기', () => {
  expect(count1('1001110')).toBe(4);
});

test('배열에서 큰 수 찾기', () => {
  expect(findNextBigInteger({ binaryNumber: '101', numbers: [6, 7] })).toBe(6);
});

test('solution', () => {
  expect(solution(78)).toBe(83);
  expect(solution(15)).toBe(23);
});
