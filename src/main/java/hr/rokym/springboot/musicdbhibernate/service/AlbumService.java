package hr.rokym.springboot.musicdbhibernate.service;

import java.util.List;

import hr.rokym.springboot.musicdbhibernate.entity.Album;

public interface AlbumService {

	public List<Album> findAll();
	
	public Album findById(int theId);
	
	public void save(Album album);
	
	public void deleteById(int theId);
}

