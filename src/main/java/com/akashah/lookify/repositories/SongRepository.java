package com.akashah.lookify.repositories;

import java.util.*;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.*;

import com.akashah.lookify.models.Song;

@Repository
public interface SongRepository extends CrudRepository <Song, Long> {
	ArrayList <Song> findByTitleContaining(String search);
	
	ArrayList <Song> findTop10ByOrderByRatingDesc();
}
