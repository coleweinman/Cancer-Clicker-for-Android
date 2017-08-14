package game.Game.Characters;

import game.Game.CharacterData;
import game.Main.Price;

public class Daniel extends Character{
	
	public Daniel() {
		super("Daniel");
		setCellRate(CharacterData.Daniel.getCellRate());
		setPrice(CharacterData.Daniel.getPrice());
		setSpace(CharacterData.Daniel.getSpace());
	}
}
