package lotto.dto;

import java.util.List;

public record LottoResult(List<MatchingCountResult> matchingCountResults, double rate) {
}
