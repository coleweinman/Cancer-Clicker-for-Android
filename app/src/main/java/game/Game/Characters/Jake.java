package game.Game.Characters;

import game.Game.CharacterData;
import game.Game.Operations.Operation;
import game.Main.Price;

public class Jake extends Character {
	
	public Jake() {
		super("Jake");
		setPrice(CharacterData.Jake.getPrice());
		setSpace(CharacterData.Jake.getSpace());
	}
	
	@Override
	public void setOperation(Operation o) {
		super.setOperation(o);
		o.setCellCost(0);
	}
}
