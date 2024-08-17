package pl.milenamrugala.animalsanctuary.util; // the package is used to group utility classes that provide common functionalities across the application

import java.nio.file.Files; // provides methods for file operations such as reading, writing, and checking file attributes
import java.nio.file.Path; // represents a file or directory path in a file system
import java.nio.file.Paths; // the Paths class contains static methods that return Path objects, typically used to obtain a Path object from a string representing a file path

// String imagePath: the parameter represents the path to the image file as a string
// Paths.get(imagePath): converts the string imagePath into a Path object using the Paths.get() method, this Path object represents the location of the image file in the file system
// Files.readAllBytes(path): reads all bytes from the file located at the path

public class ImageUtil {

    public static byte[] convertImageToByteArray(String imagePath) throws Exception {
        Path path = Paths.get(imagePath);
        return Files.readAllBytes(path);
    }

}