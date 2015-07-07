package taxPerson;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Item {
	private static final double LUXURYRATE = 1.09;
	private static final double NECESSITIEsRATE = 1.01;

	private double cost;
	private Boolean isLuxury;

	
	public Item() {
		cost = 0;
		isLuxury = false;
	}

	public void setCost(double inputCost) {

		cost = inputCost;
	}

	public double getCost() {

		return cost;
	}

	
	public void setIsLuxury(Boolean inputIsLuxury) {

		isLuxury = inputIsLuxury;
	}

	
	public Boolean getIsLuxury() {

		return isLuxury;
	}

	public double calculateCostAfterTax() {

		if (this.isLuxury) {
		
			if (this.cost * LUXURYRATE >= Double.MAX_VALUE) {
				return Double.MAX_VALUE;
			}
			return this.roundToPennies((this.cost * LUXURYRATE));
		}
		
		if (this.cost * NECESSITIEsRATE >= Double.MAX_VALUE) {
			return Double.MAX_VALUE;
		}
		return this.roundToPennies(this.cost * NECESSITIEsRATE);
	}

	
	public double roundToPennies(double input) {

		BigDecimal value = new BigDecimal(input);
		return value.setScale(2, RoundingMode.HALF_EVEN).doubleValue();
	}

}
