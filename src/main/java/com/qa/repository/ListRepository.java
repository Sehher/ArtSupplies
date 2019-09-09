package com.qa.repository;

import com.qa.models.MyList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ListRepository extends JpaRepository<MyList, Long> {
}
