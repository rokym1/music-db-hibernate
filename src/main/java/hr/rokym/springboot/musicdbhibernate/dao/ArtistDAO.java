package hr.rokym.springboot.musicdbhibernate.dao;

import java.util.List;

import hr.rokym.springboot.musicdbhibernate.entity.Artist;

public interface ArtistDAO {

	public List<Artist> findAll();
	
	public Artist findById(int theId);
	
	public void save(Artist theArtist);
	
	public void deleteById(int theId);
}


