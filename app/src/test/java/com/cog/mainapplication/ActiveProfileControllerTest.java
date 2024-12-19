package com.cog.mainapplication;

import com.cog.controller.ProfileController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.core.env.Environment;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@WebMvcTest(ProfileController.class)  // Test only the controller layer
public class ActiveProfileControllerTest {

    @InjectMocks
    private ProfileController activeProfileController;

    @MockBean
    private ProfileController controller;  // Mock the controller to inject the value

    @Mock
    private Environment environment;

    private MockMvc mockMvc;

    @BeforeEach
    void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(activeProfileController).build();
    }

    @Test
    void shouldReturnActiveProfile() throws Exception {

        // Arrange: Mock the response for the active profile
        when(environment.getActiveProfiles()).thenReturn(new String[]{"dev"});

        // Act and Assert: Perform GET request and assert the response
        mockMvc.perform(get("/active-profile"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("dev"));
    }

}
