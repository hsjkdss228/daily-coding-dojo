import solution, { sortInDescendingOrder } from './fruitSeller';

const context = describe;

describe('fruitSeller', () => {
  context('sortInDescendingOrder: scores를 내림차순으로 정렬하면', () => {
    it('배열을 큰 수부터 작은 수 순서대로 내림차순으로 정렬', () => {
      const scores = [3, 7, 3, 8, 5, 1];

      expect(sortInDescendingOrder(scores))
        .toStrictEqual([8, 7, 5, 3, 3, 1]);
    });
  });

  context('solution: 문제의 모든 조건이 주어지면', () => {
    it('정답을 정상적으로 반환 (case 1)', () => {
      const k = 3;
      const numberInBox = 4;
      const scores = [1, 2, 3, 1, 2, 3, 1];

      expect(solution(k, numberInBox, scores)).toBe(8);
    });

    it('정답을 정상적으로 반환 (case 2)', () => {
      const k = 4;
      const numberInBox = 3;
      const scores = [4, 1, 2, 2, 4, 4, 4, 4, 1, 2, 4, 2];

      expect(solution(k, numberInBox, scores)).toBe(33);
    });
  });
});
