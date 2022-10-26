export function resultArray(binaryString) {
  const zeros = [...binaryString].filter((element) => element === '0');

  return [zeros.length, [...binaryString].length - zeros.length];
}

export function process({ binaryString, count = 0, total = 0 }) {
  if (binaryString === '1') {
    return [count, total];
  }

  const [zeros, nextBinaryString] = resultArray(binaryString);

  return process({
    binaryString: nextBinaryString.toString(2),
    count: count + 1,
    total: total + zeros,
  });
}

export default function solution(binaryString) {
  return process({ binaryString });
}

// export function convert(binaryString) {
//   const binaryStringZeroExcluded = [...binaryString].reduce((zeroExcluded, binaryNumber) => (
//     binaryNumber === '0'
//       ? zeroExcluded
//       : zeroExcluded + binaryNumber
//   ), '');

//   const { length } = binaryStringZeroExcluded;

//   const convertedBinaryString = length.toString(2);

//   const zeroExcludedCount = binaryString.length - length;

//   return { convertedBinaryString, zeroExcludedCount };
// }

// export function convertUntil1(binaryString) {
//   const convertedBinaryString = {
//     value: binaryString,
//   };

//   while (convertedBinaryString.value !== '1') {
//     convertedBinaryString.value = convert(convertedBinaryString.value);
//   }

//   return convertedBinaryString.value;
// }

// export default function solution(binaryString) {
//   return [0, 0];
// }
