import solution from './bracketRotation';

describe('bracketRotation', () => {
  it('solution', () => {
    expect(solution('[](){}')).toBe(3);
    expect(solution('}]()[{')).toBe(2);
    expect(solution('[)(]')).toBe(0);
    expect(solution('}}}')).toBe(0);
  });
});
