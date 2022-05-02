package vn.t3h.class2109.utils;


import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileUtils {

    public static String PATH_IMAGE = "D:\\opt\\image\\";
    public static String saveFile(MultipartFile file) {
        File folder = new File(PATH_IMAGE);
        if (!folder.exists()) folder.mkdirs();
        Path path = Paths.get(PATH_IMAGE);
        try {
            String fileName = System.currentTimeMillis() +  file.getOriginalFilename();
            Files.copy(file.getInputStream(), path.resolve(fileName));
            return fileName;
        } catch (Exception e) {
            throw new RuntimeException("Could not store the file. Error: " + e.getMessage());
        }
    }
}
