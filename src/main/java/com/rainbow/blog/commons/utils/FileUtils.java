package com.rainbow.blog.commons.utils;

import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;

import static javafx.scene.input.DataFormat.URL;

/**
 * @author 邢晨旭
 * @Package com.rainbow.blog.commons.utils
 * @date 2020/6/13 9:39
 */
public class FileUtils {

    /**
     * 返回multipartFile文件类型
     * @param multipartFile
     * @return
     */
    public static String getFileType(MultipartFile multipartFile){
       return multipartFile.getOriginalFilename().substring(multipartFile.getOriginalFilename().lastIndexOf(".")+1);
    }

    /**
     * 返回multipartFile文件类型
     * @param file
     * @return
     */
    public static String getFileType(File file) throws IOException {
        return file.getCanonicalPath().substring(file.getCanonicalPath().lastIndexOf(".")+1);
    }



    public static File multipartFileToFile(MultipartFile file) throws IOException {

        File toFile = null;
        if ("".equals(file) || file.getSize() <= 0) {
            file = null;
        } else {
            InputStream ins = null;
            ins = file.getInputStream();
            toFile = new File(file.getOriginalFilename());
            inputStreamToFile(ins, toFile);
            ins.close();
        }
        return toFile;
    }

    //获取流文件

    private static void inputStreamToFile(InputStream ins, File file) {
        try {
            OutputStream os = new FileOutputStream(file);
            int bytesRead = 0;
            byte[] buffer = new byte[8192];
            while ((bytesRead = ins.read(buffer, 0, 8192)) != -1) {
                os.write(buffer, 0, bytesRead);
            }
            os.close();
            ins.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 获取文件内容
     * @param URL
     * @throws Exception
     */
    public static String getFileDetail (String URL){
        StringBuffer sbf = new StringBuffer();
        try {

            //创建URL对象

            java.net.URL myUrl=new URL("http://sh-xcx-blog.oss-cn-shanghai.aliyuncs.com/blog/user/avatar7A7C16AB4DFB4D3585A35577F13DE4D8.md");

            //创建连接

            URLConnection uc=myUrl.openConnection();

            //获取服务器端字节流

            InputStreamReader isr=new InputStreamReader(uc.getInputStream());

            //读文件

            BufferedReader br=new BufferedReader(isr);
            String tempStr="";
            while ((tempStr = br.readLine()) != null) {
                sbf.append(tempStr);
            }
            br.close();
        }catch (IOException e){
            sbf.replace(0,sbf.length(),"文件解析出错");
        }
        finally {
            return sbf.toString();
        }

    }


}
