import solution, { setUp, makeTuple } from './tuple';

describe('tuple', () => {
  it('setUp case 1', () => {
    const sets = '{{2,1,3,4},{2,1},{2},{2,1,3}}';
    const expected = [['2'], ['2', '1'], ['2', '1', '3'], ['2', '1', '3', '4']];
    expect(setUp(sets)).toStrictEqual(expected);
  });

  it('setUp case 2', () => {
    const sets = '{{4,2,3},{3},{2,3,4,1},{2,3}}';
    const expected = [['3'], ['2', '3'], ['4', '2', '3'], ['2', '3', '4', '1']];
    expect(setUp(sets)).toStrictEqual(expected);
  });

  it('makeTuple', () => {
    const sets = [['2'], ['2', '1'], ['2', '1', '3'], ['2', '1', '3', '4']];
    const expected = [2, 1, 3, 4];
    expect(makeTuple(sets)).toStrictEqual(expected);
  });

  it('solution', () => {
    const sets = '{{4,2,3},{3},{2,3,4,1},{2,3}}';
    const expected = [3, 2, 4, 1];
    expect(solution(sets)).toStrictEqual(expected);
  });
});
