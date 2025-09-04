package testModel;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import edu.westga.cs1302.lab2.model.BillItem;

class TestBillItem {

	@Test
	void testNullName() {
		assertThrows(IllegalArgumentException.class, 
			() -> new BillItem(null, 1.00), "null name should throw IllegalArgumentException");
	}

	@Test
	void testZeroAmount() {
		assertThrows(IllegalArgumentException.class, 
			() -> new BillItem("Water", 0.00), "zero amount should throw IllegalArgumentException");
	}

	@Test
	void testNegativeAmount() {
		assertThrows(IllegalArgumentException.class, 
			() -> new BillItem("Water", -0.01), "negative amount should throw IllegalArgumentException");
	}

	@Test
	void testValidItemName() {
		BillItem item = new BillItem("Burger", 9.99);
		assertEquals("Burger", item.getName(), "name should equal argument");
	}
	
	@Test
	void testValidItemAmount() {
		BillItem item = new BillItem("Burger", 9.99);
		assertEquals(9.99, item.getAmount(), 0.0001, "amount should equal argument");
	}

	@Test
	void testEmptyNameIsAllowed() {
		BillItem item = new BillItem("", 1.00);
		assertEquals("", item.getName(), "empty name should be stored");
		assertEquals(1.00, item.getAmount(), 0.0001, "amount should equal argument");
	}

}
