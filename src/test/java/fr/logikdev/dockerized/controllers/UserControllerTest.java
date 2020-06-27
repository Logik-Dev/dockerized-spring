package fr.logikdev.dockerized.controllers;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import fr.logikdev.dockerized.models.User;
import fr.logikdev.dockerized.repositories.UserRepository;

@AutoConfigureMockMvc
@SpringBootTest
class UserControllerTest {

	@MockBean
	private UserRepository userRepository;
	
	@Autowired
	MockMvc mockMvc;
	
	private User user = new User();
	
	@BeforeEach
	public void setUpBeforeEach() {
		user.setId(1);
		user.setFirstname("Cédric");
		user.setLastname("Maunier");
	}

	@Test
	void testFindById() throws Exception {
		when(userRepository.findById(1)).thenReturn(Optional.of(user));
		ResultActions result = mockMvc.perform(get("/1")).andExpect(status().isOk());
		assertOnResult(result);
	}
	
	private void assertOnResult(ResultActions result) throws Exception {
		result
		.andExpect(jsonPath("$.id").value(user.getId()))
		.andExpect(jsonPath("$.firstname").value(user.getFirstname()))
		.andExpect(jsonPath("$.lastname").value(user.getLastname()));
	}
}
