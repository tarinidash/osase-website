package com.osa.se.dao;

import com.osa.se.model.Family;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by tarinidash on 2/28/17.
 */
@Repository
@Transactional
public interface FamilyRepository extends CrudRepository<Family, String> {
}
