export default function solution(message) {
  const dictionary = new Map();

  const answer = [];

  Array(26).fill(0).map((_, index) => index + 65)
    .forEach((value) => {
      dictionary.set(String.fromCharCode(value), value - 64);
    });

  let index = 0;
  while (index < message.length) {
    const w = [];
    while (index < message.length) {
      if (!dictionary.has(w.join('') + message[index])) {
        break;
      }
      if (dictionary.has(w.join('') + message[index])) {
        w.push(message[index]);
      }
      index += 1;
    }

    answer.push(dictionary.get(w.join('')));

    if (index < message.length) {
      dictionary.set(w.join('') + message[index], dictionary.size + 1);
    }
  }

  return answer;
}
