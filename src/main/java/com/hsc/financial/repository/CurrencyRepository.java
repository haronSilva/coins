package com.hsc.financial.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hsc.financial.model.Currency;

@Repository
public interface CurrencyRepository extends JpaRepository<Currency, Integer> {
	List<Currency> findByName(String name);
}
