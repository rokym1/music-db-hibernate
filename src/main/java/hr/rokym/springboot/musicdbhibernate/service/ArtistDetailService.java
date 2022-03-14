package hr.rokym.springboot.musicdbhibernate.service;

import hr.rokym.springboot.musicdbhibernate.entity.ArtistDetail;

public interface ArtistDetailService {

public ArtistDetail findById(int theId);
	
	public void save(ArtistDetail theArtistDetail);
	
	public void deleteById(int theId);
}
