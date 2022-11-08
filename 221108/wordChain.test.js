import solution from './wordChain';

test('solution case 1', () => {
  const membersCount = 3;
  const words = ['tank', 'kick', 'know', 'wheel', 'land', 'dream',
    'mother', 'robot', 'tank'];
  expect(solution(membersCount, words)).toStrictEqual([3, 3]);
});

test('solution case 2', () => {
  const membersCount = 5;
  const words = ['hello', 'observe', 'effect', 'take', 'either',
    'recognize', 'encourage', 'ensure', 'establish', 'hang', 'gather',
    'refer', 'reference', 'estimate', 'executive'];
  expect(solution(membersCount, words)).toStrictEqual([0, 0]);
});

test('solution case 3', () => {
  const membersCount = 2;
  const words = ['hello', 'one', 'even', 'never', 'now', 'world', 'draw'];
  expect(solution(membersCount, words)).toStrictEqual([1, 3]);
});
