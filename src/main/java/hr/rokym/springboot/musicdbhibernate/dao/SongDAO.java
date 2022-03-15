package hr.rokym.springboot.musicdbhibernate.dao;

import java.util.List;

import hr.rokym.springboot.musicdbhibernate.entity.Song;

public interface SongDAO {
	
	public List<Song> findAll();
	
	public Song findById(int id);
	
	public void save(Song song);
	
	public void deleteById(int id);
}

