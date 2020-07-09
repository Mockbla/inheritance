package entities;

public class ImportedProduct extends Product {
	private Double fee;

	public ImportedProduct() {
		super();
	}
	
	
	public ImportedProduct(String name, Double price, Double fee) {
		super(name, price);
		this.fee = fee;
	}


	public Double getFee() {
		return fee;
	}


	public void setFee(Double fee) {
		this.fee = fee;
	}
	
	@Override
	public String toString() {
		return  getName()+
				" $ " +
				String.format("%.2f ",getPrice()) +
				"(Custom fee: $ " +
				getFee()+
				")";
	}
	

}
