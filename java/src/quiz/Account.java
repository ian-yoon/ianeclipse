package quiz;

public class Account {
	private String bankName;
	private String num;
	private String guestName;
	private long deposit;

	public Account() {
	}

	public Account(String bankName, String num, String guestName, long deposit) {
		this.bankName = bankName;
		this.num = num;
		this.guestName = guestName;
		this.deposit = deposit;
	}

	@Override
	public String toString() {
		return "예금주:" + guestName +"\n은행명:" 
	+ bankName + "\n계좌번호:" + num +  "\n잔액:" 
				+ String.format("%,d", deposit);
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getGuestName() {
		return guestName;
	}

	public void setGuestName(String guestName) {
		this.guestName = guestName;
	}

	public long getDeposit() {
		return deposit;
	}

	public void setDeposit(long deposit) {
		this.deposit = deposit;
	}

}
