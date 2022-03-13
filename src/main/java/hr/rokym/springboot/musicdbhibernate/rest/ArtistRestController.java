package hr.rokym.springboot.musicdbhibernate.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hr.rokym.springboot.musicdbhibernate.entity.Artist;
import hr.rokym.springboot.musicdbhibernate.service.ArtistService;

@RestController
@RequestMapping("/api")
public class ArtistRestController {

	private ArtistService artistService;
	
	@Autowired
	public ArtistRestController(ArtistService theArtistService) {
		artistService = theArtistService;
	}
	
	@GetMapping("/artists")
	public List<Artist> findAll() {
		return artistService.findAll();
	}
	
	@GetMapping("/artists/{artistId}")
	public Artist getArtist(@PathVariable int artistId) {
		
		Artist theArtist = artistService.findById(artistId);
		
		if (theArtist == null) {
			throw new RuntimeException("Artist not found - " + artistId);
		}
		
		return theArtist;
	}
	
	@PostMapping("/artists")
	public Artist addArtist(@RequestBody Artist theArtist) {
		
		theArtist.setId(0);
		
		artistService.save(theArtist);
		
		return theArtist;
	}
}



















