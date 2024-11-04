package observer;

import java.util.List;

public interface Observer {

    void update(List<Integer> winningNumbers, int bonusNumber);
}
