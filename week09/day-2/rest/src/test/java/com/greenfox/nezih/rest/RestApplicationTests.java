package com.greenfox.nezih.rest;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.nio.charset.Charset;

import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;


@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
@EnableWebMvc
public class RestApplicationTests {

	private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
			MediaType.APPLICATION_JSON.getSubtype(),
			Charset.forName("utf8"));

	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext webApplicationContext;

	@Before
	public void setup() throws Exception {
		this.mockMvc = webAppContextSetup(webApplicationContext).build();
	}
	@Test
	public void testDoubling() throws Exception {
		mockMvc.perform(get("/doubling?input=15"))
				.andExpect(status().isOk())
				.andExpect(content().contentType(contentType))
				.andExpect(jsonPath("$.received", is(15)))
				.andExpect(jsonPath("$.result", is(30)));
	}
	@Test
	public void testDoubling2() throws Exception {
		mockMvc.perform(get("/doubling"))
				.andExpect(status().isOk())
				.andExpect(content().contentType(contentType))
				.andExpect(jsonPath("$.error", is("Please provide an input!")));
	}
	@Test
	public void testGreeting() throws Exception {
		mockMvc.perform(get("/greeter?name=Petike&title=student"))
				.andExpect(status().isOk())
				.andExpect(content().contentType(contentType))
				.andExpect(jsonPath("$.welcome_message", is("Oh, hi there Petike, my dear student!")));
	}
	@Test
	public void testGreetingError() throws Exception {
		mockMvc.perform(get("/greeter"))
				.andExpect(status().isOk())
				.andExpect(content().contentType(contentType))
				.andExpect(jsonPath("$.error", is("Please provide a name!")));
	}
	@Test
	public void testAppend() throws Exception {
		mockMvc.perform(get("/appenda/kuty"))
//				.contentType(MediaType.APPLICATION_JSON)
//				.content("{\"received\": \"15\", \"result\": \"30\"}"))
				.andExpect(status().isOk())
				.andExpect(content().contentType(contentType))
				.andExpect(jsonPath("$.appended", is("kutya")));
//				.andExpect(jsonPath("$.result", is(30)));
	}
	@Test
	public void testDountilSum() throws Exception {
		mockMvc.perform(post("/dountil/sum")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{\"until\": 5}"))
				.andExpect(status().isOk())
				.andExpect(content().contentType(contentType))
				.andExpect(jsonPath("$.result", is(15)));
	}
	@Test
	public void testDountilFactor() throws Exception {
		mockMvc.perform(post("/dountil/factor")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{\"until\": 5}"))
				.andExpect(status().isOk())
				.andExpect(content().contentType(contentType))
				.andExpect(jsonPath("$.result", is(120)));
	}
	@Test
	public void testArraySum() throws Exception {
		mockMvc.perform(post("/arrays/sum")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{\"numbers\": [1,2,5,10]}"))
				.andExpect(status().isOk())
				.andExpect(content().contentType(contentType))
				.andExpect(jsonPath("$.result", is(18)));
	}
	@Test
	public void testArrayMultiply() throws Exception {
		mockMvc.perform(post("/arrays/multiply")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{\"numbers\": [1,2,5,10]}"))
				.andExpect(status().isOk())
				.andExpect(content().contentType(contentType))
				.andExpect(jsonPath("$.result", is(100)));
	}
}
