package com.mymusic.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class YoutubeUtils {

    public static String generateCommand(String commnad, String youtubeUrl, String outputUrl) {
        return commnad.replaceAll("#link", youtubeUrl).replaceAll("#output", outputUrl);
    }

    public static void executeCommand(String command) {
        ProcessBuilder processBuilder = new ProcessBuilder();

        // Run a command
        processBuilder.command("cmd.exe", "/c", command);

        try {

            Process process = processBuilder.start();

            StringBuilder output = new StringBuilder();

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(process.getInputStream()));

            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
                output.append(line + "\n");
            }

            int exitVal = process.waitFor();
            if (exitVal == 0) {
                System.out.println("Success!");
                System.exit(0);
            } else {
                //abnormal...
            }

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void download(String youtubeUrl, String outputUrl) {
        //download info
        executeCommand(generateCommand(Constant.INFO_COMMAND, youtubeUrl, outputUrl));
        //download audio
        executeCommand(generateCommand(Constant.AUDIO_COMMAND, youtubeUrl, outputUrl));
        //download thumbnail
        executeCommand(generateCommand(Constant.THUMBNAILS_COMMAND, youtubeUrl, outputUrl));

    }
}
