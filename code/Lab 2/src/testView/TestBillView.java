package testView;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import edu.westga.cs1302.lab2.model.Bill;
import edu.westga.cs1302.lab2.model.BillItem;
import edu.westga.cs1302.lab2.view.BillView;

class TestBillView {

	@Test
	void testEmptyBillText() {
		Bill bill = new Bill();
		BillView view = new BillView();

		String expected =
			"ITEMS" + System.lineSeparator() 
			+ System.lineSeparator() 
			+ "SUBTOTAL - $0.0" 
			+ System.lineSeparator() 
			+ "TAX - $0.0" + System.lineSeparator() 
			+ "TIP - $0.0" + System.lineSeparator() 
			+ "TOTAL - $0.0";

		assertEquals(expected, view.getText(bill), "empty bill text should match exactly");
	}
	
	@Test
	void testSingleItemText() {
		Bill bill = new Bill();
		bill.addItem(new BillItem("Burger", 10.0));
		BillView view = new BillView();

		String expected = "ITEMS"
			+ System.lineSeparator()
			+ "Burger - 10.0"
			+ System.lineSeparator()
			+ System.lineSeparator()
			+ "SUBTOTAL - $10.0"
			+ System.lineSeparator()
			+ "TAX - $1.0"
			+ System.lineSeparator()
			+ "TIP - $2.0"
			+ System.lineSeparator()
			+ "TOTAL - $13.0";

		assertEquals(expected, view.getText(bill), "single item bill text should match exactly");
	}
	
	@Test
	void testThreeItemsText() {
		Bill bill = new Bill();
		bill.addItem(new BillItem("Fries", 2.5));
		bill.addItem(new BillItem("Soda", 1.5));
		bill.addItem(new BillItem("Sandwich", 6.0));
		BillView view = new BillView();

		String expected = "ITEMS"
			+ System.lineSeparator()
			+ "Fries - 2.5"
			+ System.lineSeparator()
			+ "Soda - 1.5"
			+ System.lineSeparator()
			+ "Sandwich - 6.0"
			+ System.lineSeparator()
			+ System.lineSeparator()
			+ "SUBTOTAL - $10.0"
			+ System.lineSeparator()
			+ "TAX - $1.0"
			+ System.lineSeparator()
			+ "TIP - $2.0"
			+ System.lineSeparator()
			+ "TOTAL - $13.0";

		assertEquals(expected, view.getText(bill), "three item bill text should match exactly");
	}

}
