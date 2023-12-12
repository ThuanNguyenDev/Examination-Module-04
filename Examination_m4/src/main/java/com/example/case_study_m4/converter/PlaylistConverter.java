package com.example.case_study_m4.converter;

import com.example.case_study_m4.dto.PlaylistDTO;
import com.example.case_study_m4.entity.Playlist;
import org.springframework.stereotype.Component;

@Component
public class PlaylistConverter {

    public PlaylistDTO toPlaylistDTO(Playlist playlist) {
        PlaylistDTO playlistDTO = new PlaylistDTO();
        playlistDTO.setId(playlist.getId());
        playlistDTO.setDescription(playlist.getDescription());
        return playlistDTO;
    }

    public Playlist toPlaylist(PlaylistDTO playlistDTO) {
        Playlist playlist = new Playlist();
        playlist.setId(playlistDTO.getId());
        playlist.setDescription(playlistDTO.getDescription());
        return  playlist;
    }
}
