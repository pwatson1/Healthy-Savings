package com.healthlysavings.api.repository;

import com.healthlysavings.api.domain.Finance;
import com.healthlysavings.api.domain.FitbitData;
import com.sun.tools.javac.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Doc on 3/15/16.
 */
public interface FinanceDAO extends CrudRepository<Finance, Long> {

    ArrayList<Finance> findByUserId(long userID);

    Finance findByUserIdAndDate(long userID, java.sql.Date date);





}
