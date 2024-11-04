package lotto.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CustomerTest {
    @Test
    @DisplayName("Customer 객체를 생성할 수 있다.")
    void should_CreateCustomer() {
        // given
        Money budget = new Money("8000");
        MyLotto myLotto = new MyLotto(null);
        //when
        Customer customer = new Customer(budget, myLotto);
        //then
        Assertions.assertThat(customer).isNotNull();
    }

    @Test
    @DisplayName("고객은 로또를 구매할 수 있다.")
    void should_BuyLotto() {
        // given
        Money budget = new Money("8000");
        MyLotto myLotto = new MyLotto(new ArrayList<>());
        Customer customer = new Customer(budget, myLotto);
        List<Lotto> lottos = List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        // when
        customer.buyLotto(lottos);
        // then
        Assertions.assertThat(myLotto.getLottos()).hasSize(1);
    }

    @Test
    @DisplayName("고객은 수익률을 계산할 수 있다.")
    void should_CalculateEarningRate() {
        // given
        Money budget = new Money("1000");
        ArrayList<Lotto> lottos = new ArrayList<>(List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6))));
        MyLotto myLotto = new MyLotto(lottos);
        Customer customer = new Customer(budget, myLotto);
        AnswerNumbers answerNumbers = AnswerNumbers.from("1,2,3,4,5,8");
        BonusNumber bonusNumber = new BonusNumber("6");
        // when
        float earningRate = customer.getEarningRate(answerNumbers, bonusNumber);
        // then
        assertEquals(30000.0, earningRate);
    }
}