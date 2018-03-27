package com.akashah.lookify.services;

import java.util.*;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.akashah.lookify.models.Song;
import com.akashah.lookify.repositories.SongRepository;

@Service
public class SongList {
	
	private SongRepository songRepository;
	
	public SongList(SongRepository songRepository) {
		this.songRepository = songRepository;
	}
	
	public ArrayList <Song> allSongs() {
		return (ArrayList<Song>) songRepository.findAll();
	}
	
	public void addSong(Song song) {
		songRepository.save(song);
	}
	
	public Song findSong(Long id) {
		return songRepository.findOne(id);
	}
	
	public ArrayList <Song> filterSongs(String containing) {
		return songRepository.findByTitleContaining(containing);
	}
	
	public void removeSong(Long id) {
		songRepository.delete(id);
	}
	
	public ArrayList <Song> topSongs(){
		return (ArrayList<Song>) songRepository.findTop10ByOrderByRatingDesc();
	}
	
}
