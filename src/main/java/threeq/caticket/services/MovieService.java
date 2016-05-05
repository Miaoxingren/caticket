package threeq.caticket.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import threeq.caticket.entities.Movie;
import threeq.caticket.entities.repositories.MovieRepository;

@Service
public class MovieService {
	@Autowired
	private MovieRepository movieRepository;
	
	public MovieService() {
        super();
    }
	
	public List<Movie> findAll() {
        return this.movieRepository.findAll();
    }

    public Movie findByName(final String name) {
        return this.movieRepository.findByName(name);
    }
    
    public Movie findById(final int id) {
        return this.movieRepository.findById(id);
    }
    

}
