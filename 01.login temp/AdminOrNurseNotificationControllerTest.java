package com.technoidentity.agastya;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application.yml")
@TestMethodOrder(OrderAnnotation.class)
public class AdminOrNurseNotificationControllerTest {

	@Autowired
	private MockMvc mvc;

	@Test
	@Order(1)
	public void getAllNotificationForAdminAndNurse1() throws Exception {

		MvcResult result = mvc.perform(get("/admin-nurse")).andReturn();
		MockHttpServletRequest req=result.getRequest();
		 
		MockHttpServletResponse resp = result.getResponse();
		assertNotNull(resp.getContentAsString());
		System.out.println(resp.getContentAsString());
		assertEquals(HttpStatus.OK.value(), resp.getStatus());
	}
	
	
}
