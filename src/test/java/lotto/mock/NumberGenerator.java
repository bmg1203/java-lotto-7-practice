package lotto.mock;

import java.util.List;

public class NumberGenerator implements lotto.domain.NumberGenerator {
    @Override
    public List<Integer> generate() {
        return List.of(1,2,3,4,5,6);
    }
}
