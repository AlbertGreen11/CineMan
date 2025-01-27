package cinema.demo.service.impl;

import cinema.demo.dto.CinemaDto;
import cinema.demo.entity.Kino;
import cinema.demo.mapper.CinemaMapper;
import cinema.demo.repository.CinemaRepository;
import cinema.demo.service.CinemaService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CinemaServiceImpl implements CinemaService {
    private final CinemaRepository cinemaRepository;

    public CinemaServiceImpl(CinemaRepository cinemaRepository) {
        this.cinemaRepository = cinemaRepository;
    }

    @Override
    public List<String> getCinemasByCity(String city) {
        List<Kino> cinemas = cinemaRepository.findByMiasto(city);

        return cinemas.stream()
                .map(CinemaMapper::mapToCinemaDto)
                .map(CinemaDto::getNazwa)
                .toList();
    }

    @Override
    public List<String> getAllCities() {
        List<Kino> cinemas = cinemaRepository.findAll();

        return cinemas.stream()
                .map(CinemaMapper::mapToCinemaDto)
                .map(CinemaDto::getMiasto)
                .distinct()
                .toList();
    }
}
