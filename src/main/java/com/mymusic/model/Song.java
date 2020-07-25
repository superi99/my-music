package com.mymusic.model;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Song {
    private String title;
    private byte[] thumbnail;
    private byte[] audio;
}
