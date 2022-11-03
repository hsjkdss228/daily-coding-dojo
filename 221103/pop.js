function solution(string) {
  const stack = [];
  [...string].forEach((element) => {
    stack.push(element);
    if (element === stack[stack.length - 2]) {
      stack.pop();
      stack.pop();
    }
  });

  return stack.length === 0 ? 1 : 0;
}

solution('baabaa');
