package com.akashah.lookify.controllers;

import java.util.ArrayList;

import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


import com.akashah.lookify.models.Song;
import com.akashah.lookify.services.SongList;


@Controller
public class LookifyController {
	
		SongList songList;
		
		public LookifyController(SongList songList) {
			this.songList = songList;
		}
		
		@RequestMapping("/dashboard")
		public String displayDash(Model model) {
			model.addAttribute("songList", songList.allSongs());
			return "dashboard.jsp";
		}
		
		@RequestMapping("/songs/new")
		public String newSong(Model model, @ModelAttribute("song") Song song, BindingResult result) {
			return "addSong.jsp";
		}
		
		@PostMapping("/songs/add")
		public String addSong(Model model, @ModelAttribute("song") Song song, BindingResult result) {
			if (result.hasErrors()) {
				return "addSong.jsp";
			}
			
			else {
				songList.addSong(song);
				return "redirect:/dashboard";
			}
		}
		@RequestMapping("/songs/{id}")
		public String getSong(Model model, @PathVariable("id") Long id){
			Song song = songList.findSong(id);
			model.addAttribute("song", song);
			return "songInfo.jsp";
		}
		
		@RequestMapping("/songs/delete/{id}")
		public String deleteSong(Model model, @PathVariable("id") Long id) {
			songList.removeSong(id);
			return "redirect:/dashboard";
		}
		
		@RequestMapping("/songs/search")
		public String searchSong(@RequestParam(value = "find") String find, Model model) {

			ArrayList <Song> songs = songList.filterSongs(find);
			model.addAttribute("filteredSongs", songs);
			return "filteredSongs.jsp";
		}
		
		@RequestMapping("/songs/top10")
		public String returnTop(Model model) {
			ArrayList <Song> songs = songList.topSongs();
//////			int length = songs.size();
//////			ArrayList <Song> topTen
//////			for (int i = 0; i< length; i++) {
//////				topTen.add(songs.get(i));
//////			}
////			ArrayList <Song> topTen;
			model.addAttribute("filteredSongs", songs);
			return "topSongs.jsp";
		}
}
