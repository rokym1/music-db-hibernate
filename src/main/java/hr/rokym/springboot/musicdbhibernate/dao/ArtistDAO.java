package hr.rokym.springboot.musicdbhibernate.dao;

import java.util.List;

import hr.rokym.springboot.musicdbhibernate.entity.Artist;

public interface ArtistDAO {

	public List<Artist> findAll();
}
