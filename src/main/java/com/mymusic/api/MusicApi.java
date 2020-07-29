package com.mymusic.api;

import com.mymusic.model.Song;
import com.mymusic.service.YoutubeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MusicApi {
    @Autowired
    private YoutubeService youtubeService;

    @GetMapping(value = "/get-audio")
    @ResponseBody
    public List<Song> getAudio() {
        return null;
    }


}
