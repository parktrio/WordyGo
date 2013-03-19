package kr.dev.parktrio.park.wordygo;

public class GameItem {
	
	private GameItemType itemType = GameItemType.GAME_ITEM_TYPE_NONE;
	
	GameItem( GameItemType itemType ) {
		this.itemType = itemType;
	}
	
	public GameItemType getItemType() {
		return itemType;
	}
}
