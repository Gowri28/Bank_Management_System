package KIT.bank;

public class Account {
	private long accno;
    private String accholder;
	private double bal;
	public long getAccno() {
		return accno;
	}
	public void setAccno(long accno) {
		this.accno = accno;
	}
	public String getAccholder() {
		return accholder;
	}
	public void setAccholder(String accholder) {
		this.accholder = accholder;
	}
	public double getBal() {
		return bal;
	}
	public void setBal(double bal) {
		this.bal = bal;
	}
	public Account(long accno, String accholder, double bal) {
		super();
		this.accno = accno;
		this.accholder = accholder;
		this.bal = bal;
	}
	@Override
	public String toString() {
		return "Account [accno=" + accno + ", accholder=" + accholder + ", bal=" + bal + "]";
	}

}
