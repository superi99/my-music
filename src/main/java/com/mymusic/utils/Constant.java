package com.mymusic.utils;

public class Constant {
    public static final String AUDIO_COMMAND = "youtube-dl -f bestaudio -o \"#output\\title\\%(id)s.%(ext)s\" #link";
    public static final String INFO_COMMAND = "youtube-dl --skip-download --write-info-json --download-archive \"#output\\info\\information.txt\" #link";
    public static final String THUMBNAILS_COMMAND = "youtube-dl --write-thumbnail --skip-download #link -o \"#output\\thumbnail\\%(id)s.%(ext)s\"";
}
