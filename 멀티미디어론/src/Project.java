public class Project {
    private double fund;
    private double manPower;

    public Project(double fund, double manPower) {
        this.fund = fund;
        this.manPower = manPower;
    }

    public double getFund() {
        return fund;
    }

    public void setFund(double fund) {
        this.fund = fund;
    }

    public double getManPower() {
        return manPower;
    }

    public void setManPower(double manPower) {
        this.manPower = manPower;
    }
}
