const context = describe;

describe('jest 설치 테스트', () => {
  context('1 + 2는', () => {
    const answer = 1 + 2;

    it('3', () => {
      expect(answer).toBe(3);
    });
  });
});
