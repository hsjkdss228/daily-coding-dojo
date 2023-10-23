import solution, { hasLength4Or6, hasOnlyNumbers } from './stringCheck';

const context = describe;

describe('stringCheck', () => {
  context('문자열의 길이가 4이거나 6이면', () => {
    it('true', () => {
      const string1 = '1234';
      expect(hasLength4Or6(string1)).toBe(true);
      const string2 = 'abcdef';
      expect(hasLength4Or6(string2)).toBe(true);
    });
  });

  context('문자열의 길이가 4나 6이 아니면', () => {
    it('false', () => {
      const string1 = '123asdf4';
      expect(hasLength4Or6(string1)).toBe(false);
      const string2 = 'a1f';
      expect(hasLength4Or6(string2)).toBe(false);
    });
  });

  context('문자열에 숫자만 포함되어 있으면', () => {
    it('true', () => {
      const string1 = '112233';
      expect(hasOnlyNumbers(string1)).toBe(true);
      const string2 = '9017';
      expect(hasOnlyNumbers(string2)).toBe(true);
    });
  });

  context('문자열에 숫자가 아닌 문자가 포함되어 있으면', () => {
    it('false', () => {
      const string1 = '1ab33U';
      expect(hasOnlyNumbers(string1)).toBe(false);
      const string2 = 'a234';
      expect(hasOnlyNumbers(string2)).toBe(false);
      const string3 = 'GIzQ';
      expect(hasOnlyNumbers(string3)).toBe(false);
    });
  });
});
