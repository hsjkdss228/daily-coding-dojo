export default function solution(membersCount, words) {
  const checkedWords = [];

  const answer = words.reduce((numberAndOrder, word, index) => {
    // console.log('index', index);
    // console.log('word', word);
    // console.log('checkedWords', checkedWords);
    // console.log('numberAndOrder', numberAndOrder);
    const { number, order } = numberAndOrder;
    if (number !== 0 && order !== 0) {
      return numberAndOrder;
    }

    // console.log('include word', checkedWords.includes(word));
    if (checkedWords.includes(word)) {
      const newNumberAndOrder = numberAndOrder;
      newNumberAndOrder.number = (index % membersCount) + 1;
      newNumberAndOrder.order = Math.floor(index / membersCount) + 1;
      // console.log(newNumberAndOrder);
      return newNumberAndOrder;
    }

    if (checkedWords.length >= 1) {
      const lastWord = checkedWords[checkedWords.length - 1];
      if (lastWord[lastWord.length - 1] !== word.charAt(0)) {
        const newNumberAndOrder = numberAndOrder;
        newNumberAndOrder.number = (index % membersCount) + 1;
        newNumberAndOrder.order = Math.floor(index / membersCount) + 1;
        return newNumberAndOrder;
      }
    }

    checkedWords.push(word);
    return numberAndOrder;
  }, { number: 0, order: 0 });

  // console.log(answer, 'answer');

  const { number, order } = answer;
  const answerArray = [number, order];
  // console.log('answerArray', answerArray);
  return answerArray;
}
