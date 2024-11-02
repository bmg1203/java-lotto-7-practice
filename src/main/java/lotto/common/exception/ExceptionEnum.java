package lotto.common.exception;

import lotto.common.exception.constant.RuntimeExceptionType;

/**
 * @author : jiffyin7@gmail.com
 * @since : 24. 10. 30.
 */
public enum ExceptionEnum {

  CONTAIN_WHITESPACE(RuntimeExceptionType.ILLEGAL_ARGUMENT, "공백 없이 입력해야 합니다."),
  CONTAIN_BLANK(RuntimeExceptionType.ILLEGAL_ARGUMENT, "입력이 비어있습니다."),

  IVALID_INPUT(RuntimeExceptionType.ILLEGAL_ARGUMENT, "잘못된 입력입니다."),
  INVALID_STATE(RuntimeExceptionType.ILLEGAL_STATE, "잘못된 상태입니다."),

  INVALID_INTEGER_RANGE(RuntimeExceptionType.ILLEGAL_ARGUMENT, "입력이 범위 안의 숫자를 입력해야 합니다. 범위 : "),
  INPUT_LESS_THAN_MINIMUM(RuntimeExceptionType.ILLEGAL_ARGUMENT, "입력이 최소값 보다 커야 합니다. 최소값 : "),
  INPUT_GREATER_THAN_MINIMUM(RuntimeExceptionType.ILLEGAL_ARGUMENT, "입력이 최대값 보다 작아야 합니다. 최대값 : "),
  INVALID_LONG_RANGE(RuntimeExceptionType.ILLEGAL_ARGUMENT, "입력이 범위 안의 숫자를 입력해야 합니다. 범위 : "),
  PURCHASE_AMOUNT_NOT_IN_UNIT(RuntimeExceptionType.ILLEGAL_ARGUMENT, "구매 금액은 일정 단위여야 합니다. 단위 : ");

  private final RuntimeExceptionType type;
  private final String message;

  ExceptionEnum(RuntimeExceptionType type, String message) {
    this.type = type;
    this.message = message;
  }

  public RuntimeExceptionType getType() {
    return type;
  }

  public String getMessage() {
    return this.message;
  }
}
