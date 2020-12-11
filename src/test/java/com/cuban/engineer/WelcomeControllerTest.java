package com.cuban.engineer;

import com.cuban.engineer.service.FizzBuzzService;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;

@SpringBootTest
public class WelcomeControllerTest {

    private FizzBuzzService fizzBuzzService= Mockito.mock(FizzBuzzService.class);


    @Test
    public void main() {
        List<String> expectedList = Arrays.asList("1", "2", "Fizz");
        List<String> expectedList2 = Arrays.asList("1", "2");
        when(fizzBuzzService.fizzBuzz(1, 3)).thenReturn(expectedList);
        when(fizzBuzzService.fizzBuzz(1, 2)).thenReturn(expectedList2);

        Assertions.assertThat(fizzBuzzService.fizzBuzz(1, 3)).isNotEmpty();
        Assertions.assertThat(fizzBuzzService.fizzBuzz(1,2)).isEqualTo(expectedList2);
    }


}
