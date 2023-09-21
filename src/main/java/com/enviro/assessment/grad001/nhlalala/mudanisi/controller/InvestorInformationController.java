package com.enviro.assessment.grad001.nhlalala.mudanisi.controller;

import com.enviro.assessment.grad001.nhlalala.mudanisi.entity.InvestorInformation;
import com.enviro.assessment.grad001.nhlalala.mudanisi.repository.InvestorInformationRepository;
import com.enviro.assessment.grad001.nhlalala.mudanisi.service.InvestorInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/investor/api")
public class InvestorInformationController {

    @Autowired
    private InvestorInformationService investorInformationService;

    /*
    The below GET API returns the investor together with all products linked to the investor.
    */
    @GetMapping("/findbyid/{id}")
    public ResponseEntity<InvestorInformation> findInvestorById(@PathVariable Long id) {
        Optional<InvestorInformation> investorInformation = investorInformationService.findById(id);

        if(investorInformation.isPresent()) {
            return ResponseEntity.ok().body(investorInformation.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /*
    The below GET API returns ALL investors together with ALL products linked to the investors.
     */
    @GetMapping("/findall")
    public List<InvestorInformation> findAllInvestors(){
        return investorInformationService.findAllInvestors();
    }


    /*
    This POST API add/save investors to the database.
     */
    @PostMapping("/save")
    public InvestorInformation saveInvestor(@Validated @RequestBody InvestorInformation investor) {
        return investorInformationService.saveInvestor(investor);
    }

    /*
    This API validates the withdrawal notice, the implementation is in InvestorInformationService
     */
    @PostMapping("/withdrawal/{id}/{amount}/{name}/{date}/{account}")
    public String withdrawalNotice(@PathVariable Long id, @PathVariable double amount, @PathVariable String name, @PathVariable("date")  @DateTimeFormat(pattern = "yyyy-MM-dd") Date withdrawalDate, @PathVariable("account") String accountNumber){
        return investorInformationService.withdrawalNotice(id,amount,name, withdrawalDate, accountNumber);
    }

}
