import solution from './reverse-natural-numbers';

test('solution', () => {
  expect(solution(12345)).toStrictEqual([5, 4, 3, 2, 1]);
});

// 1. 자료형에 정수, 부동소수점 수 구분이 없다보니 Java에서는 신경 안 썼었던
// 나눗셈의 결과에 소수점 이하 자리수가 포함되는지도 꼼꼼히 따져야 한다.
// 2. 배열이 같은지 확인하려면 toBe가 아니라 toStrictEqual을 사용해야 한다.
// 3. parseInt는 진법을 알려줘야 한다
