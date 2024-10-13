package com.arvind.runner;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.arvind.entity.CitizenPlan;
import com.arvind.repository.CitizenPlanRepository;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    private CitizenPlanRepository repo;

    @Override
    public void run(ApplicationArguments args) throws Exception {
       repo.deleteAll();
        // Cash Plan Data
        CitizenPlan c1 = new CitizenPlan();
        c1.setCitizenName("John");
        c1.setGender("Male");
        c1.setPlanName("Cash");
        c1.setPlanStatus("Approved");
        c1.setPlanStartDate(LocalDate.now());
        c1.setPlanEndDate(LocalDate.now().plusMonths(6));
        c1.setBenefitAmt(5000.00);

        CitizenPlan c2 = new CitizenPlan();
        c2.setCitizenName("Smith");
        c2.setGender("Male");
        c2.setPlanName("Cash");
        c2.setPlanStatus("Denied");
        c2.setDenialReason("Rental Income");
        

        CitizenPlan c3 = new CitizenPlan();
        c3.setCitizenName("Anna");
        c3.setGender("Female");
        c3.setPlanName("Cash");
        c3.setPlanStatus("Terminated");
        c3.setPlanStartDate(LocalDate.now().minusMonths(4));
        c3.setPlanEndDate(LocalDate.now().plusMonths(2)); // Unique end date
        c3.setBenefitAmt(7000.00); // Unique benefit amount
        c3.setTerminatedDate(LocalDate.now());
        c3.setTerminationRsn("Employed");

        CitizenPlan c4 = new CitizenPlan();
        c4.setCitizenName("Olivia");
        c4.setGender("Female");
        c4.setPlanName("Cash");
        c4.setPlanStatus("Approved");
        c4.setPlanStartDate(LocalDate.now().plusDays(1)); // Unique start date
        c4.setPlanEndDate(LocalDate.now().plusMonths(7)); // Unique end date
        c4.setBenefitAmt(8000.00); // Unique benefit amount

        CitizenPlan c5 = new CitizenPlan();
        c5.setCitizenName("David");
        c5.setGender("Male");
        c5.setPlanName("Cash");
        c5.setPlanStatus("Denied");
        c5.setDenialReason("High Income");
        

        // Employment Plan Data
        CitizenPlan c6 = new CitizenPlan();
        c6.setCitizenName("Ethan");
        c6.setGender("Male");
        c6.setPlanName("Employment");
        c6.setPlanStatus("Approved");
        c6.setPlanStartDate(LocalDate.now());
        c6.setPlanEndDate(LocalDate.now().plusMonths(12));
        c6.setBenefitAmt(7000.00); // Unique benefit amount

        CitizenPlan c7 = new CitizenPlan();
        c7.setCitizenName("Alice");
        c7.setGender("Female");
        c7.setPlanName("Employment");
        c7.setPlanStatus("Denied");
        c7.setDenialReason("Investment Income");
       

        CitizenPlan c8 = new CitizenPlan();
        c8.setCitizenName("Michael");
        c8.setGender("Male");
        c8.setPlanName("Employment");
        c8.setPlanStatus("Terminated");
        c8.setPlanStartDate(LocalDate.now().minusMonths(2));
        c8.setPlanEndDate(LocalDate.now().plusMonths(4));
        c8.setBenefitAmt(6500.00);
        c8.setTerminatedDate(LocalDate.now());
        c8.setTerminationRsn("Left the Country");

        CitizenPlan c9 = new CitizenPlan();
        c9.setCitizenName("Sophia");
        c9.setGender("Female");
        c9.setPlanName("Employment");
        c9.setPlanStatus("Approved");
        c9.setPlanStartDate(LocalDate.now().minusMonths(1));
        c9.setPlanEndDate(LocalDate.now().plusMonths(8));
        c9.setBenefitAmt(8000.00); // Unique benefit amount

        CitizenPlan c10 = new CitizenPlan();
        c10.setCitizenName("James");
        c10.setGender("Male");
        c10.setPlanName("Employment");
        c10.setPlanStatus("Denied");
        c10.setDenialReason("Excessive Assets");
       

        // Food Plan Data
        CitizenPlan c11 = new CitizenPlan();
        c11.setCitizenName("Fiona");
        c11.setGender("Female");
        c11.setPlanName("Food");
        c11.setPlanStatus("Approved");
        c11.setPlanStartDate(LocalDate.now());
        c11.setPlanEndDate(LocalDate.now().plusMonths(6));
        c11.setBenefitAmt(4000.00); // Unique benefit amount

        CitizenPlan c12 = new CitizenPlan();
        c12.setCitizenName("Bob");
        c12.setGender("Male");
        c12.setPlanName("Food");
        c12.setPlanStatus("Denied");
        c12.setDenialReason("High Income");
        
        CitizenPlan c13 = new CitizenPlan();
        c13.setCitizenName("Carol");
        c13.setGender("Female");
        c13.setPlanName("Food");
        c13.setPlanStatus("Terminated");
        c13.setPlanStartDate(LocalDate.now().minusMonths(3));
        c13.setPlanEndDate(LocalDate.now().plusMonths(3));
        c13.setBenefitAmt(4500.00); // Unique benefit amount
        c13.setTerminatedDate(LocalDate.now());
        c13.setTerminationRsn("Employed");

        CitizenPlan c14 = new CitizenPlan();
        c14.setCitizenName("Daniel");
        c14.setGender("Male");
        c14.setPlanName("Food");
        c14.setPlanStatus("Approved");
        c14.setPlanStartDate(LocalDate.now());
        c14.setPlanEndDate(LocalDate.now().plusMonths(4));
        c14.setBenefitAmt(4200.00); // Unique benefit amount

        CitizenPlan c15 = new CitizenPlan();
        c15.setCitizenName("Eve");
        c15.setGender("Female");
        c15.setPlanName("Food");
        c15.setPlanStatus("Denied");
        c15.setDenialReason("Sufficient Income");
       

        // Medical Plan Data
        CitizenPlan c16 = new CitizenPlan();
        c16.setCitizenName("Alex");
        c16.setGender("Male");
        c16.setPlanName("Medical");
        c16.setPlanStatus("Approved");
        c16.setPlanStartDate(LocalDate.now());
        c16.setPlanEndDate(LocalDate.now().plusMonths(6));
        c16.setBenefitAmt(8000.00); // Unique benefit amount

        CitizenPlan c17 = new CitizenPlan();
        c17.setCitizenName("Lucy");
        c17.setGender("Female");
        c17.setPlanName("Medical");
        c17.setPlanStatus("Denied");
        c17.setDenialReason("Ineligible");
       

        CitizenPlan c18 = new CitizenPlan();
        c18.setCitizenName("Mark");
        c18.setGender("Male");
        c18.setPlanName("Medical");
        c18.setPlanStatus("Terminated");
        c18.setPlanStartDate(LocalDate.now().minusMonths(5));
        c18.setPlanEndDate(LocalDate.now().plusMonths(3));
        c18.setBenefitAmt(6500.00); // Unique benefit amount
        c18.setTerminatedDate(LocalDate.now().minusMonths(1));
        c18.setTerminationRsn("Non-payment");

        CitizenPlan c19 = new CitizenPlan();
        c19.setCitizenName("Sophie");
        c19.setGender("Female");
        c19.setPlanName("Medical");
        c19.setPlanStatus("Approved");
        c19.setPlanStartDate(LocalDate.now().minusMonths(3));
        c19.setPlanEndDate(LocalDate.now().plusMonths(6));
        c19.setBenefitAmt(9000.00); // Unique benefit amount

        CitizenPlan c20 = new CitizenPlan();
        c20.setCitizenName("Brian");
        c20.setGender("Male");
        c20.setPlanName("Medical");
        c20.setPlanStatus("Approved");
        c20.setPlanStartDate(LocalDate.now());
        c20.setPlanEndDate(LocalDate.now().plusMonths(12));
        c20.setBenefitAmt(10000.00); // Unique benefit amount

        // Save all CitizenPlan instances to the repository
        List<CitizenPlan> list = Arrays.asList(c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12,c13,c14,c15,c16,c17,c18,c19,c20);
      repo.saveAll(list);
    }
}
