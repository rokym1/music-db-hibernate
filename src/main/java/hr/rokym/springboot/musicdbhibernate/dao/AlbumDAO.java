package hr.rokym.springboot.musicdbhibernate.dao;

import java.util.List;

import hr.rokym.springboot.musicdbhibernate.entity.Album;

public interface AlbumDAO {

	public List<Album> findAll();
	
	public Album findById(int theId);
	
	public void save(Album album);
	
	public void deleteById(int theId);
}


