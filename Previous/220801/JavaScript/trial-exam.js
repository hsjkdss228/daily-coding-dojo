export function makeAnswersOfStudents(length) {
  const rulesOfAnswers = [
    [1, 2, 3, 4, 5],
    [2, 1, 2, 3, 2, 4, 2, 5],
    [3, 3, 1, 1, 2, 2, 4, 4, 5, 5],
  ];

  const answersOfStudents = [...Array(rulesOfAnswers.length)];

  answersOfStudents[0] = [...Array(length)].map((_, index) => rulesOfAnswers[0][index % 5]);
  answersOfStudents[1] = [...Array(length)].map((_, index) => rulesOfAnswers[1][index % 8]);
  answersOfStudents[2] = [...Array(length)].map((_, index) => rulesOfAnswers[2][index % 10]);

  return answersOfStudents;
}

export function markAnswers(answersOfStudents, answers) {
  return [...Array(3)].map((_, index) => (
    answersOfStudents[index].reduce((accumulator, __, questionIndex) => (
      answersOfStudents[index][questionIndex] === answers[questionIndex]
        ? accumulator + 1
        : accumulator
    ), 0)
  ));
}

export function pickWinner(countOfCorrectAnswers) {
  const bigger = Math.max(countOfCorrectAnswers[0], countOfCorrectAnswers[1]);
  const biggest = Math.max(bigger, countOfCorrectAnswers[2]);

  return countOfCorrectAnswers.reduce((winners, __, index) => (
    countOfCorrectAnswers[index] === biggest
      ? [...winners, index + 1]
      : winners
  ), []);
}

export function solution(answers) {
  const answersOfStudents = makeAnswersOfStudents(answers.length);

  const countOfCorrectAnswers = markAnswers(answersOfStudents, answers);

  return pickWinner(countOfCorrectAnswers);
}
