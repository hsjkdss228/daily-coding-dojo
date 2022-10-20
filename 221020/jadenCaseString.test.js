import solution, {
  modifyString, split, join, modifyStrings,
} from './jadenCaseString';

const context = describe;

describe('개별 문자열의 내용을 JadenCase에 맞게 변환', () => {
  context('문자만 있는 경우', () => {
    it('앞 문자는 대문자로, 나머지 문자는 소문자로 변환', () => {
      expect(modifyString('unFollowed')).toBe('Unfollowed');
    });
  });

  context('앞 글자가 숫자인 경우', () => {
    it('앞 문자에 상관없이 나머지 문자를 소문자로 변환', () => {
      expect(modifyString('1nFollowed')).toBe('1nfollowed');
    });
  });
});

// test('전체 문자열을 빈칸에 맞춰 나눔 (콘솔 테스트)', () => {
//   const words = 'Jesus exists.';
//   console.log(words.split(' '));

//   const words2 = 'Jesus     exists.';
//   console.log(words2.split(' '));

//   const words3 = 'Jesus exists.    ';
//   console.log(words3.split(' '));
// });

describe('전체 문자열을 빈칸에 맞춰 나눔', () => {
  it('빈칸이 한 칸씩만 있는 경우', () => {
    expect(split('i aM youR FATHER.')).toStrictEqual(['i', 'aM', 'youR', 'FATHER.']);
  });

  it('문자열 중간에 다수의 빈 칸이 있는 경우', () => {
    expect(split('i    aM youR FATHER.'))
      .toStrictEqual(['i', '', '', '', 'aM', 'youR', 'FATHER.']);
  });

  it('문자열 마지막에 다수의 빈 칸이 있는 경우', () => {
    expect(split('i aM youR FATHER.   '))
      .toStrictEqual(['i', 'aM', 'youR', 'FATHER.', '', '', '']);
  });
});

describe('나눠진 문자열들을 하나의 문자열로 합침', () => {
  context('공백 문자열이 없는 경우', () => {
    it('문자열들을 한 칸씩 띄워 합침', () => {
      expect(join(['i', 'aM', 'youR', 'FATHER.'])).toBe('i aM youR FATHER.');
    });
  });

  context('공백 문자열이 문자열 중간에 있는 경우', () => {
    it('공백 문자열만큼 한 칸씩 띄워 합침', () => {
      expect(join(['i', '', '', '', 'aM', 'youR', 'FATHER.']))
        .toBe('i    aM youR FATHER.');
    });
  });

  context('공백 문자열이 문자열 마지막에 있는 경우', () => {
    it('공백 문자열만큼 한 칸씩 띄워 합침', () => {
      expect(join(['i', 'aM', 'youR', 'FATHER.', '', '', '']))
        .toBe('i aM youR FATHER.   ');
    });
  });
});

describe('개별 문자열들의 배열에 대해 modifyString을 수행', () => {
  context('문자열 배열이 정상적으로 주어진 경우', () => {
    it('map을 이용해 문자열들을 변환', () => {
      expect(modifyStrings(['i', 'aM', 'youR', 'FATHER.']))
        .toStrictEqual(['I', 'Am', 'Your', 'Father.']);
    });
  });
});

describe('solution', () => {
  context('case 1: 문자열마다 한 칸씩의 공백만 있는 경우', () => {
    it('정상적으로 변환', () => {
      expect(solution('i am your fatHER')).toBe('I Am Your Father');
    });
  });

  context('case 2: 문자열 중간에 여러 칸의 공백이 있는 경우', () => {
    it('정상적으로 변환', () => {
      expect(solution('i    am    your fatHER')).toBe('I    Am    Your Father');
    });
  });

  context('case 3: 문자열 마지막에 여러 칸의 공백이 있는 경우', () => {
    it('정상적으로 변환', () => {
      expect(solution('i am your fatHER     ')).toBe('I Am Your Father     ');
    });
  });
});
