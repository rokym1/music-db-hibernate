package hr.rokym.springboot.musicdbhibernate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hr.rokym.springboot.musicdbhibernate.dao.ArtistDetailDAO;
import hr.rokym.springboot.musicdbhibernate.entity.ArtistDetail;

@Service
public class ArtistDetailServiceImpl implements ArtistDetailService {

	private ArtistDetailDAO artistDetailDAO;
	
	@Autowired
	public ArtistDetailServiceImpl(ArtistDetailDAO theArtistDetailDAO) {
		artistDetailDAO = theArtistDetailDAO;
	}
	
	@Override
	@Transactional
	public ArtistDetail findById(int theId) {
		
		return artistDetailDAO.findById(theId);
	}

	@Override
	public void save(ArtistDetail theArtistDetail) {
		
		artistDetailDAO.save(theArtistDetail);

	}

	@Override
	public void deleteById(int theId) {
		
		artistDetailDAO.deleteById(theId);
	}
	
	
	

}
