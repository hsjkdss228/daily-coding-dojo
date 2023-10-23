import solution, { calculateLength, calculateDistanceFromHands } from './keypad';

describe('Keypad', () => {
  it('calculateLength', () => {
    const numberPosition = { x: 1, y: 1 };
    const currentHand = { x: 1, y: 0 };
    expect(calculateLength({ numberPosition, currentHand }))
      .toBe(1);
  });

  it('calculateDistanceFromhands', () => {
    const numberPosition = { x: 1, y: 1 };
    const numbersAndCurrentHands = {
      left: { x: 0, y: 0 },
      right: { x: 1, y: 2 },
      results: ['L', 'R'],
    };
    const hand = 'right';

    const result = {
      left: { x: 0, y: 0 },
      right: { x: 1, y: 1 },
      results: ['L', 'R', 'R'],
    };

    expect(calculateDistanceFromHands({
      numberPosition, numbersAndCurrentHands, hand,
    })).toStrictEqual(result);
  });

  it('solution', () => {
    const numbers = [1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5];
    const hand = 'right';

    const result = 'LRLLLRLLRRL';

    expect(solution(numbers, hand)).toBe(result);
  });
});
