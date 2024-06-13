package com.example.demo;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.assertj.MockMvcTester;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@WebMvcTest(controllers = DemoController.class)
class DemoControllerTests {

	private static final String EXPECTED_JSON = """
			{
			  "content": "Hello Jürgen"
			}""";

	@Autowired
	private MockMvc mockMvc;

	@Test
	void getJsonWithMockMvcWithStandardAssertionUseProperEncoding() throws Exception {
		this.mockMvc.perform(get("/message")).andExpect(content().json(EXPECTED_JSON));
	}

	@Test
	void getJsonWithMockMvcTesterWithStandardAssertionDoesNotUseProperEncoding()  {
		MockMvcTester mvc = MockMvcTester.create(this.mockMvc);
		assertThat(mvc.get().uri("/message")).bodyJson().isEqualTo(EXPECTED_JSON);
	}

}
