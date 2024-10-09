package pokemon_project;

public class Coin {
	private int quantity;
	
	public Coin( int q) {
		quantity = q;
	}
	public void setQuantity(int q) {
		quantity = q;
	}
	public int getQuantity() {
		return quantity;
	}
	public String toShowCoinInserted() {
		return String.format("%d coin(s) has been inserted.", quantity);
	}

}
