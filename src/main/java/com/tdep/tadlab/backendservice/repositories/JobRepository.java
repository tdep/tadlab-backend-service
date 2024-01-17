package com.tdep.tadlab.backendservice.repositories;

import com.tdep.tadlab.backendservice.models.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRepository extends JpaRepository<Job, Long> {

}
