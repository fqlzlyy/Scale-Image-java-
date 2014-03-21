package com.fql.compressimg;

import java.util.Iterator;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;

// compress img by reduce size but keepResolutionConstant
public class JDKCompressImageByReduceSize extends Tool {

	public static void main(String[] args) throws Exception {
		float quality = 0.1f;
		Iterator<ImageWriter> writers = ImageIO
				.getImageWritersByFormatName("jpg");
		if (!writers.hasNext())
			throw new IllegalStateException("No ImageWriters Found!");
		writer = (ImageWriter) writers.next();
		ios = ImageIO.createImageOutputStream(os);
		writer.setOutput(ios);
		// set compress params
		// must set mode be MODE_EXPLICIT
		ImageWriteParam param = writer.getDefaultWriteParam();
		param.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
		param.setCompressionQuality(quality);
		// write a complete image stream
		writer.write(null, new IIOImage(image, null, null), param);
		// close stream
		closeStream();
		System.out.println("compress completed");
	}

}
