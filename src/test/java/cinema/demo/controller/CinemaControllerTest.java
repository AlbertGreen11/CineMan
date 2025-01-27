package cinema.demo.controller;

import cinema.demo.service.CinemaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class CinemaControllerTest {

    private MockMvc mockMvc;
    private CinemaService cinemaService;

    @BeforeEach
    void setUp() {
        cinemaService = Mockito.mock(CinemaService.class);
        CinemaController cinemaController = new CinemaController(cinemaService);
        mockMvc = MockMvcBuilders.standaloneSetup(cinemaController).build();
    }

    @Test
    void testGetCinemasByCity_ReturnsCinemas() throws Exception {
        // Arrange
        String city = "Warsaw";
        List<String> cinemas = Arrays.asList("Cinema City", "Multikino", "Helios");
        when(cinemaService.getCinemasByCity(city)).thenReturn(cinemas);

        // Act & Assert
        mockMvc.perform(get("/api/cinemas/{city}", city)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$[0]").value("Cinema City"))
                .andExpect(jsonPath("$[1]").value("Multikino"))
                .andExpect(jsonPath("$[2]").value("Helios"));
    }

    @Test
    void testGetAllCities_ReturnsCities() throws Exception {
        // Arrange
        List<String> cities = Arrays.asList("Warsaw", "Krakow", "Gdansk");
        when(cinemaService.getAllCities()).thenReturn(cities);

        // Act & Assert
        mockMvc.perform(get("/api/cinemas/cities")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$[0]").value("Warsaw"))
                .andExpect(jsonPath("$[1]").value("Krakow"))
                .andExpect(jsonPath("$[2]").value("Gdansk"));
    }

    @Test
    void testGetCinemasByCity_ReturnsEmptyList() throws Exception {
        // Arrange
        String city = "UnknownCity";
        when(cinemaService.getCinemasByCity(city)).thenReturn(Arrays.asList());

        // Act & Assert
        mockMvc.perform(get("/api/cinemas/{city}", city)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isEmpty());
    }

    @Test
    void testGetAllCities_ReturnsEmptyList() throws Exception {
        // Arrange
        when(cinemaService.getAllCities()).thenReturn(Arrays.asList());

        // Act & Assert
        mockMvc.perform(get("/api/cinemas/cities")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isEmpty());
    }
}
