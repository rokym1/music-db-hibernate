package hr.rokym.springboot.musicdbhibernate.dao;

import hr.rokym.springboot.musicdbhibernate.entity.ArtistDetail;

public interface ArtistDetailDAO {
	
	public ArtistDetail findById(int theId);
	
	public void save(ArtistDetail theArtistDetail);
	
	public void deleteById(int theId);

}

