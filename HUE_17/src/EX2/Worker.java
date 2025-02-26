package EX2;

public class Worker extends Person {
    public static final double DEFAULT_HOURLY_WAGE = 22.22;
    public static final double DEFAULT_OVERTIME_HOURS = 160;
    private double hourlyWage;
    private double overtimeHours;

    public Worker(String name, int ssn, double hourlyWage, double overtimeHours) {
        super(name, ssn);
        this.setHourlyWage(hourlyWage);
        this.setOvertimeHours(overtimeHours);
    }

    @Override
    public String toString() {
        return "Worker{" +
                "hourlyWage=" + hourlyWage +
                ", overtimeHours=" + overtimeHours +
                "} " + super.toString();
    }

    @Override
    public double computeMoney() {
        return this.hourlyWage * overtimeHours;
    }

    public double getHourlyWage() {
        return hourlyWage;
    }

    public void setHourlyWage(double hourlyWage) {
        if (hourlyWage < 13.5 || hourlyWage > 39.9) {
            System.out.printf("[WARNING] hourlyWage for employee with id %s out of bounds. Setting to default value (%.2f)%n", this.getId(), DEFAULT_HOURLY_WAGE);
            hourlyWage = DEFAULT_HOURLY_WAGE;
        }
        this.hourlyWage = hourlyWage;
    }

    public double getOvertimeHours() {
        return overtimeHours;
    }

    public void setOvertimeHours(double overtimeHours) {
        if (overtimeHours < 0 || overtimeHours > 200) {
            System.out.printf("[WARNING] overtimeHours for employee with id %s out of bounds. Setting to default value (%.2f)%n", this.getId(), DEFAULT_OVERTIME_HOURS);
            overtimeHours= DEFAULT_OVERTIME_HOURS;
        }
        this.overtimeHours = overtimeHours;
    }
}
