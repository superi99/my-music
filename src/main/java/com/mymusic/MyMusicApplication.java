package com.mymusic;

import com.mymusic.service.YoutubeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MyMusicApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(MyMusicApplication.class, args);
    }

    @Autowired
    private YoutubeService youtubeService;
    @Override
    public void run(String... args) throws Exception {
        String playlist = "https://www.youtube.com/playlist?list=PLqL07UaTSDV488783uUsbkfXW2L0d2vol";
        String output = "audio";
        youtubeService.download(playlist, output);
    }
}
