function getDistance(locatedNumber, target) {
  const keyPad = {
    1: [0, 0],
    2: [0, 1],
    3: [0, 2],
    4: [1, 0],
    5: [1, 1],
    6: [1, 2],
    7: [2, 0],
    8: [2, 1],
    9: [2, 2],
    '*': [3, 0],
    0: [3, 1],
    '#': [3, 2],
  };

  const currentPosition = keyPad[locatedNumber];
  const targetPosition = keyPad[target];

  return Math.abs(targetPosition[0] - currentPosition[0])
    + Math.abs(targetPosition[1] - currentPosition[1]);
}

export default function solution(numbers, handUse) {
  const answer = [];

  const handPosition = {
    leftHand: '*',
    rightHand: '#',
  };

  numbers.forEach((number) => {
    if (number === 1 || number === 4 || number === 7) {
      answer.push('L');
      handPosition.leftHand = number;
      return;
    }

    if (number === 3 || number === 6 || number === 9) {
      answer.push('R');
      handPosition.rightHand = number;
      return;
    }

    const leftHandDistance = getDistance(handPosition.leftHand, number);
    const rightHandDistance = getDistance(handPosition.rightHand, number);

    if (leftHandDistance > rightHandDistance) {
      answer.push('R');
      handPosition.rightHand = number;
      return;
    }

    if (leftHandDistance < rightHandDistance) {
      answer.push('L');
      handPosition.leftHand = number;
      return;
    }

    if (leftHandDistance === rightHandDistance) {
      if (handUse === 'right') {
        answer.push('R');
        handPosition.rightHand = number;
        return;
      }

      if (handUse === 'left') {
        answer.push('L');
        handPosition.leftHand = number;
      }
    }
  });

  return answer.join('');
}
