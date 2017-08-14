package game.Game.Characters;

import game.Game.CharacterData;
import game.Game.Operations.Operation;
import game.Main.Price;

public class Alex extends Character {
	
	public Alex() {
		super("Alex");
		setPrice(CharacterData.Alex.getPrice());
		setSpace(CharacterData.Alex.getSpace());
	}
	
	@Override
	public void action() {
		
	}
}
