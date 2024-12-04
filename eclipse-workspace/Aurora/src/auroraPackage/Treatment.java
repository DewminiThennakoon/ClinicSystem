package auroraPackage;

//Treatment class
public class Treatment {
	private String treatmentName;
	private double price;
	
	//create treatment object
	Treatment(String treatmentName, double price) {
		this.treatmentName = treatmentName;
		this.price		   = price;
	}
	//calculate price
	public double FinalAmount() {
		double tax = price * 0.025;
		return Math.round(price + tax * 10);
	}

	public String gettreatmentName() {
		return treatmentName;
	}
	public double getprice() {
		return price;
	}
	
	public String toString() {
		return treatmentName+" "+price;
	}

}
