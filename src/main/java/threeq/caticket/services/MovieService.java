package threeq.caticket.services;

import java.util.LinkedList;
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
    
    public List<Movie> findPartById(final int[] id) {
    	List<Movie> movieList = new LinkedList<Movie>();
    	for (int i = 0; i < id.length; i++) {
    		movieList.add(this.movieRepository.findById(id[i]));
    	}
    	return movieList;
    }
    
}
