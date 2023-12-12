package com.example.case_study_m4.converter;

import com.example.case_study_m4.dto.response.PlaylistResponseDTO;
import com.example.case_study_m4.entity.Playlist;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PlaylistConverter {
    public PlaylistResponseDTO convertEntityToDTO (Playlist playlist) {
        PlaylistResponseDTO playlistResponseDTO = new PlaylistResponseDTO();
//        playlistResponseDTO.setId(playlist.getId());
        playlistResponseDTO.setName(playlist.getTitle());
        return playlistResponseDTO;
    }

    public List<PlaylistResponseDTO> convertEntityToDTOList (List<Playlist> playlists) {

        List<PlaylistResponseDTO> list = new ArrayList<>();
        for (Playlist playlist : playlists) {
            list.add(convertEntityToDTO(playlist));
        }
        return list;
    }
}
