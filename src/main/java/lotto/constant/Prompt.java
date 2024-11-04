package lotto.constant;

import static java.lang.String.format;
import static java.lang.String.join;
import static java.lang.System.lineSeparator;

public enum Prompt {
    ENTER_PURCHASE_AMOUNT_TEXT("구입금액을 입력해 주세요.") {
        @Override
        public void display(Object... args) {
            System.out.println(this);
        }
    },
    ENTER_WINNING_NUMBER_TEXT("당첨 번호를 입력해 주세요.") {
        @Override
        public void display(Object... args) {
            System.out.println(this);
        }
    },
    ENTER_BONUS_NUMBER_TEXT("보너스 번호를 입력해 주세요.") {
        @Override
        public void display(Object... args) {
            System.out.println(this);
        }
    },
    RESULT_PURCHASE_AMOUNT_AND_AUTOMATIC_LOTTO_TEMPLATE(join(lineSeparator(), "%d개를 구매했습니다.", "%s")) {
        @Override
        public void display(Object... args) {
            if (args.length != 2) {
                throw new IllegalArgumentException("[ERROR] 필요한 매개변수가 없습니다.");
            }

            System.out.println(format(this.toString(), args));
        }
    },
    RESULT_WINNING_STATISTICS_LOTTO_TEMPLATE(join(lineSeparator(), "당첨통계", "---", "%s")) {
        @Override
        public void display(Object... args) {
            if (args.length != 1) {
                throw new IllegalArgumentException("[ERROR] 필요한 매개변수가 없습니다.");
            }

            System.out.println(format(this.toString(), args));
        }
    };

    private final String text;

    Prompt(String text) {
        this.text = text;
    }

    public static void display(String errorMessage) {
        System.out.println(errorMessage);
    }

    public static void displayEmptyLine() {
        System.out.println();
    }

    @Override
    public String toString() {
        return this.text;
    }

    public abstract void display(Object... args);

}
