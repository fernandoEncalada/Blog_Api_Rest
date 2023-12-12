package com.blog.crudblogrestApi.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class Backup {

    @Value("${spring.datasource.username}")
    private String dbUsername;

    @Value("${spring.datasource.password}")
    private String dbPassword;

    @Value("${spring.datasource.url}")
    private String dbUrl;

    private boolean backupExecutedToday = false;

    @Scheduled(fixedRate = 1000 * 60 * 60 * 24) // Run every 24 hours
    public void performDailyBackup() {
        if (!backupExecutedToday) {
            performBackup();
            backupExecutedToday = true;
        }
    }

    public void performBackup() {
        // Generate a timestamp for the unique filename
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        String timestamp = dateFormat.format(new Date());

        // Construct the unique filename with timestamp
        String backupFileName = "backup_" + timestamp + ".sql";
        // Execute the backup process
        try {
            ProcessBuilder processBuilder = new ProcessBuilder(
                    "mysqldump",
                    "--user=" + dbUsername,
                    "--password=" + dbPassword,
                    "--host=" + dbUrl,
                    "blog_spring_boot",
                    "--result-file=/home/user/Desktop/" + backupFileName
            );

            processBuilder.start();
            // Add appropriate error handling and logging here
        } catch (Exception e) {
            e.printStackTrace(); // Handle exceptions appropriately
        }
    }

}
