package kr.dev.parktrio.park.wordygo;

public class RandomGameItem extends GameItem {

	private int index = -1;
	
	private RandomGameItem( GameItemType itemType ) {
		super( itemType );
	}
	
	public RandomGameItem( GameItemType itemType, int index ) {
		this( itemType );
		this.index = index;
	}

	public int getItemindex() {
		return index;
	}
}
