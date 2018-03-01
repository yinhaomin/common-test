package com.baidu.hui.common.test.biz.image;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;

public class TestImageIO {

    public static String read(InputStream input) throws IOException {
        ImageInputStream stream = ImageIO.createImageInputStream(input);

        Iterator iter = ImageIO.getImageReaders(stream);
        if (!iter.hasNext()) {
            return null;
        }
        ImageReader reader = (ImageReader) iter.next();
        ImageReadParam param = reader.getDefaultReadParam();
        reader.setInput(stream, true, true);
        BufferedImage bi;
        try {
            bi = reader.read(0, param);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            reader.dispose();
            try {
                stream.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return reader.getFormatName();
    }

    public static void main(String[] args) throws MalformedURLException, IOException {
        URLConnection connection = new URL("http://p1.pstatp.com/large/efa0004d2238045fb9f").openConnection();
        connection.setConnectTimeout(3000);
        connection.setReadTimeout(3000);
        InputStream in = null;
        try {
            in = connection.getInputStream();
            String format = read(in);
            System.out.print(format);
        } catch (Exception e) {

        }
    }
}
