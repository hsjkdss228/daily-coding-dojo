export function initializeMap() {
  const dictionary = new Map();

  // 함수형으로 리팩터링 필요...
  Array(26).fill(0).map((_, index) => index + 65)
    .forEach((value) => {
      dictionary.set(String.fromCharCode(value), value - 64);
    });

  return dictionary;
}

export function sliceMessage({ message, index }) {
  return message.slice(index, message.length);
}

export default function solution(message) {
  const answer = [];
  const dictionary = initializeMap();

  console.log('message length: ', message.length);

  [...message].reduce((addedWordsCount, alphabet, index, array) => {
    const slicedMessage = sliceMessage({ message, index });
    const containedArray = [];

    // console.log('addedWordsCount: ', addedWordsCount);

    if (addedWordsCount) {
      return addedWordsCount - 1;
    }

    // 함수형으로 리팩터링 필요...
    for (let i = 0; i < slicedMessage.length; i += 1) {
      const alphabets = slicedMessage.slice(0, i + 1);
      console.log(alphabets);
      console.log('index: ', index);

      if (index + alphabets.length === array.length) {
        answer.push(dictionary.get(alphabets));
        return containedArray.length - 1;
      }

      if (index === array.length - 1) {
        answer.push(dictionary.get(alphabets));
      }

      if (dictionary.has(alphabets)) {
        containedArray.push(dictionary.get(alphabets));
      }

      if (!dictionary.has(alphabets)) {
        answer.push(containedArray[containedArray.length - 1]);
        dictionary.set(alphabets, dictionary.size + 1);
        break;
      }
    }

    return containedArray.length === 0
      ? 0
      : containedArray.length - 1;
  }, 0);

  console.log(answer);

  return answer;
}
