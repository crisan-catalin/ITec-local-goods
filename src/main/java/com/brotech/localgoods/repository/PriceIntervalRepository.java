package com.brotech.localgoods.repository;

import com.brotech.localgoods.model.PriceInterval;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PriceIntervalRepository extends JpaRepository<PriceInterval, Long> {
}
