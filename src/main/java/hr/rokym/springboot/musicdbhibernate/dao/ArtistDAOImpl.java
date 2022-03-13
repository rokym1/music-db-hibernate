package hr.rokym.springboot.musicdbhibernate.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import hr.rokym.springboot.musicdbhibernate.entity.Artist;

@Repository
public class ArtistDAOImpl implements ArtistDAO {

	private EntityManager entityManager;
	
	@Autowired
	public ArtistDAOImpl(EntityManager theEntityManager) {
	
		entityManager = theEntityManager;
	}
	
	@Override
	@Transactional
	public List<Artist> findAll() {
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query<Artist> theQuery = currentSession.createQuery("from Artist", Artist.class);
		
		List<Artist> artists = theQuery.getResultList();
		
		return artists;
	}

}
