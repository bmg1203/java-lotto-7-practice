package study;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class SetTest {
    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    // 요구사항 1
    @Test
    @DisplayName("Set의 size() 메소드를 활용해 Set의 크기를 확인하는 학습 테스트")
    public void testSetSize() {
        assertEquals(3, numbers.size());
    }

    // 요구사항 2
    @ParameterizedTest
    @ValueSource(ints = {1,2,3})
    @DisplayName("Set의 contains 메소드를 활용해 1,2,3의 값이 존재하는지를 확인하는 학습 테스트")
    public void testSetValue(int index) {
        assertThat(numbers.contains(index)).isTrue();
    }
}
