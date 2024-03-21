package com.lkj.getapi.repository;
import com.lkj.getapi.domain.Mosquito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MosquitoRepository extends JpaRepository<Mosquito, Long> {
}
