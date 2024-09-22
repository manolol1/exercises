package General;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Scanner;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class Utils {
    /**
     * Pause the program for a specified time.
      * @param millis Time to sleep for in milliseconds (1s = 1000 ms)
     */
    public static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    /** Ask user to input an integer
     * @param s Scanner Object
     * @param text Will be printed before waiting for input (e.g. variable name)
     * @param min Minimum value (inclusive)
     * @param max Maximum value (inclusive)
     * @return User input
     */
    public static int intInput(Scanner s, String text, int min, int max) {
        System.out.printf("%s (%d-%d): ", text, min, max);
        int input = 0;

        // Wait for user input
        try {
            input = s.nextInt();
            s.nextLine();  // Consume the leftover newline
        } catch (Exception e) {
            System.out.println("An error occurred while parsing your input. Make sure to only enter numbers! Try again!\n");
            s.nextLine(); // Consume invalid input
            return intInput(s, text, min, max);
        }

        // Check if input is inside bounds
        if (input < min || input > max) {
            System.out.printf("Input must be between %d and %d. Try again!\n\n", min, max);
            return intInput(s, text, min, max);
        }

        return input;
    }

    /** Copy a directory from the Jar file or the resources directory to the specified directory
     *  Source: GitHub Copilot
     */
    public static void copyFolderFromResources(String sourceFolder, File targetFolder) throws IOException {
        URL resource = FileManager.class.getResource(sourceFolder);
        if (resource == null) {
            throw new IOException("Resource not found: " + sourceFolder);
        }

        File newTargetFolder = new File(targetFolder, new File(sourceFolder).getName());
        if (resource.getProtocol().equals("jar")) {
            copyFolderFromJar(resource, newTargetFolder);
        } else {
            copyFolderFromFileSystem(resource, newTargetFolder);
        }
    }

    /** Copy a directory from the Jar file to the specified directory
     *  Source: GitHub Copilot
     */
    public static void copyFolderFromJar(URL resource, File targetFolder) throws IOException {
        String jarPath = resource.getPath().substring(5, resource.getPath().indexOf("!"));
        try (JarFile jarFile = new JarFile(new File(jarPath))) {
            Enumeration<JarEntry> entries = jarFile.entries();
            String sourceFolder = resource.getPath().substring(resource.getPath().indexOf("!") + 2);
            while (entries.hasMoreElements()) {
                JarEntry entry = entries.nextElement();
                if (entry.getName().startsWith(sourceFolder)) {
                    File targetFile = new File(targetFolder, entry.getName().substring(sourceFolder.length()));
                    if (entry.isDirectory()) {
                        if (!targetFile.exists() && !targetFile.mkdirs()) {
                            throw new IOException("Failed to create directory: " + targetFile.getAbsolutePath());
                        }
                    } else {
                        try (InputStream is = jarFile.getInputStream(entry)) {
                            Files.copy(is, targetFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
                        }
                    }
                }
            }
        }
    }

    /** Copy a directory from the resources directory to the specified directory
     *  Source: GitHub Copilot
     */
    public static void copyFolderFromFileSystem(URL resource, File targetFolder) throws IOException {
        try {
            Path sourcePath = Paths.get(resource.toURI());
            Files.walk(sourcePath).forEach(source -> {
                Path destination = targetFolder.toPath().resolve(sourcePath.relativize(source));
                try {
                    if (Files.isDirectory(source)) {
                        if (!Files.exists(destination)) {
                            Files.createDirectories(destination);
                        }
                    } else {
                        Files.copy(source, destination, StandardCopyOption.REPLACE_EXISTING);
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
        } catch (URISyntaxException e) {
            throw new IOException("Invalid URI syntax: " + resource, e);
        }
    }

    /** Search for a file by its name in a Files array
     * @return Found file or null, if no file was found
     */
    public static File getFileByName(String filename, ArrayList<File> files) {
        for (File file : files) {
            if (file.getName().equals(filename)) {
                return file;
            }
        }
        return null; // no matching file found
    }

    /** Read a file to a String array */
    public static String[] fileToStringArray(File file) throws FileNotFoundException {
        Scanner s = new Scanner(file);
        ArrayList<String> lines = new ArrayList<>();

        while (s.hasNextLine()) {
            lines.add(s.nextLine());
        }

        return lines.toArray(new String[0]);
    }
}
