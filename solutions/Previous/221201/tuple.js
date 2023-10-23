export function setUp(sets) {
  const bracketsReplaced = sets.substring(2, sets.length - 2)
    .replaceAll('},{', '/');
  const sortedSets = bracketsReplaced.split('/')
    .sort((a, b) => a.length - b.length);

  const sortedSetsList = [];
  sortedSets.forEach((set) => {
    sortedSetsList.push(set.split(','));
  });

  return sortedSetsList;
}

export function makeTuple(sortedSets) {
  const answer = [];

  sortedSets.forEach((set) => {
    set.forEach((element) => {
      const number = Number(element);
      if (!answer.includes(number)) {
        answer.push(number);
      }
    });
  });

  return answer;
}

export default function solution(sets) {
  const sortedSets = setUp(sets);

  return makeTuple(sortedSets);
}
