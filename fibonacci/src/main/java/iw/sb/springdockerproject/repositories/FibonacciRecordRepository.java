package iw.sb.springdockerproject.repositories;

import iw.sb.springdockerproject.domain.FibonacciRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FibonacciRecordRepository extends JpaRepository<FibonacciRecord, Long> {
}
