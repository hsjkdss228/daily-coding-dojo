import {
  deduplicate, sortArrays, findStudentsCantLendClothes, solution,
} from './uniform';

test('Deduplicate Losts and Reserves', () => {
  const losts = [1, 2, 3, 5, 6, 7];
  const reserves = [3, 4, 5];

  const { uniqueLosts, uniqueReserves } = deduplicate(losts, reserves);

  expect(uniqueLosts).toStrictEqual([1, 2, 6, 7]);
  expect(uniqueReserves).toStrictEqual([4]);
});

test('Not Deduplicate Losts and Reserves', () => {
  const losts = [2, 4];
  const reserves = [1, 3];

  const { uniqueLosts, uniqueReserves } = deduplicate(losts, reserves);

  expect(uniqueLosts).toStrictEqual([2, 4]);
  expect(uniqueReserves).toStrictEqual([1, 3]);
});

test('Sort arrays', () => {
  const losts = [5, 13, 6, 22];
  const reserves = [35, 4, 9, 31, 3];

  const { sortedLosts, sortedReserves } = sortArrays(losts, reserves);

  expect(sortedLosts).toStrictEqual([5, 6, 13, 22]);
  expect(sortedReserves).toStrictEqual([3, 4, 9, 31, 35]);
});

test('Not Sort arrays', () => {
  const losts = [2, 4];
  const reserves = [1, 3];

  const { sortedLosts, sortedReserves } = sortArrays(losts, reserves);

  expect(sortedLosts).toStrictEqual([2, 4]);
  expect(sortedReserves).toStrictEqual([1, 3]);
});

test('Check if students who lost clothes can lend clothes to other students', () => {
  const lostsCase1 = [2, 4];
  const reservesCase1 = [1, 3];

  const studentsUnableToAttendCase1 = findStudentsCantLendClothes(lostsCase1, reservesCase1);

  expect(studentsUnableToAttendCase1).toStrictEqual([]);

  const lostsCase2 = [1, 2, 3];
  const reservesCase2 = [4, 5, 6, 7];

  const studentsUnableToAttendCase2 = findStudentsCantLendClothes(lostsCase2, reservesCase2);

  expect(studentsUnableToAttendCase2).toStrictEqual([1, 2]);
});

test('Check if students who lost clothes cannot lend clothes to other students', () => {
  const lostsCase1 = [1, 2, 3];
  const reservesCase1 = [5, 6, 7, 8];

  const studentsUnableToAttendCase1 = findStudentsCantLendClothes(lostsCase1, reservesCase1);

  expect(studentsUnableToAttendCase1).toStrictEqual([1, 2, 3]);
});

test('solution', () => {
  const studentsCountCase1 = 9;
  const lostsCase1 = [5, 6, 8, 1, 2];
  const reservesCase1 = [2, 3, 1, 4, 8, 9];

  expect(solution(studentsCountCase1, lostsCase1, reservesCase1)).toBe(8);

  const studentsCountCase2 = 7;
  const lostsCase2 = [2, 4];
  const reservesCase2 = [1, 3];

  expect(solution(studentsCountCase2, lostsCase2, reservesCase2)).toBe(7);
});
