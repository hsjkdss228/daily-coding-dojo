import solution, { initializeMap, sliceMessage } from './CompressionWrong';

test('(A, 1) ~ (Z, 26)까지의 key, value를 Map에 add한 초기 사전 만들기', () => {
  const dictionary = initializeMap();
  expect(dictionary.size).toBe(26);
  expect(dictionary.get('A')).toBe(1);
  expect(dictionary.get('G')).toBe(7);
});

test('문자열의 특정 시작점 index부터 끝까지 부분 문자열 만들기', () => {
  const message = 'HELLO';
  expect(sliceMessage({ message, index: 2 })).toBe('LLO');
});

test('solution', () => {
  expect(solution('KAKAO'))
    .toStrictEqual([11, 1, 27, 15]);
  expect(solution('TOBEORNOTTOBEORTOBEORNOT'))
    .toStrictEqual([20, 15, 2, 5, 15, 18, 14, 15, 20, 27, 29, 31, 36, 30, 32, 34]);
  expect(solution('ABABABABABABABAB'))
    .toStrictEqual([1, 2, 27, 29, 28, 31, 30]);
});
