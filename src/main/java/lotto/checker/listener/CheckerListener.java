package lotto.checker.listener;

import lotto.checker.domain.Lottos;
import lotto.purchase.event.MoneyCreatedEvent;
import lotto.purchase.application.FortuneMachineService;
import lotto.shared.event.*;

public class CheckerListener implements EventListener {

    EventPublisher eventPublisher;
    EventOrchestrator eventOrchestrator;
    FortuneMachineService fortuneMachineService;

    public CheckerListener(EventPublisher eventPublisher,
                         FortuneMachineService fortuneMachineService,
                         EventOrchestrator eventOrchestrator) {
        this.eventPublisher = eventPublisher;
        this.fortuneMachineService = fortuneMachineService;
        this.eventOrchestrator = eventOrchestrator;
    }

    @Override
    public void handle(DomainEvent event) {
        moneyCreatedEvent(event);
    }

    private void moneyCreatedEvent(DomainEvent event) {
        if (event instanceof MoneyCreatedEvent moneyCreatedEvent) {
            Lottos lottos = fortuneMachineService.getLotto(moneyCreatedEvent.getMoney());
            eventOrchestrator.register(moneyCreatedEvent);
            eventPublisher.publish(new LottosCreatedEvent(lottos));
        }
    }
}
