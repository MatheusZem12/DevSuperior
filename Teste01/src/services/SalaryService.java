package services;

import empoyee.Employee;

public class SalaryService {
    //Wrong
    private final TaxService taxService;
    private final PensionService pensionService;
    public double netSalary(Employee employee){
        return employee.getGrossSalary() - taxService.tax(employee.getGrossSalary()) - pensionService.discount(employee.getGrossSalary());
    }

    public SalaryService(TaxService taxService, PensionService pensionService) {
        this.taxService = taxService;
        this.pensionService = pensionService;
    }
}
