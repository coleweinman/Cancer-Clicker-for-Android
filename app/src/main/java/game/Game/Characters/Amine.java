package game.Game.Characters;

import game.Game.CharacterData;
import game.Main.Price;

public class Amine extends Character {
	
	public Amine() {
		super("Amine");
		setCellRate(CharacterData.Amine.getCellRate());
		setPrice(CharacterData.Amine.getPrice());
		setSpace(CharacterData.Amine.getSpace());
	}
}
