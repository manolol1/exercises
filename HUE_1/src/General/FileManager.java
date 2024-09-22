package General;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;

import static General.Constants.APP_DIRECTORY;
import static General.Constants.BOARDS_DIRECTORY;

public class FileManager {
    public static void setup(boolean log) throws IOException{
        // make sure that the app directory exists, if not create it
        if (!APP_DIRECTORY.exists()) {
            if (log) System.out.println("App directory was not found. The app directory is used to store application data like board files.");
            if (APP_DIRECTORY.mkdir()) {
                if (log) System.out.println("Application directory created at: " + APP_DIRECTORY.getAbsolutePath());
            } else {
                throw new IOException("Failed to create app directory at: " + APP_DIRECTORY.getAbsolutePath());
            }
        }

        // make sure that the boards directory exists, if not create it
        if (!BOARDS_DIRECTORY.exists()) {
            if (log) System.out.println("Boards directory was not found. The boards directory is used to store board template files that can be loaded in the game.");
            if (BOARDS_DIRECTORY.mkdir()) {
                if (log) System.out.println("Boards directory created at: " + BOARDS_DIRECTORY.getAbsolutePath());
            } else {
                throw new IOException("Failed to create boards directory at: " + BOARDS_DIRECTORY.getAbsolutePath());
            }
        }

        // copy all predefined template board files to the boards directory
        if (log) System.out.println("Copying template boards to the boards directory...");
        Utils.copyFolderFromResources("/templates", BOARDS_DIRECTORY);
        System.out.println("Done!");
    }

    /** Read all board files inside the BOARDS_DIRECTORY and it's subdirectories
     * @return ArrayList with the Files
     */
    public static ArrayList<File> getBoardFiles() throws IOException {
        ArrayList<File> files = new ArrayList<>();

        // walk through all directories and get their files
        try (var paths = Files.walk(BOARDS_DIRECTORY.toPath())) {
            paths.filter(Files::isRegularFile).forEach(path -> files.add(path.toFile()));
        } catch (IOException e) {
            throw new IOException(e);
        }

        return files;
    }
}
