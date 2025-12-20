package com.example.demo.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.entity.ClashRecord;
@Repository
public interface ClashRecordRepository extends JpaRepository<ClashRecord, Long> {

    List<ClashRecord> findByEventAIdOrEventBId(Long eventAId, Long eventBId);

    List<ClashRecord> findByResolvedFalse();
}
