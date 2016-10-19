package testormg;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.rohit.order.bean.ItemIn;
import com.rohit.order.bean.OrderRequest;
import com.rohit.order.bean.OrderResponse;
import com.rohit.order.dao.ItemDao;
import com.rohit.order.model.Item;
import com.rohit.order.service.OrderServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class ServiceTest {

	@Mock
	ItemDao itemDao;

	@InjectMocks
	private OrderServiceImpl orderService;

	@Test
	public void testCreateFinalOrder() throws Exception {

		// Expected objects
		Item item = new Item();
		item.setItemCategory("A");
		item.setItemDescription("Pen");
		item.setItemPrice(100);

		OrderRequest oreq = new OrderRequest();
		List<ItemIn> lstItemIn = new ArrayList<>();

		ItemIn itemIn = new ItemIn();
		itemIn.setId(1111);
		itemIn.setQuantity(10);
		lstItemIn.add(itemIn);
		oreq.setLstItmeIn(lstItemIn);

		when(itemDao.getItemDetails(anyLong())).thenReturn(item);

		// Execute the method being tested
		OrderResponse resp = orderService.createFinalOrder(oreq);

		// Validation
		assertNotNull(resp);
		/*
		 * assertEquals(accountId, newAccount.getId()); assertEquals(name,
		 * newAccount.getName());
		 * 
		 * verify(notificationService).notifyOfNewAccount(accountId);
		 * verify(accountDAO).save(accountToSave);
		 */
	}

}