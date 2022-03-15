package hr.rokym.springboot.musicdbhibernate.dao;

import java.util.List;

import hr.rokym.springboot.musicdbhibernate.entity.ArtistDetail;

public interface ArtistDetailDAO {
	
	public List<ArtistDetail> findAll();
	
	public ArtistDetail findById(int theId);
	
	public void save(ArtistDetail theArtistDetail);
	
	public void deleteById(int theId);

}


