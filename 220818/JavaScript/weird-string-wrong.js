export default function solution(string) {
  let weirdString = '';

  let wordCount = 0;

  for (let i = 0; i < string.length; i += 1) {
    if (string.charAt(i) === ' ') {
      weirdString += ' ';
      wordCount = 0;
      continue;
    }

    if (wordCount % 2 === 0) {
      weirdString += string.charAt(i).toUpperCase();
      wordCount += 1;
      continue;
    }

    if (wordCount % 2 === 1) {
      weirdString += string.charAt(i).toLowerCase();
      wordCount += 1;
      continue;
    }
  }

  return weirdString;
}

console.log(solution('try hello world'));
