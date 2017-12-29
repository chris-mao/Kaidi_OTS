package com.jrsoft.organization.service;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class DepartmentRestControllerTest {
	
	@Autowired  
    private MockMvc mockMvc; 

	@Test
	public void testFindAll() {
		String expectedResult = "index";
		String uri = "/departments/api/list";
		MvcResult mvcResult;
		try {
			mvcResult = mockMvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON))
					.andReturn();
			int status = mvcResult.getResponse().getStatus();
			String content = mvcResult.getResponse().getContentAsString();

			assertEquals(200, status);
			assertEquals(expectedResult, content);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testJsonData() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testFindEmployeesByDept() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testDepartmentTree() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testInsert() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testGetDepartment() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testUpdate() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testDelete() {
		fail("Not yet implemented"); // TODO
	}

}
