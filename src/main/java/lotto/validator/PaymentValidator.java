package lotto.validator;

public class PaymentValidator {
    // payment라는 model을 활용하는 방법 생각해보기

    public boolean validPayment(String inputPayment) {
        try {
            Integer.parseInt(inputPayment);
            dividedBy1000(inputPayment);
            return true;
        } catch (NumberFormatException e) {
            throw new NumberFormatException();
        }
    }

    private boolean dividedBy1000(String inputPayment) {
        int payment = Integer.parseInt(inputPayment);
        return payment % 1000 == 0;
        // 유효하지 않은 숫자라고 예외 추가하기
    }



}
