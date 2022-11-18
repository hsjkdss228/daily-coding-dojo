// export default function solution(participants, number1, number2) {
  
// }

// export function mapTest() {
//   const array = Array(8).fill(0).map((_, index) => index + 1);
//   console.log(array);

//   const pair = [];
//   const array1 = [];
//   const array2 = [];

//   array.forEach((index) => {
//     console.log(index);
//     pair.push(index);
//     console.log(pair);
//     if (pair.length === 2) {
//       array1.push(pair);
//       pair.splice(0);
//     }
//   });

//   console.log(array1[0]);
// }

export default function solution(n, a, b) {
  let answer = 1;

  while (Math.pow(2, answer) < n) {
    if (Math.abs(a - b) === 1 && Math.min(a, b) % 2 === 1) {
      break;
    }

    a = Math.ceil(a / 2);
    b = Math.ceil(b / 2);

    answer += 1;
  }

  return answer;
}
