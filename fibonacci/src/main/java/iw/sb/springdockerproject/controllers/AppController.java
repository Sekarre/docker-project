package iw.sb.springdockerproject.controllers;

import iw.sb.springdockerproject.dtos.FibonacciHistoryDTO;
import iw.sb.springdockerproject.dtos.FibonacciResponseDTO;
import iw.sb.springdockerproject.services.FibonacciService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/api")
public class AppController {

    private final FibonacciService fibonacciService;

    @GetMapping("/fibonacci")
    public ResponseEntity<FibonacciResponseDTO> getFibonacciValue(@RequestParam Integer n) {
        return ResponseEntity.ok(new FibonacciResponseDTO(fibonacciService.calculateFibonacciValue(n)));
    }

    @GetMapping("/fibonacci-history")
    public ResponseEntity<List<FibonacciHistoryDTO>> getFibonacciValueHistory() {
        return ResponseEntity.ok(fibonacciService.getFibonacciValueHistory());
    }
}
