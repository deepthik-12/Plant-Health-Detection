package com.planthealthbackend.planthealthbackend.repository;

import com.planthealthbackend.planthealthbackend.model.Alert;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlertRepository extends JpaRepository<Alert, Long> {

}
