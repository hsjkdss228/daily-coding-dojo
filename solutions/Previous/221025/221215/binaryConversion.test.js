import solution, { removeZero } from './binaryConversion';

describe('binaryConversion', () => {
  it('2진수 문자열에서 0 제거', () => {
    const binaryString = '10101010';
    expect(removeZero(binaryString)).toBe('1111');
  })

  it ('문자열의 길이 값을 2진수로 변환', () => {
    expect('1111'.length.toString(2)).toBe('100');
  });

  it('solution', () => {
    expect(solution('110010101001')).toStrictEqual([3, 8]);
    expect(solution('01110')).toStrictEqual([3, 3]);
    expect(solution('1111111')).toStrictEqual([4, 1]);
  });
});
