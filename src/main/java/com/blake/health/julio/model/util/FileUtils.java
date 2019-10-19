package com.blake.health.julio.model.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Paths;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public final class FileUtils {
    private static final Logger log = LoggerFactory.getLogger(FileUtils.class);

    private FileUtils() {
    }

    public static File zipFile(final File fileToZip) {
        String var1 = "compressed.zip";

        try {
            FileOutputStream fos = new FileOutputStream("compressed.zip");
            ZipOutputStream zipOut = new ZipOutputStream(fos);
            FileInputStream fis = new FileInputStream(fileToZip);
            ZipEntry zipEntry = new ZipEntry(fileToZip.getName());
            zipOut.putNextEntry(zipEntry);
            byte[] bytes = new byte[1024];

            int length;
            while((length = fis.read(bytes)) >= 0) {
                zipOut.write(bytes, 0, length);
            }

            zipOut.close();
            fis.close();
            fos.close();
        } catch (IOException var8) {
            log.error("Unable to create zip file", var8);
        }

        return new File("compressed.zip");
    }

    public static File createTempFile(final String classPathResource, final String prefix, final String suffix) {
        File tempFile = null;
        FileOutputStream outputStream = null;

        try {
            Resource resource = new ClassPathResource(classPathResource);
            InputStream inputStream = resource.getInputStream();
            byte[] buffer = new byte[inputStream.available()];
            inputStream.read(buffer);
            tempFile = File.createTempFile(prefix, suffix);
            tempFile.deleteOnExit();
            outputStream = new FileOutputStream(tempFile);
            outputStream.write(buffer);
        } catch (IOException var16) {
            log.error("Unable to create temp file from resource " + classPathResource, var16);
        } finally {
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException var15) {
                    log.error("Error closing outputstream", var15);
                }
            }

        }

        return tempFile;
    }

    public static File writeToFile(final File file, final String data) {
        try {
            Files.write(Paths.get(file.getAbsolutePath()), data.getBytes(), new OpenOption[0]);
        } catch (IOException var3) {
            log.error("Unable to write to file", var3);
        }

        return file;
    }
}
