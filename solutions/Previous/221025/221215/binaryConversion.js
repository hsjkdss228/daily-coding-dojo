export function removeZero(lastBinaryString) {
  return [...lastBinaryString]
    .filter((number) => number === '1')
    .join('');
}

export default function solution(binaryString) {
  const convertedStrings = [binaryString];
  let deletedZeroCount = 0;
  
  while (convertedStrings[convertedStrings.length - 1] !== '1') {
    const lastBinaryString = convertedStrings[convertedStrings.length - 1];

    const zeroRemovedString = removeZero(lastBinaryString);

    const zeroRemovedCount = lastBinaryString.length - zeroRemovedString.length;
    deletedZeroCount += zeroRemovedCount;

    const newBinaryString = zeroRemovedString.length.toString(2);
    convertedStrings.push(newBinaryString);
  }

  return [convertedStrings.length - 1, deletedZeroCount];
}
