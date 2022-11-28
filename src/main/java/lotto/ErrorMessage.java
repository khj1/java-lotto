package lotto;

public interface ErrorMessage {
    String INVALID_LOTTO_SIZE = "6개의 숫자를 입력해주세요.";
    String DUPLICATED_NUMBERS = "서로 중복되지 않는 숫자를 입력해주세요.";
    String INVALID_LOTTO_NUMBER_RANGE = "로또 번호는 1~45 사이의 숫자를 입력해주세요.";
    String NON_NUMERIC_MONEY = "금액은 숫자로만 입력해주세요,";
    String UNDIVIDED_BY_LOTTO_PRICE = "1,000 원 단위의 금액만 입력할 수 있습니다.";
    String NON_NUMERIC_NUMBER = "숫자만 입력할 수 있습니다.";
}
