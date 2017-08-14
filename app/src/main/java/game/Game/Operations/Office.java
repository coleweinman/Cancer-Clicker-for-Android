package game.Game.Operations;

import game.Game.OperationData;

public class Office extends Operation {
	
	public Office() {
		super("Office");
		setPrice(OperationData.Office.getPrice());
		setCapacity(OperationData.Office.getSpace());
		setCellCost(OperationData.Office.getCellCost());
		setMoneyCost(OperationData.Office.getMoneyCost());
	}
}
