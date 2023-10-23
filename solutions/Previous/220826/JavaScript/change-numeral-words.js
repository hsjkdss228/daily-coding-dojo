export default function solution(numeralWord) {
  const numeralWords = {
    word: numeralWord,
  };

  numeralWords.word = numeralWords.word.replace(/zero/ig, '0');
  numeralWords.word = numeralWords.word.replace(/one/ig, '1');
  numeralWords.word = numeralWords.word.replace(/two/ig, '2');
  numeralWords.word = numeralWords.word.replace(/three/ig, '3');
  numeralWords.word = numeralWords.word.replace(/four/ig, '4');
  numeralWords.word = numeralWords.word.replace(/five/ig, '5');
  numeralWords.word = numeralWords.word.replace(/six/ig, '6');
  numeralWords.word = numeralWords.word.replace(/seven/ig, '7');
  numeralWords.word = numeralWords.word.replace(/eight/ig, '8');
  numeralWords.word = numeralWords.word.replace(/nine/ig, '9');

  return parseInt(numeralWords.word, 10);
}
