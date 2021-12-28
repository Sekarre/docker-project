package iw.sb.springdockerproject.services;

import iw.sb.springdockerproject.domain.FibonacciRecord;
import iw.sb.springdockerproject.dtos.FibonacciHistoryDTO;
import iw.sb.springdockerproject.repositories.FibonacciRecordRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Service
public class FibonacciService {

    private final FibonacciRecordRepository fibonacciRecordRepository;

    public Long calculateFibonacciValue(Integer n) {
        if (n <= 1) {
            saveFibonacciHistory(Long.valueOf(n), n);
            return Long.valueOf(n);
        }

        long previous = 0L, next = 1L, sum;

        for (int i = 2; i <= n; i++) {
            sum = previous;
            previous = next;
            next = sum + previous;
        }

        saveFibonacciHistory(next, n);
        return next;
    }

    public List<FibonacciHistoryDTO> getFibonacciValueHistory() {
        PageRequest pageRequest = PageRequest.of(0, 10, Sort.by("id").descending());

        return fibonacciRecordRepository.findAll(pageRequest).getContent().stream()
                .map(record -> FibonacciHistoryDTO.builder()
                        .n(record.getN())
                        .result(record.getResult())
                        .build())
                .collect(Collectors.toList());
    }

    private void saveFibonacciHistory(Long value, Integer n) {
        fibonacciRecordRepository.save(FibonacciRecord.builder()
                .n(n)
                .result(value)
                .build());
    }
}
