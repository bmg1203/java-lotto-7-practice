package lotto.strategy;

import lotto.domain.LottoNumberRange;
import lotto.support.ManualIssueStrategy;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class IssueStrategyTest {

    @Test
    void 로또_발행_방법_인터페이스_구현() {
        //given
        IssueStrategy issueStrategy = () -> List.of(1, 2, 3, 4, 5, 6);

        //then
        assertNumbersByIssueStrategy(issueStrategy);
    }

    @Test
    void 자동_로또_발행_방법_인터페이스_구현체() {
        //given
        IssueStrategy issueStrategy = AutoIssueStrategy.getInstance();

        //then
        assertNumbersByIssueStrategy(issueStrategy);
    }

    @Test
    void 테스트_위한_수동_로또_발행_방법_인터페이스_구현체() {
        //given
        IssueStrategy issueStrategy = ManualIssueStrategy.of(1, 2, 3, 4, 5, 6);

        //then
        assertNumbersByIssueStrategy(issueStrategy);
    }

    private void assertNumbersByIssueStrategy(IssueStrategy issueStrategy) {
        List<Integer> numbers = issueStrategy.issue();

        assertThat(numbers).hasSize(6);
        assertThat(numbers).allMatch(number -> number >= LottoNumberRange.MIN.getValue());
        assertThat(numbers).allMatch(number -> number <= LottoNumberRange.MAX.getValue());
    }
}
