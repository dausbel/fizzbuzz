package com.cuban.engineer.service;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class FizzBuzzService {
    private final Predicate<Integer> isDivisibleBy3 = n -> (n % 3 == 0);
    private final Predicate<Integer> isDivisibleBy5 = n -> (n % 5 == 0);
    private final Predicate<Integer> isDivisibleBy3And5 = isDivisibleBy3.and(isDivisibleBy5);

    public FizzBuzzService() {
    }

    public List<String> fizzBuzz(int start, int end) {
        return IntStream.rangeClosed(start, end)
                .mapToObj(x -> isDivisibleBy3And5.test(x) ? "FizzBuzz" : isDivisibleBy5.test(x) ? "Buzz" : isDivisibleBy3.test(x) ? "Fizz" : String.valueOf(x))
                .collect(Collectors.toList());
    }
}
