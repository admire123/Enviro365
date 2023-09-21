package com.enviro.assessment.grad001.nhlalala.mudanisi.service;

import com.enviro.assessment.grad001.nhlalala.mudanisi.entity.InvestorInformation;
import com.enviro.assessment.grad001.nhlalala.mudanisi.entity.Products;
import com.enviro.assessment.grad001.nhlalala.mudanisi.repository.InvestorInformationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class InvestorInformationService {
    @Autowired
    InvestorInformationRepository investorInformationRepository;

    public List<InvestorInformation> findAllInvestors(){
        return (List<InvestorInformation>) investorInformationRepository.findAll();
    }

    public Optional<InvestorInformation> findById(Long id){
        return investorInformationRepository.findById(id);
    }
    
    public InvestorInformation saveInvestor(InvestorInformation investorInformation){
        return investorInformationRepository.save(investorInformation);

    }

    //Withdrawal notice method that accepts the withdrawal details
    public String withdrawalNotice(Long id, double withdrawalAmount, String productName, Date withdrawalDate, String accountNumber){

        Optional<InvestorInformation> investorInformation = investorInformationRepository.findById(id);

        Optional<Products> products = investorInformation.get().getProductsList().stream().filter(product -> product.getProductName().equalsIgnoreCase(productName)).findFirst();

        if(products != null && products.get().getProductType().equalsIgnoreCase("Retirement")) {
            if(investorInformation.get().getAge() <= 65){
                return "You need to be above 65 to withdraw on retirement product type.";
            }
        }

        if(withdrawalAmount > products.get().getBalance()){
            return "You cannot withdraw more than the balance.";
        }

        if(withdrawalAmount == (products.get().getBalance() * 0.90)){
            return "You cannot withdraw 90 percent of the balance.";
        }

        double closingBalance = products.get().getBalance()-withdrawalAmount;

        return "Withdrawal Details {" +
                "Balance before withdrawal=" + products.get().getBalance() +
                ", Amount withdrawn='" + withdrawalAmount + '\'' +
                ", Closing balance=" + closingBalance +
                '}';
    }

}
