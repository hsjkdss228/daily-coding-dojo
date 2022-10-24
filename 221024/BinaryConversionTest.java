import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BinaryConversionTest {
  @Test
  void excludeAllZeros() {
    BinaryConversion test = new BinaryConversion();

    assertThat(test.excludeAllZeros("0111010")).isEqualTo("1111");
  }

  @Test
  void length() {
    BinaryConversion test = new BinaryConversion();

    assertThat(test.length("1111")).isEqualTo(4);
  }

  @Test
  void convertToBinaryNumber() {
    BinaryConversion test = new BinaryConversion();

    assertThat(test.convertToBinaryNumber(4)).isEqualTo("100");
  }

  @Test
  void convert() {
    BinaryConversion test = new BinaryConversion();

    assertThat(test.convert("0111010")).isEqualTo("100");
  }

  @Test
  void excludedZerosCountAndConvertedCount() {
    BinaryConversion test = new BinaryConversion();

    test.convert("0111010");
    assertThat(test.excludedZerosCount()).isEqualTo(3);
    assertThat(test.convertedCount()).isEqualTo(1);
  }

  @Test
  void convertUntil1() {
    BinaryConversion test = new BinaryConversion();

    assertThat(test.convertUntil1("0111010")).isEqualTo("1");
  }

  @Test
  void solutionCase1() {
    BinaryConversion test = new BinaryConversion();

    assertThat(test.solution("110010101001")).isEqualTo(new int[]{3, 8});
  }

  @Test
  void solutionCase2() {
    BinaryConversion test = new BinaryConversion();

    assertThat(test.solution("01110")).isEqualTo(new int[]{3, 3});
  }

  @Test
  void solutionCase3() {
    BinaryConversion test = new BinaryConversion();

    assertThat(test.solution("1111111")).isEqualTo(new int[]{4, 1});
  }
}
