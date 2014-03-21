package com.fql.compressimg;

import java.awt.image.BufferedImage;
import java.util.Iterator;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriter;

import org.imgscalr.Scalr;

/**
 * 
 https://github.com/thebuzzmedia/imgscalr 
 */

public class CompressImgByImgScalrTool extends Tool {

	public static void main(String[] args) throws Exception {
		// create a BufferedImage
		BufferedImage bimg = Scalr.resize(image, Scalr.Method.SPEED,
				Scalr.Mode.FIT_TO_WIDTH, 1920, 1080, Scalr.OP_ANTIALIAS);
		// get all image writers for JPG format
		Iterator<ImageWriter> writers = ImageIO
				.getImageWritersByFormatName("jpg");
		if (!writers.hasNext())
			throw new IllegalStateException("No writers found");
		writer = (ImageWriter) writers.next();
		ios = ImageIO.createImageOutputStream(os);
		writer.setOutput(ios);
		writer.write(null, new IIOImage(bimg, null, null), null);
		// close all streams
		closeStream();
		System.out.println("compress completed");
	}

}
