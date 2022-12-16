package com.view.buttons;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class MyButton extends JButton {

    private BufferedImage bufferedImage;

    public MyButton(BufferedImage bufferedImage) {
        super(new ImageIcon(bufferedImage));
        this.bufferedImage = bufferedImage;
    }

    public BufferedImage getBufImg() {
        BufferedImage newImg = new BufferedImage((int) getSize().getWidth(), (int) getSize().getHeight(), BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = newImg.createGraphics();
        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);

        g2d.drawImage((Image) bufferedImage, 0, 0, (int) getSize().getWidth(), (int) getSize().getHeight(), null);
        g2d.dispose();

        return newImg;
    }

    private int clickAlphaValue(BufferedImage bufferedImage, int posX, int posY) {
        int alpha;

        alpha = (bufferedImage.getRGB(posX, posY) >> 24) & 0x000000FF;

        return alpha;
    }

}
