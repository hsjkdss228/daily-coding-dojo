// import solution, {
//   destructure, arrayEquals, popDuplicated, popRecursively,
// } from './pop';

// test('문자열 destructuring', () => {
//   expect(destructure('abbababaaa'))
//     .toStrictEqual(['a', 'b', 'b', 'a', 'b', 'a', 'b', 'a', 'a', 'a']);
// });

// test('문자열을 filter해 중복 문자열 제거', () => {
//   expect(popDuplicated(['a', 'b', 'b', 'a', 'b', 'a'])).toStrictEqual(['a', 'a', 'b', 'a']);
// });

// test('arrayNotEquals with different length', () => {
//   expect(arrayEquals(['a', 'b', 'b'], ['a'])).toBe(false);
// });

// test('arrayNotEquals with different values', () => {
//   expect(arrayEquals(['a', 'b', 'b'], ['b', 'b', 'a'])).toBe(false);
// });

// test('arrayEquals', () => {
//   expect(arrayEquals(['a', 'b', 'b'], ['a', 'b', 'b'])).toBe(true);
// });

// test('재귀함수로 popDuplicated를 빈 배열만 남을 때까지 반복 (성공 케이스)', () => {
//   expect(popRecursively(['b', 'a', 'a', 'b', 'a', 'a'])).toBe(1);
// });

// test('재귀함수로 popDuplicated를 빈 배열만 남을 때까지 반복 (실패 케이스)', () => {
//   expect(popRecursively(['c', 'd', 'c', 'd'])).toBe(0);
// });

// test('solution', () => {
//   expect(solution('baabaa')).toBe(1);
//   expect(solution('cdcd')).toBe(0);
// });
