function solution(clothes) {
  const map = new Map();
  let cnt = 1;

  for (const [c, t] of clothes) {
    if (map.has(t)) map.set(t, map.get(t) + 1);
    else map.set(t, 1);
  }

  for (const x of map.values()) cnt *= (x + 1);
  return cnt - 1;
}
