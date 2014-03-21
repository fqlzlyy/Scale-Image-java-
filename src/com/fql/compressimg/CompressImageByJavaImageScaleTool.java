package com.fql.compressimg;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import com.mortennobel.imagescaling.AdvancedResizeOp;
import com.mortennobel.imagescaling.ProgressListener;
import com.mortennobel.imagescaling.ResampleOp;

/**
 * 
 depend java-image-scaling jar 
 site:http://code.google.com/p/java-image-scaling/
 */

public class CompressImageByJavaImageScaleTool extends Tool {

	public static void main(String[] args) throws Exception {
		// set image resolution
		ResampleOp resampleOp = new ResampleOp(1920 * 2, 1080 * 2);
		// remove some of blur
		resampleOp.setUnsharpenMask(AdvancedResizeOp.UnsharpenMask.Normal);
		resampleOp.addProgressListener(new CompressProgressListener());

		BufferedImage rescaledTomato = resampleOp.filter(image, null);
		// set write format output
		// bmp > png >jpg/gif
		System.out.println("--------begin write image-----------");
		ImageIO.write(rescaledTomato, "PNG", new File(
				"/home/fql/javaImageScaleTool1.png"));
		ImageIO.write(rescaledTomato, "JPG", new File(
				"/home/fql/javaImageScaleTool1.jpg"));
		ImageIO.write(rescaledTomato, "GIF", new File(
				"/home/fql/javaImageScaleTool1.gif"));
		ImageIO.write(rescaledTomato, "BMP", new File(
				"/home/fql/javaImageScaleTool1.bmp"));
		System.out.println("--------end  write image------------");
		closeStream();
	}

	public static class CompressProgressListener implements ProgressListener {

		@Override
		public void notifyProgress(float progress) {
			System.out.printf("convert to buffer image - %3.2f percent %n",
					progress * 100);
		}

	}

}
