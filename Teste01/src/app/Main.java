package app;

import empoyee.Employee;
import services.BrazilTaxService;
import services.PensionService;
import services.SalaryService;
import services.TaxService;

public class Main {
    public static void main(String[] args) {

        Employee employee = new Employee("Matheus",4000);
        TaxService taxService= new BrazilTaxService();
        PensionService pensionService = new PensionService();
        SalaryService salaryService = new SalaryService(taxService,pensionService);
        System.out.println(salaryService.netSalary(employee));

    }
}