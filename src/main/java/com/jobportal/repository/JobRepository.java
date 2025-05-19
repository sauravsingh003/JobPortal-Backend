package com.jobportal.repository;

import com.jobportal.dto.ApplicationStatus;
import com.jobportal.entity.Job;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface JobRepository extends MongoRepository<Job, Long> {
	 @Query("{ 'applicants': { $elemMatch: { 'applicantId': ?0, 'applicationStatus': ?1 } } }")
    List<Job> findByApplicantIdAndApplicationStatus(Long applicantId, ApplicationStatus applicationStatus);
	 
	 List<Job> findByPostedBy(Long postedBy); 	
}
