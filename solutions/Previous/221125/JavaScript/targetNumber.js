export default function solution(numbers, target) {
  const initial = [numbers[0], numbers[0] * -1];

  const results = numbers.splice(1).reduce((accumulator, number) => {
    const replacing = [];
    accumulator.forEach((interim) => {
      replacing.push(interim + number);
      replacing.push(interim - number);
    });
    return replacing;
  }, initial);

  return results.filter((result) => result === target).length;
}
