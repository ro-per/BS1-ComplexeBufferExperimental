
public class Block {
	private double number;

	public Block() {
		this.number = 0;
	}

	public double getNumber() {
		return number;
	}

	public void setNumber(double number) {
		this.number = number;
	}
	 public String toString(){//overriding the toString() method  
		  return Double.toString(number);
		 }  
}
