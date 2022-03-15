package hr.rokym.springboot.musicdbhibernate.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import hr.rokym.springboot.musicdbhibernate.entity.Album;

@Repository
public class AlbumDAOImpl implements AlbumDAO {

	private EntityManager entityManager;
	
	@Autowired
	public AlbumDAOImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	@Override
	public List<Album> findAll() {
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query<Album> query = currentSession.createQuery("from Album", Album.class);
		
		List<Album> albums = query.getResultList();
		
		return albums;
	}

	@Override
	public Album findById(int theId) {
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		Album album = currentSession.get(Album.class, theId);
		
		return album;
	}

	@Override
	public void save(Album album) {
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		currentSession.saveOrUpdate(album);
	}

	@Override
	public void deleteById(int theId) {

		Session currentSession = entityManager.unwrap(Session.class);
		
		@SuppressWarnings("rawtypes")
		Query theQuery = currentSession.createQuery("delete from Album where id=:albumId");
		
		theQuery.setParameter("albumId", theId);
		
		theQuery.executeUpdate();

	}

}













