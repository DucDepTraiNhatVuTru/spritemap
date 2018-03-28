/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spritemaphaichieu;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author DSU
 */
public class SpriteMapManipulator {
    public static void join(String inputPath, String outputPath) throws IOException{
        File directory = new File(inputPath);
        
        File[] files = directory.listFiles();
        
        BufferedImage sprite = ImageIO.read(files[0]);
        
        int width = sprite.getWidth() *2;
        int height = sprite.getHeight()*2;
        
        BufferedImage spriteMap;
        spriteMap = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        
        Graphics2D g2d = spriteMap.createGraphics();
        
        int x = 0;
        int y =0;
        
        for(int i=0;i<files.length/2;i++){
            sprite= ImageIO.read(files[i]);
            g2d.drawImage(sprite, null, x, 0);
            x+=sprite.getWidth();
        }
        x=0;
        y=sprite.getHeight();
        for(int i=files.length/2; i<files.length;i++){
            sprite =ImageIO.read(files[i]);
            g2d.drawImage(sprite, null,x,y);
            x+=sprite.getWidth();
        }
        ImageIO.write(spriteMap, "png", new File(outputPath));
    }
}
