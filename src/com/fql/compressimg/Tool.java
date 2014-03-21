package com.fql.compressimg;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import javax.imageio.ImageIO;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageOutputStream;

public class Tool {
	protected static File imageFile;
	protected static File compressedImageFile;
	protected static InputStream is;
	protected static OutputStream os;
	protected static BufferedImage image;
	protected static ImageWriter writer;
	protected static ImageOutputStream ios ;
	static {
		try {
			imageFile = new File("/home/fql/preCompress.png");
			is = new FileInputStream(imageFile);
			image = ImageIO.read(is);
			compressedImageFile = new File("/home/fql/afterCompress.jpg");
			os = new FileOutputStream(compressedImageFile);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("init error");
		}
	}
   public static void closeStream() throws Exception{
	   if(is !=null) is.close();
	   if(os !=null) os.close();
	   if(ios !=null) ios.close();
	   if(writer !=null) writer.dispose();
   }
}
