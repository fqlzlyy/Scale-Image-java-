package com.fql.compressimg;

import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.util.Iterator;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriter;

public class JDKCompressImageByReduceResolution extends Tool {
	static BufferedImage bImg = null;

	public static void main(String[] args) throws Exception {
		BufferedImage image = ImageIO.read(is);
		Iterator<ImageWriter> writers = ImageIO
				.getImageWritersByFormatName("jpg");
		if (!writers.hasNext())
			throw new IllegalStateException("No ImageWriters Found!");
		writer = (ImageWriter) writers.next();
		ios = ImageIO.createImageOutputStream(os);
		writer.setOutput(ios);
		int w = image.getWidth();
		int h = image.getHeight();
		// set resolution
		BufferedImage dimg = new BufferedImage(960 * 2, 540 * 2,
				image.getType());
		Graphics2D g = dimg.createGraphics();
		g.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
				RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		g.drawImage(image, 0, 0, 960 * 2, 540 * 2, 0, 0, w, h, null);
		g.dispose();
		// write a complete image stream
		writer.write(null, new IIOImage(dimg, null, null), null);
		closeStream();
		System.out.println("compress completed");
	}

}
