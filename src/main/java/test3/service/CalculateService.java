package test3.service;

import org.springframework.stereotype.Service;
import test3.dto.CalculateRequestDto;
import test3.dto.CalculateResponseDto;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

/**
 * Сервис для работы с запросами на вычисление
 */
@Service
public class CalculateService {

    public CalculateResponseDto calculate(CalculateRequestDto calculateRequestDto) {
        List<Integer> numbers = calculateRequestDto.getNumbers();
        List<Integer> result = new ArrayList<>();
        switch (calculateRequestDto.getOperation()) {

            case max:
                result.add(numbers.stream().mapToInt(v -> v)
                        .max().orElseThrow(NoSuchElementException::new));
                break;

            case min:
                result.add(numbers.stream().mapToInt(v -> v)
                        .min().orElseThrow(NoSuchElementException::new));
                break;

            case prime:
                result.addAll(calculatePrime(numbers));
                break;

            case median:
                result.add(calculateMedian(numbers));
                break;

            case average:
                result.add((int) (numbers.stream().mapToInt(v -> v)
                        .average().orElseThrow(NoSuchElementException::new)));
                break;
        }

        return CalculateResponseDto.builder()
                .result(result)
                .build();
    }

    private List<Integer> calculatePrime(List<Integer> numbers) {

        return numbers.stream()
                .filter(this::isPrime)
                .collect(Collectors.toList());
    }

    private Integer calculateMedian(List<Integer> numbers) {
        DoubleStream sortedAges = numbers.stream().mapToDouble(v -> v).sorted();
        double median = numbers.size() % 2 == 0 ?
                sortedAges.skip(numbers.size() / 2 - 1).limit(2).average().getAsDouble() :
                sortedAges.skip(numbers.size() / 2).findFirst().getAsDouble();
        return (int) (median);
    }

    private boolean isPrime(int n) {
        if (n == 2) {
            return true;
        } else if (n % 2 == 0) {
            return false;
        }
        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}