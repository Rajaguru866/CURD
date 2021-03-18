package demo;

public class DetailModel {

	public String name;
	public String address;
	public int amount;
	public long mobno;
	public DetailModel(String name, String address, int amount, long mobno) {
		super();
		this.name = name;
		this.address = address;
		this.amount = amount;
		this.mobno = mobno;
	}
	public DetailModel() {
		super();
	}
	@Override
	public String toString() {
		return "DetailModel [name=" + name + ", address=" + address + ", amount=" + amount + ", mobno=" + mobno + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public long getMobno() {
		return mobno;
	}
	public void setMobno(long mobno) {
		this.mobno = mobno;
	}
}
