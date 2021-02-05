package com.rxh.complat.common.util;

import com.github.pagehelper.util.StringUtil;
import lombok.extern.slf4j.Slf4j;
import sun.misc.BASE64Decoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.Base64;
import java.util.List;
import java.util.zip.Adler32;
import java.util.zip.CheckedOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * @Description 文件下载工具类
 * @author Zhang YuHui
 * @date 2021/2/4
 */
@Slf4j
public class DownLoadUtils {

    /**
     * @Description 压缩包下载
     * @author Zhang YuHui
     * @date 2021/2/4
     *
     * @param request
     * @param response
     * @param files  base64文件泪飙
     * @param fileSuffix 文件后缀 目前仅支持同一类型的打包  后续会优化根据文件类型自动转换
     * @return void
     */
    public static void downLoadZip(HttpServletRequest request, HttpServletResponse response, List<String> files, String fileSuffix) {
        File tempFile = null;
        try {
            tempFile = File.createTempFile("temp", ".zip");
            FileOutputStream fops = new FileOutputStream(tempFile);
            CheckedOutputStream csum = new CheckedOutputStream(fops, new Adler32());
            ZipOutputStream zos = new ZipOutputStream(csum);
//            OSS ossClient = new OSSClientBuilder().build(OssConfig.YWZTENDPOINT, OssConfig.YWZTACCESSKETID, OssConfig.YWZTACCESSKEYSECRET);
            for (String fileInfo : files) {
                InputStream inputStream = null;
                String fileName = "";

                //Base64图片解析
                BASE64Decoder decoder = new BASE64Decoder();

                byte[] bytes = decoder.decodeBuffer(fileInfo);
                inputStream = new ByteArrayInputStream(bytes);
                fileName = System.currentTimeMillis() + "." + fileSuffix;

                zos.putNextEntry(new ZipEntry(fileName));
                int bytesRead = 0;
                while ((bytesRead = inputStream.read()) != -1) {
                    zos.write(bytesRead);
                }
                inputStream.close();
                zos.closeEntry();
            }
            zos.close();
            String downloadName = System.currentTimeMillis() + ".zip";
            String header = request.getHeader("User-Agent").toUpperCase();
            String msie = "MSIE", trident = "TRIDENT", edge = "EDGE";
            if (header.contains(msie) || header.contains(trident) || header.contains(edge)) {
                downloadName = URLEncoder.encode(downloadName, "utf-8");
                //IE下载文件名空格变+号问题
                downloadName = downloadName.replace("+", "%20");
            } else {
                downloadName = new String(downloadName.getBytes(), "ISO8859-1");
            }
            response.reset();
            response.setContentType("text/plain");
            response.setContentType("application/octet-stream; charset=utf-8");
            response.setHeader("Location", downloadName);
            response.setHeader("Cache-Control", "max-age=0");
            response.setHeader("Content-Disposition", "attachment; filename=" + downloadName);

            FileInputStream fis = new FileInputStream(tempFile);
            BufferedInputStream buff = new BufferedInputStream(fis);
            BufferedOutputStream out = new BufferedOutputStream(response.getOutputStream());
            byte[] car = new byte[1024];
            int l = 0;
            while (l < tempFile.length()) {
                int j = buff.read(car, 0, 1024);
                l += j;
                out.write(car, 0, j);
            }
            fis.close();
            buff.close();
            out.close();
            // 删除临时文件
            tempFile.delete();
        } catch (IOException e) {
            log.error("下载文件失败");
        }
    }

    /**
     * @Description 普通base64下载
     * @author Zhang YuHui
     * @date 2021/2/4
     *
     * @param response
     * @param baseImg
     * @param name
     * @return void
     */
    public static void downLoadBase64(HttpServletResponse response, String baseImg, String name) {
        try {
//            String str = System.currentTimeMillis() + ;
            response.setHeader("Content-Disposition", "attachment; filename=" + name);
            OutputStream out = null;
            out = new BufferedOutputStream(response.getOutputStream());

            if (StringUtil.isEmpty(baseImg)) {
                out.write("".getBytes());
            } else {
                out.write(Base64.getDecoder().decode(baseImg.getBytes("UTF-8")));
            }
            out.flush();
            out.close();
        } catch (IOException e) {

        }

    }
}
