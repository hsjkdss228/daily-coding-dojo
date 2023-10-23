export function hasLength4Or6(string) {
  return string.length === 4 || string.length === 6;
}

export function hasOnlyNumbers(string) {
  return [...string].reduce((currentStatus, character) => (
    Number.isNaN(Number(character))
      ? false
      : currentStatus
  ), true);
}

export default function solution(string) {
  if (!hasLength4Or6(string)) {
    return false;
  }

  return hasOnlyNumbers(string);
}
