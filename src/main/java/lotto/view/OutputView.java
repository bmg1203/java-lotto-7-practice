package lotto.view;

import java.util.List;

public class OutputView {
    public static void printPurchase(int purchase) {
        System.out.println(purchase);
    }

    public static void printLottoNumbers(List<List<Integer>> lottoNumbers) {
        System.out.println(lottoNumbers.size() + "개를 구매했습니다.");
        for (List<Integer> innerList : lottoNumbers) {
            System.out.print("[");
            for (int i = 0; i < innerList.size(); i++) {
                System.out.print(innerList.get(i));
                if (i < innerList.size() - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println("]");
        }
    }

}
