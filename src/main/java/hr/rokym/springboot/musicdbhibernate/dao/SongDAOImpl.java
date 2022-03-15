package hr.rokym.springboot.musicdbhibernate.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import hr.rokym.springboot.musicdbhibernate.entity.Song;

@Repository
public class SongDAOImpl implements SongDAO {
	
	private EntityManager entityManager;
	
	@Autowired
	public SongDAOImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<Song> findAll() {
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query<Song> query = currentSession.createQuery("from Song", Song.class);
		
		List<Song> songs = query.getResultList();
		
		return songs;
	}

	@Override
	public Song findById(int id) {
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		Song song = currentSession.get(Song.class, id);
		
		return song;
	}

	@Override
	public void save(Song song) {
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		currentSession.saveOrUpdate(song);
	}

	@Override
	public void deleteById(int id) {
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		@SuppressWarnings("rawtypes")
		Query query = currentSession.createQuery("delete from Song where id=:songId");
		
		query.setParameter("songId", id);
		
		query.executeUpdate();
	}
}












