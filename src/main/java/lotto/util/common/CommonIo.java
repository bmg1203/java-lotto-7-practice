package lotto.util.common;

import camp.nextstep.edu.missionutils.Console;

public class CommonIo {
    public void printMessage(Object message) {
        System.out.println(message);
    }

    public void printNewLine() {
        System.out.println();
    }

    public String receiveInput() {
        return Console.readLine();
    }

    public int convertStringToInt(String message) {
        return Integer.parseInt(message);
    }

    public String removeWhiteSpace(String message) {
        return message.replaceAll(Message.WHITE_SPACE.getSentence(), Message.BLANK.getSentence());
    }
}
