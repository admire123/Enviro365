package com.enviro.assessment.grad001.nhlalala.mudanisi.repository;

import com.enviro.assessment.grad001.nhlalala.mudanisi.entity.InvestorInformation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InvestorInformationRepository extends CrudRepository<InvestorInformation, Long> {


}
