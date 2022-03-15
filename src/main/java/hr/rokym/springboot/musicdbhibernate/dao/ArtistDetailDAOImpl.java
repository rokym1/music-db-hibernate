package hr.rokym.springboot.musicdbhibernate.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import hr.rokym.springboot.musicdbhibernate.entity.ArtistDetail;

@Repository
public class ArtistDetailDAOImpl implements ArtistDetailDAO {
	
	private EntityManager entityManager;
	
	@Autowired
	public ArtistDetailDAOImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}
	
	@Override
	public List<ArtistDetail> findAll() {
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query<ArtistDetail> query = currentSession.createQuery("from ArtistDetail", ArtistDetail.class);
		
		List<ArtistDetail> details = query.getResultList();
		
		return details;
	}
	
	@Override
	public ArtistDetail findById(int theId) {
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		ArtistDetail theArtistDetail = currentSession.get(ArtistDetail.class, theId);
		
		
		return theArtistDetail;
	}

	@Override
	public void save(ArtistDetail theArtistDetail) {

		Session currentSession = entityManager.unwrap(Session.class);
		
		currentSession.saveOrUpdate(theArtistDetail);
		
	}

	@Override
	public void deleteById(int theId) {
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		@SuppressWarnings("rawtypes")
		Query theQuery = 
				currentSession.createNamedQuery("delete from ArtistDetail where id=:artistDetailId");
		
		theQuery.setParameter("artistDetailId", theId);
		
		theQuery.executeUpdate();

	}


}






