package testModel;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import edu.westga.cs1302.lab2.model.Bill;
import edu.westga.cs1302.lab2.model.BillItem;

class TestBill {
	
	@Test
	void testConstructor() {
		Bill bill = new Bill();
		assertEquals(0, bill.getItems().size(), "new bill should have no items");
		
	}
	
	@Test
	void testTipAndTaxConstants() {
		assertEquals(0.2, Bill.TIP_RATE, 0.0001, "TIP_RATE should be 0.2");
		assertEquals(0.1, Bill.TAX_RATE, 0.0001, "TAX_RATE should be 0.1");
	}
	
	@Test
	void testAddItemNullThrows() {
		Bill bill = new Bill();
		assertThrows(IllegalArgumentException.class, () -> bill.addItem(null));
	}
	
	@Test
	void testAddItemAddsToList() {
		Bill bill = new Bill();
		BillItem burger = new BillItem("Burger", 9.99);

		bill.addItem(burger);

		assertEquals(1, bill.getItems().size(), "size should be 1 after adding one item");
	}
	
	@Test
	void testAddMultipleItems() {
		Bill bill = new Bill();
		BillItem burger = new BillItem("Burger", 9.99);
		BillItem fries = new BillItem("Fries", 3.49);
		BillItem soda = new BillItem("Soda", 1.50);

		bill.addItem(burger);
		bill.addItem(fries);
		bill.addItem(soda);

		assertEquals(3, bill.getItems().size(), "should have three items");
	}

}
