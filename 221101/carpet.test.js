import solution, { makeSubmultiples, compareToBrownCount, process } from './carpet';

test('노란색 격자 수의 약수 배열 생성', () => {
  expect(makeSubmultiples(27)).toStrictEqual([27, 9, 3, 1]);
});

test('쌍(가로 길이, 세로 길이)을 이용해 계산한 둘러싸는 블록 개수가 갈색 블록 수와 맞는지 비교', () => {
  expect(compareToBrownCount({ combination: [27, 1], brownCount: 28 })).toBe(false);
  expect(compareToBrownCount({ combination: [9, 3], brownCount: 28 })).toBe(true);
});

test('약수 배열에서 반복을 돌면서 격자를 비교해서 결과를 도출하는지 확인', () => {
  expect(process({ submultiples: [27, 9, 3, 1], brownCount: 28 })).toStrictEqual([11, 5]);
});

test('solution', () => {
  expect(solution(10, 2)).toStrictEqual([4, 3]);
  expect(solution(8, 1)).toStrictEqual([3, 3]);
  expect(solution(24, 24)).toStrictEqual([8, 6]);
});
