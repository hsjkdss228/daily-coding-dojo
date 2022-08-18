import solution from './weird-string';

test('solution', () => {
  expect(solution('try hello world')).toBe('TrY HeLlO WoRlD');
});

test('solution', () => {
  expect(solution('coding     dojang i my me mine')).toBe('CoDiNg     DoJaNg I My Me MiNe');
});

test('solution', () => {
  expect(solution('TRY hello world')).toBe('TrY HeLlO WoRlD');
});

test('solution', () => {
  expect(solution('tryhelloworld')).toBe('TrYhElLoWoRlD');
});

test('solution', () => {
  expect(solution('      ')).toBe('      ');
});

test('solution', () => {
  expect(solution('tryhelloworld      ')).toBe('TrYhElLoWoRlD      ');
});

test('solution', () => {
  expect(solution('     tryhelloworld')).toBe('     TrYhElLoWoRlD');
});

test('solution', () => {
  expect(solution('a b c d e f g')).toBe('A B C D E F G');
});
