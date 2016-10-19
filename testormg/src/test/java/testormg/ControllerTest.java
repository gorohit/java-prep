package testormg;

import static org.mockito.Matchers.isA;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.rohit.order.bean.ItemIn;
import com.rohit.order.bean.OrderRequest;
import com.rohit.order.bean.OrderResponse;
import com.rohit.order.controller.OrderManagementController;
import com.rohit.order.service.OrderService;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = { "classpath:**/WEB-INF/spring-config.xml" })

public class ControllerTest {

	@Mock
	private OrderService mockOrderService;

	@InjectMocks
	OrderManagementController controllerUnderTest;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		this.mockMvc = MockMvcBuilders.standaloneSetup(controllerUnderTest).build();
	}

	@Test
	public void testCreateOrder() throws Exception {

		OrderRequest oreq = new OrderRequest();
		List<ItemIn> lstItemIn = new ArrayList<>();

		ItemIn item = new ItemIn();
		item.setId(1111);
		item.setQuantity(10);
		lstItemIn.add(item);
		oreq.setLstItmeIn(lstItemIn);

		OrderResponse ores = new OrderResponse();

		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
		ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
		String requestJson = ow.writeValueAsString(oreq);

		when(mockOrderService.createFinalOrder(isA(OrderRequest.class))).thenReturn(ores);

		mockMvc.perform(post("/orders").contentType(MediaType.APPLICATION_JSON_VALUE).content(requestJson))
				.andExpect(status().isOk());
	}

}
