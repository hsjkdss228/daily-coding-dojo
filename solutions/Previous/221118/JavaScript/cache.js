export default function solution(limitCacheSize, elements) {
  const cities = elements.map((city) => city.toLowerCase());

  if (limitCacheSize === 0) {
    return cities.length * 5;
  }

  const cache = [];

  const answer = cities.reduce((time, city) => {
    const index = cache.findIndex((insertedCity) => insertedCity === city);
    if (index !== -1) {
      cache.splice(index, 1);
      cache.push(city);
      return time + 1;
    }
    if (cache.length === limitCacheSize) {
      cache.shift();
      cache.push(city);
      return time + 5;
    }
    cache.push(city);
    return time + 5;
  }, 0);

  return answer;
}
