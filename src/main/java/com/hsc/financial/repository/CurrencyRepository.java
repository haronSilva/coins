package com.hsc.financial.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hsc.financial.model.Currency;

@Repository
public interface CurrencyRepository extends JpaRepository<Currency, Integer> {

}
