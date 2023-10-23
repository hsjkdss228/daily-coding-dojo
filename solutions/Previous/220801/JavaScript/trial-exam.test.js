import {
  makeAnswersOfStudents, markAnswers, pickWinner, solution,
} from './trial-exam';

test('Make answer sheets of students Case 1', () => {
  const answersOfStudents = makeAnswersOfStudents(5);

  expect(answersOfStudents[0]).toStrictEqual([1, 2, 3, 4, 5]);
  expect(answersOfStudents[1]).toStrictEqual([2, 1, 2, 3, 2]);
  expect(answersOfStudents[2]).toStrictEqual([3, 3, 1, 1, 2]);
});

test('Make answer sheets of students Case 1', () => {
  const answersOfStudents = makeAnswersOfStudents(15);

  expect(answersOfStudents[0]).toStrictEqual([1, 2, 3, 4, 5, 1, 2, 3, 4, 5, 1, 2, 3, 4, 5]);
  expect(answersOfStudents[1]).toStrictEqual([2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2]);
  expect(answersOfStudents[2]).toStrictEqual([3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2]);
});

test('Mark answer sheets of students Case 1', () => {
  const answersOfStudents = [
    [1, 2, 3, 4, 5],
    [2, 1, 2, 3, 2],
    [3, 3, 1, 1, 2],
  ];
  const answers = [2, 4, 4, 3, 2];

  const countOfCorrectAnswers = markAnswers(answersOfStudents, answers);

  expect(countOfCorrectAnswers[0]).toBe(0);
  expect(countOfCorrectAnswers[1]).toBe(3);
  expect(countOfCorrectAnswers[2]).toBe(1);
});

test('Pick Winner Case 1: One Winner Case 1', () => {
  const countOfCorrectAnswers = [5, 1, 0];

  expect(pickWinner(countOfCorrectAnswers)).toStrictEqual([1]);
});

test('Pick Winner Case 2: One Winner Case 2', () => {
  const countOfCorrectAnswers = [1, 2, 4];

  expect(pickWinner(countOfCorrectAnswers)).toStrictEqual([3]);
});

test('Pick Winner Case 3: Two Winners Case 1', () => {
  const countOfCorrectAnswers = [5, 5, 0];

  expect(pickWinner(countOfCorrectAnswers)).toStrictEqual([1, 2]);
});

test('Pick Winner Case 4: Two Winners Case 2', () => {
  const countOfCorrectAnswers = [5, 2, 5];

  expect(pickWinner(countOfCorrectAnswers)).toStrictEqual([1, 3]);
});

test('Pick Winner Case 5: Three Winners', () => {
  const countOfCorrectAnswers = [5, 5, 5];

  expect(pickWinner(countOfCorrectAnswers)).toStrictEqual([1, 2, 3]);
});

test('solution', () => {
  const answers = [1, 3, 2, 4, 2];

  expect(solution(answers)).toStrictEqual([1, 2, 3]);
});
