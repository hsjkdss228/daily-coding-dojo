export default function solution(n) {
  const initialCase = Array(3).fill(0).map((_, index) => index);

  const allCases = Array(n + 1).fill(0).reduce((cases, _, index) => {
    if (index <= 2) {
      return cases;
    }
    const casesAdded = [...cases,
      (cases[index - 2] + cases[index - 1]) % 1234567];
    return casesAdded;
  }, initialCase);

  return allCases[n];
}
