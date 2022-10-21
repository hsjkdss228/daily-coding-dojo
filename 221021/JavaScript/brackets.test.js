import solution, { toArray, checkOpenBracketCount } from './brackets';

const context = describe;

test('괄호 문자열을 배열로 변환', () => {
  expect(toArray('()(())')).toStrictEqual(['(', ')', '(', '(', ')', ')']);
});

describe('배열을 reduce를 이용해서 닫는 괄호의 개수가 적법한지 체크', () => {
  context('여는 괄호 개수 === 닫는 괄호 개수인 경우', () => {
    it('0 반환', () => {
      expect(checkOpenBracketCount(['(', ')', '(', '(', ')', ')'])).toBe(0);
    });
  });

  context('여는 괄호 개수 > 닫는 괄호 개수인 경우', () => {
    it('양수 반환', () => {
      expect(checkOpenBracketCount(['(', '(', '(', '(', ')', ')'])).toBe(2);
    });
  });

  context('여는 괄호 개수 < 닫는 괄호 개수인 경우', () => {
    it('음수 반환', () => {
      expect(checkOpenBracketCount(['(', ')', ')', '(', ')', ')'])).toBeLessThan(0);
    });
  });
});

test('배열을 reduce를 이용해서 닫는 괄호의 개수가 적법한지 체크', () => {
  expect(checkOpenBracketCount(['(', ')', '(', '(', ')', ')'])).toBe(0);
});

test('solution', () => {
  expect(solution('(()()())')).toBe(true);
  expect(solution(')()()())')).toBe(false);
  expect(solution('(((()())')).toBe(false);
  expect(solution('(()()))())')).toBe(false);
});
