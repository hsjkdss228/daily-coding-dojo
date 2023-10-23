import solution from './change-numeral-words';

test('Test cases', () => {
  expect(solution('one4seveneight')).toBe(1478);
  expect(solution('23four5six7')).toBe(234567);
  expect(solution('2three45sixseven')).toBe(234567);
  expect(solution('123')).toBe(123);
});
