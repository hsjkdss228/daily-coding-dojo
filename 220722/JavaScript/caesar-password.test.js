import solution from './caesar-password';

test('testNormalUpperCases', () => {
  expect(solution('AB', 1)).toStrictEqual('BC');
});

test('testExceededUpperCases', () => {
  expect(solution('YZZ', 4)).toStrictEqual('CDD');
});

test('testNormalLowerCases', () => {
  expect(solution('eagles', 3)).toStrictEqual('hdjohv');
});

test('testExceededLowerCases', () => {
  expect(solution('zyzy', 10)).toStrictEqual('jiji');
});

test('testContainsBlank', () => {
  expect(solution('H e L L o', 3)).toStrictEqual('K h O O r');
});
