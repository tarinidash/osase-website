package com.osa.se.service;

import com.osa.se.dao.FamilyRepository;
import com.osa.se.model.Family;
import org.springframework.stereotype.Service;


/**
 * Created by tarinidash on 2/28/17.
 */
@Service
public class FamilyService {

    private FamilyRepository familyRepository;

    public FamilyService(FamilyRepository familyRepository) {
        this.familyRepository = familyRepository;
    }

    public Family save(Family family) {
        return familyRepository.save(family);
    }

    public Family findOne(String familyId) {
        return familyRepository.findOne(familyId);
    }

    public Iterable<Family> findAll() {
        return familyRepository.findAll();
    }

    public boolean exists(String familyId) {
        return familyRepository.exists(familyId);
    }

    public long count() {
        return familyRepository.count();
    }

    public void delete(String familyId) {
        familyRepository.delete(familyId);
    }

    public void delete(Family family) {
        familyRepository.delete(family);
    }

    public void deleteAll() {
        familyRepository.deleteAll();
    }

}
