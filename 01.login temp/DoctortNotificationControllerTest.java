package com.technoidentity.agastya;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
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
public class DoctortNotificationControllerTest {
	
	@Autowired
	private MockMvc mvc;

	@Test
	@Order(1)
	public void getCurrentNotificationForDoctor1() throws Exception {

		MvcResult result = mvc.perform(post("/doctor")
				.header("Content-Type", "application/json")
				.content("{\"phoneNo\":\"7415520049\"}"))
				.andReturn();
		
		
		MockHttpServletRequest req=result.getRequest();
		 
		MockHttpServletResponse resp = result.getResponse();
		assertNotNull(resp.getContentAsString());
		System.out.println(resp.getContentAsString());
		assertEquals(HttpStatus.OK.value(), resp.getStatus());
	}

	@Test
	@Order(2)
	public void getCurrentNotificationForDoctor2() throws Exception {

		MvcResult result = mvc.perform(post("/doctor")
				.header("Content-Type", "application/json")
				.content("{\"phoneNo\":\"7415520041\"}"))
				.andReturn();
		
		
		MockHttpServletRequest req=result.getRequest();
		 
		MockHttpServletResponse resp = result.getResponse();
		assertNotNull(resp.getContentAsString());
		System.out.println(resp.getContentAsString());
		assertEquals(HttpStatus.NO_CONTENT.value(), resp.getStatus());
	}

}
	
	
