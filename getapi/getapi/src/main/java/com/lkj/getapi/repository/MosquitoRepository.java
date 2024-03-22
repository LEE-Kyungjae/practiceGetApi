package com.lkj.getapi.repository;
import com.lkj.getapi.domain.Mosquito;
import com.lkj.getapi.mosquito.MosquitoStatusResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MosquitoRepository extends JpaRepository<MosquitoStatusResponse, Long> {
}
