package EX2;

public class Employee extends Person {
    public static final double DEFAULT_BASE_INCOME = 2000;
    public static final double DEFAULT_OVERTIME_ALLOWANCE = 5;

    private double baseIncome;
    private double overtimeAllowance;

    public Employee(String name, int ssn, double baseIncome, double overtimeAllowance) {
        super(name, ssn);
        this.setBaseIncome(baseIncome);
        this.setOvertimeAllowance(overtimeAllowance);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "baseIncome=" + baseIncome +
                ", overtimeAllowance=" + overtimeAllowance +
                "} " + super.toString();
    }

    @Override
    public double computeMoney() {
        return this.baseIncome * (1 + this.overtimeAllowance / 100);
    }

    public double getBaseIncome() {
        return baseIncome;
    }

    public void setBaseIncome(double baseIncome) {
        if (baseIncome < 1600 || baseIncome > 10000) {
            System.out.printf("[WARNING] baseIncome for employee with id %s out of bounds. Setting to default value (%.2f)%n", this.getId(), DEFAULT_BASE_INCOME);
            baseIncome = DEFAULT_BASE_INCOME;
        }
        this.baseIncome = baseIncome;
    }

    public double getOvertimeAllowance() {
        return overtimeAllowance;
    }

    public void setOvertimeAllowance(double overtimeAllowance) {
        if (overtimeAllowance < 0 || overtimeAllowance > 100) {
            System.out.printf("[WARNING] overtimeAllowance for employee with id %s out of bounds. Setting to default value (%.2f)%n", this.getId(), DEFAULT_OVERTIME_ALLOWANCE);
            overtimeAllowance = DEFAULT_OVERTIME_ALLOWANCE;
        }
        this.overtimeAllowance = overtimeAllowance;
    }
}
