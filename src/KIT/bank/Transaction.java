package KIT.bank;
import java.time.LocalDateTime;

public class Transaction {
	private int tid;
	private long accno;
	private double amount;
	private String type;
	private LocalDateTime date;
	
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public long getAccno() {
		return accno;
	}
	public void setAccno(long accno) {
		this.accno = accno;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public LocalDateTime getDate() {
		return date;
	}
	public void setDate(LocalDateTime date) {
		this.date = date;
	}
	public Transaction(int tid, long accno, double amount, String type, LocalDateTime date) {
		super();
		this.tid = tid;
		this.accno = accno;
		this.amount = amount;
		this.type = type;
		this.date = date;
	}
	@Override
	public String toString() {
		return "Transection [tid=" + tid + ", accno=" + accno + ", amount=" + amount + ", type=" + type + ", date="
				+ date + "]";
	}
	
	
}
