package com.simplilearn.sportyshoes.helper;
import java.io.*;
import java.nio.file.*;

import org.springframework.web.multipart.MultipartFile;

public class FileUploadUtil {

	public static void saveFile(String uploadDir, Long id, String fileName, MultipartFile multipartFile)
			throws IOException {
		Path uploadPath = Paths.get(uploadDir);
		File file = new File(uploadDir);
		if (file.exists() && file.isDirectory()) {

		} else {
		
		Files.createDirectories(uploadPath);

		}

		if (!Files.exists(uploadPath)) {
			Files.createDirectories(uploadPath);
		}

		try (InputStream inputStream = multipartFile.getInputStream()) {
			Path filePath = uploadPath.resolve(fileName);
			Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException ioe) {
			throw new IOException("Could not save image file: " + fileName, ioe);
		}
	}
}