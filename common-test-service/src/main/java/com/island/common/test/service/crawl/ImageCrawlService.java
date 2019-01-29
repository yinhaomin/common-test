package com.island.common.test.service.crawl;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

public class ImageCrawlService {

    public static void main(String[] args) {
        String url = "https://avatar.csdn.net/B/E/1/3_lv_hang515888.jpg";
        downloadPicture(url);
    }

    //链接url下载图片
    private static void downloadPicture(String urlList) {
        URL url = null;
        int imageNumber = 0;

        try {
            url = new URL(urlList);
            DataInputStream dataInputStream = new DataInputStream(url.openStream());

            String imageName = "/Users/davidyin/Desktop/labs/Github/nsfw_data_scrapper/raw_data/porn/test.jpg";

            FileOutputStream fileOutputStream = new FileOutputStream(new File(imageName));
            ByteArrayOutputStream output = new ByteArrayOutputStream();

            byte[] buffer = new byte[1024];
            int length;

            while ((length = dataInputStream.read(buffer)) > 0) {
                output.write(buffer, 0, length);
            }
            byte[] context = output.toByteArray();
            fileOutputStream.write(output.toByteArray());
            dataInputStream.close();
            fileOutputStream.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
