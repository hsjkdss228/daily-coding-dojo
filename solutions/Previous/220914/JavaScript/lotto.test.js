import {
  countRightNumbers, countZeroNumbers, rank,
} from './lotto';

test('Count right numbers', () => {
  const myNumbers = [44, 1, 0, 0, 31, 25];
  const winNumbers = [31, 10, 45, 1, 6, 19];

  const rightNumbersCount = countRightNumbers(myNumbers, winNumbers);

  expect(rightNumbersCount).toBe(2);
});

test('Count zero numbers', () => {
  const myNumbers = [44, 1, 0, 0, 31, 25];

  const zeroCount = countZeroNumbers(myNumbers);

  expect(zeroCount).toBe(2);
});

describe('Rank', () => {
  it('Rank with normal case', () => {
    const rightNumbersCount = 2;
    const zeroCount = 2;

    const theHighestRankAndTheLowestRank = rank(rightNumbersCount, zeroCount);

    expect(theHighestRankAndTheLowestRank).toStrictEqual([3, 5]);
  });

  it('Rank with edge cases: 0 right numbers and 0 zeros', () => {
    const rightNumbersCount = 0;
    const zeroCount = 0;

    const theHighestRankAndTheLowestRank = rank(rightNumbersCount, zeroCount);

    expect(theHighestRankAndTheLowestRank).toStrictEqual([6, 6]);
  });

  it('Rank with edge cases: 6 right numbers and 0 zeros', () => {
    const rightNumbersCount = 6;
    const zeroCount = 0;

    const theHighestRankAndTheLowestRank = rank(rightNumbersCount, zeroCount);

    expect(theHighestRankAndTheLowestRank).toStrictEqual([1, 1]);
  });

  it('Rank with edge cases: 0 right numbers and 6 zeros', () => {
    const rightNumbersCount = 0;
    const zeroCount = 6;

    const theHighestRankAndTheLowestRank = rank(rightNumbersCount, zeroCount);

    expect(theHighestRankAndTheLowestRank).toStrictEqual([1, 6]);
  });
});
