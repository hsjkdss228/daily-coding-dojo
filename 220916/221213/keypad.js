export function calculateLength({
  numberPosition,
  currentHand,
}) {
  return Math.abs(numberPosition.x - currentHand.x)
    + Math.abs(numberPosition.y - currentHand.y);
}

export function calculateDistanceFromHands({
  numberPosition,
  numbersAndCurrentHands,
  hand,
}) {
  const renewed = numbersAndCurrentHands;
  const { left } = numbersAndCurrentHands;
  const { right } = numbersAndCurrentHands;

  const distanceFromLeft = calculateLength({
    numberPosition,
    currentHand: left,
  });

  const distanceFromRight = calculateLength({
    numberPosition,
    currentHand: right,
  });

  if (distanceFromLeft < distanceFromRight) {
    renewed.left = numberPosition;
    renewed.results.push('L');
    return renewed;
  }

  if (distanceFromLeft > distanceFromRight) {
    renewed.right = numberPosition;
    renewed.results.push('R');
    return renewed;
  }

  if (hand === 'left') {
    renewed.left = numberPosition;
    renewed.results.push('L');
    return renewed;
  }

  renewed.right = numberPosition;
  renewed.results.push('R');
  return renewed;
}

export default function solution(numbers, hand) {
  const position = {
    1: { x: 0, y: 0 },
    2: { x: 0, y: 1 },
    3: { x: 0, y: 2 },
    4: { x: 1, y: 0 },
    5: { x: 1, y: 1 },
    6: { x: 1, y: 2 },
    7: { x: 2, y: 0 },
    8: { x: 2, y: 1 },
    9: { x: 2, y: 2 },
    0: { x: 3, y: 1 },
  };

  const numbersAndCurrentHands = numbers.reduce((accumulator, number) => {
    if (number === 1
        || number === 4
        || number === 7) {
      accumulator.left = position[number];
      accumulator.results.push('L');
      return accumulator;
    }

    if (number === 3
      || number === 6
      || number === 9) {
      accumulator.right = position[number];
      accumulator.results.push('R');
      return accumulator;
    }

    return calculateDistanceFromHands({
      numberPosition: position[number],
      numbersAndCurrentHands: accumulator,
      hand,
    });
  }, {
    left: { x: 3, y: 0 },
    right: { x: 3, y: 2 },
    results: [],
  });

  return numbersAndCurrentHands.results.join('');
}
