package com.mymusic.service;

import com.mymusic.utils.YoutubeUtils;
import org.springframework.stereotype.Service;

@Service
public class YoutubeService {
    public void download(String url, String output){
        YoutubeUtils.download(url,output);
    }
}
