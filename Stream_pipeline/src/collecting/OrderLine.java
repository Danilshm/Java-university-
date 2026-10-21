package collecting;

/**
 * A line on an order has a product id, unit cost, and a quantity ordered, e.g.
 * Baked Beans, 55p, quantity 7. The price of the order line is calculated by
 * the getCost() method.
 * @author la,lz
 */
public class OrderLine {

	//Fields
	private String id; // the identifier for the item ordered
	private int unitPrice; // price of one item in pence
	private int quantity; // the number of items ordered


	//Constructors
	/**
	 * Default constructor. Sets the id to the empty string. Price and quantity
	 * are zero.
	 */
	public OrderLine() {
		this.id = "";
		this.unitPrice = 0;
		this.quantity = 0;
	}

	/**
	 * Constructs an OrderLine with the given id for the item ordered. 
	 * Price and quantity are zero.
	 * @param id The identifier for the item ordered.
	 */
	public OrderLine(String id) {
		this.id = id;
		this.unitPrice = 0;
		this.quantity = 0;
	}

	/**
	 * Constructs an OrderLine with the given values for id, unit price and
	 * quantity ordered.
	 * @param id The identifier for the item ordered.
	 * @param unitPrice The price of the item in pence.
	 * @param quantity The number of items to be ordered.
	 */
	public OrderLine(String id, int unitPrice, int quantity) {
		this.id = id;
		this.unitPrice = unitPrice;
		this.quantity = quantity;
	}

	/** Sets the item id to the given value. 
	 * @param id The identifier for the item ordered. */
	public void setId(String id) {
		this.id = id;
	}

	/** Sets the unit price to the given value. 
	 * @param unitPrice The price of the item in pence. */
	public void setUnitPrice(int unitPrice) {
		this.unitPrice = unitPrice;
	}

	/** Sets the quantity ordered to the given value. 
	 * @param quantity The number of items to be ordered.*/
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	/** Returns the identifier for the items ordered. 
	 * @return The identifier of the item. */
	public String getId() {
		return id;
	}

	/** Returns the price of one item. 
	 * @return The unit price of the item. */
	public int getUnitPrice() {
		return unitPrice;
	}

	/** Returns the number of items ordered. 
	 * @return The quantity of the item. */
	public int getQuantity() {
		return quantity;
	}

	/** Calculates and returns the cost of the OrderLine. 
	 * Cost is unit price * quantity ordered.
	 * @return The cost of the order based on unit price * quantity.
	 */
	public int getCost() {
		return unitPrice * quantity;
	}

	/** Returns a textual representation of the OrderLine. 
	 * @return A textual representation of the order. */
	public String toString() {
		return "OrderLine:[id=" + id + ", unitPrice=" + unitPrice 
				+ ", quantity=" + quantity + "]";
	}
	
	/** Compares this OrderLine to the specified object. The result is true if and 
	 * only if the argument is not null and is an OrderLine object that has the same
	 * state as this object.
	 * 
	 * @param obj the object to compare this OrderLine against.
	 * 
	 * @return true if the given object represents an OrderLine equivalent to this order, false otherwise.
	 */
	@Override
	public boolean equals(Object obj) {
		return (obj instanceof OrderLine other)
				&& this.id.equals(other.id)
				&& this.unitPrice == other.unitPrice
				&& this.quantity == other.quantity;
	}

}
