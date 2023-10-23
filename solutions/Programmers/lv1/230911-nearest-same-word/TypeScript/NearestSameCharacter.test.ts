import solution from './NearestSameCharacter';

const context = describe;

describe('solution', () => {
  context('When test case 1 has given', () => {
    const string = 'banana';

    it('answer returned successfully', () => {
      const answer = [-1, -1, -1, 2, 2, 2];
      expect(solution(string)).toStrictEqual(answer);
    });
  });

  context('When test case 2 has given', () => {
    const string = 'foobar';

    it('answer returned successfully', () => {
      const answer = [-1, -1, 1, -1, -1, -1];
      expect(solution(string)).toStrictEqual(answer);
    });
  });
});
