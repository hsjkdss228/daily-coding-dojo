// export function makeArray({ start, number }) {
//   return [...Array(Math.ceil(number / 2) - start + 1)]
//     .map((_, index) => index + start);
// }

// export function accumulate({ start, number }) {
//   const numbers = makeArray({ start, number });

//   const result = numbers.reduce((accumulator, next) => (
//     accumulator === number
//       ? number
//       : accumulator + next
//   ));

//   return result === number;
// }

// export default function solution(number) {
//   const numbers = makeArray({ start: 1, number });

//   const expressionsCount = numbers.reduce((accumulator, _, index) => (
//     accumulate({ start: index + 1, number })
//       ? accumulator + 1
//       : accumulator
//   ), 0);

//   return expressionsCount + 1;
// }
