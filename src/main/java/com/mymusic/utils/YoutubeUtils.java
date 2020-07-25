package com.mymusic.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class YoutubeUtils {

    public static String generateCommand(String youtubeUrl, String outputUrl) {
        return Constant.COMMAND.replaceAll("#link", youtubeUrl).replaceAll("#output", outputUrl);
    }

    public static void download(String youtubeUrl, String outputUrl) {
        ProcessBuilder processBuilder = new ProcessBuilder();

        // Run a command
        processBuilder.command("cmd.exe", "/c", generateCommand(youtubeUrl, outputUrl));

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
                System.out.println(output);
                System.exit(0);
            } else {
                //abnormal...
            }

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
