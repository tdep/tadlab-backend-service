package com.tdep.tadlab.backendservice.repository;

import com.tdep.tadlab.backendservice.entity.JobEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRepository extends JpaRepository<JobEntity, Integer> {

}
