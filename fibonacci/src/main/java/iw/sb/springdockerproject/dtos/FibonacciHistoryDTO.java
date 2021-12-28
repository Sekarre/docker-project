package iw.sb.springdockerproject.dtos;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class FibonacciHistoryDTO {

    private Integer n;
    private Long result;
}
