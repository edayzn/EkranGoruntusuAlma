package sample;

import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import javafx.event.ActionEvent;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class Controller {

    public Label helloWord;

    @FXML
    public ImageView imageView;
    BufferedImage image;

    public void screenImage(ActionEvent actionEvent) {
        try {
            image = new Robot().createScreenCapture(new Rectangle(0, 0, 800, 800));
        } catch (AWTException e) {
            e.printStackTrace();
            return;
        }
        WritableImage images = SwingFXUtils.toFXImage(image, null);
        imageView.setImage(images);
    }
    public void saveResim(ActionEvent actionEvent) {

        WritableImage images = SwingFXUtils.toFXImage(image, null);
        imageView.setImage(images);
        saveToFile(images);
    }

    public static void saveToFile(WritableImage image) {
        String imageName = "image";
        String location = "C:\\Users\\EDA YZN\\Desktop\\resimlerrr\\";
        File outputFile = new File(fileName(location + imageName, 0));

        BufferedImage bImage = SwingFXUtils.fromFXImage(image, null);
        try {
            ImageIO.write(bImage, "png", outputFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static String fileName(String name, int i) {
        File outputFile = new File(name + i + ".png");

        if (outputFile.exists()) {
            return fileName(name, ++i);

        } else {
            return (name + i + ".png");
        }
    }


}
