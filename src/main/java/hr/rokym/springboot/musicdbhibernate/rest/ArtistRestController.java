package hr.rokym.springboot.musicdbhibernate.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hr.rokym.springboot.musicdbhibernate.dao.ArtistDAO;
import hr.rokym.springboot.musicdbhibernate.entity.Artist;

@RestController
@RequestMapping("/api")
public class ArtistRestController {

	private ArtistDAO artistDAO;
	
	@Autowired
	public ArtistRestController(ArtistDAO theArtistDAO) {
		artistDAO = theArtistDAO;
	}
	
	@GetMapping("/artists")
	public List<Artist> findAll() {
		return artistDAO.findAll();
	}
}

