package q3_LucasLevi;

import java.io.File;
import java.io.IOException;
import java.awt.Color;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class Main {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\Gabriel\\IdeaProjects\\AV2_Joaogabrieloliveira\\src\\q3_Joaogabrieloliveira\\imagem.png";
        File file = new File(filePath);

        int redAmount = 50;    // Quantidade a ser adicionada ao canal vermelho
        int greenAmount = 20;  // Quantidade a ser adicionada ao canal verde
        int blueAmount = 10;   // Quantidade a ser adicionada ao canal azul

        try {
            BufferedImage image = ImageIO.read(file);
            int width = image.getWidth();
            int height = image.getHeight();

            for (int i = 0; i < width; i++) {
                for (int j = 0; j < height; j++) {
                    Color color = new Color(image.getRGB(i, j), true);

                    int red = color.getRed();
                    int green = color.getGreen();
                    int blue = color.getBlue();

                    // Atualiza as componentes RGB com as quantidades especificadas
                    red = Math.min(red + redAmount, 255);
                    green = Math.min(green + greenAmount, 255);
                    blue = Math.min(blue + blueAmount, 255);

                    Color newColor = new Color(red, green, blue);
                    image.setRGB(i, j, newColor.getRGB());
                }
            }

            ImageIO.write(image, "png", file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}