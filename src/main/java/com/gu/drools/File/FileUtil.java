package com.gu.drools.File;

import com.gu.drools.config.exception.BusinessException;
import com.jcraft.jsch.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.poi.util.IOUtils;
import org.drools.core.util.IoUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.Properties;
import java.util.Vector;

@Slf4j
@Component
public class FileUtil {
    //ftp对象
    private static FTPClient ftp;
    //会话
    private static Session session;
    //需要连接到的ftp端的ip
    @Value("${sftp.ip}")
    private String ip;
    //连接端口，默认21
    @Value("${sftp.port}")
    private int port;
    //要连接到的ftp端的名字
    @Value("${sftp.username}")
    private String name;
    //要连接到的ftp端的对应得密码
    private String password;
    //私钥
    @Value("${sftp.privateKey}")
    private String privateKey;
    //文件流
    InputStream inputStream = null;
    OutputStream outputStream = null;

    ChannelSftp sftp = null;
    public FileUtil(String ip, int port, String name, String password) {
        ftp = new FTPClient();
        this.ip = ip;
        this.port = port;
        this.name = name;
        this.password = password;
    }
    public FileUtil(String name, String ip, int port, String privateKey) {
        ftp = new FTPClient();
        this.ip = ip;
        this.port = port;
        this.name = name;
        this.privateKey = privateKey;
    }
    public FileUtil(){

    }

    //登录，检查链接情况
    public void login() throws JSchException, IOException   {
        try {
            JSch jSch = new JSch();
            if(privateKey != null){
                InputStream stream = getClass().getClassLoader().getResourceAsStream(privateKey);
                byte[] bytes = IOUtils.toByteArray(stream);
                jSch.addIdentity("SSH",bytes,(byte[]) null, (byte[]) null);
                stream.close();
            }
            session = jSch.getSession(name,ip,port);
            if(password != null){
                session.setPassword(password);
            }
            session.setTimeout(100000);

            Properties config = new Properties();
            config.put("StrictHostKeyChecking", "no");
            session.setConfig(config);
            session.connect();

            Channel channel = session.openChannel("sftp");
            channel.connect();
            sftp = (ChannelSftp) channel;
            System.out.println("登录成功");
        } catch (JSchException e) {
            throw new BusinessException("登录失败，错误：{}"+e.getMessage());
        }

    }
    /*
    * directory 下载文件的路径
    * downloadFile 下载的文件
    * saveFileDirectory 保存的目录
    * */
    public void download(String directory, String downloadFile, String saveFileDirectory)
            throws IOException, SftpException {
        if(directory != null && !"".equals(directory)){
            sftp.cd(directory);
        }
        File file1 = new File(saveFileDirectory);
        if (!file1.exists()){
            file1.mkdir();
        }
        String saveFile = saveFileDirectory + "//" + downloadFile;
        File file = new File(saveFile);

        outputStream = new FileOutputStream(file);
        try {
            sftp.get(downloadFile,outputStream);
            System.out.println("下载成功");
        } catch (SftpException e) {
            System.out.println("下载失败");
            e.printStackTrace();
        }

    }
    public void delectURL(String delectURL) throws SftpException {
        if(isDir(delectURL)){
            sftp.cd(delectURL);
            Vector<ChannelSftp.LsEntry> entries = sftp.ls(".");
            for (ChannelSftp.LsEntry l:entries) {
                // sftp的ls命令会包含父文件夹和当前文件夹，递归时排除以免死循环
                if (!".".equals(l.getFilename()) && !"..".equals(l.getFilename())) {
                    delectURL(l.getFilename());
                }
            }
            sftp.cd("..");
            sftp.rmdir(delectURL);
        }else {
            sftp.rm(delectURL);
        }
    }
    public synchronized boolean isDir(String entry) throws SftpException {
        return sftp.stat(entry).isDir();
    }
    public void delect(String delectPath,String name) {
        if(delectPath != null && !"".equals(delectPath)){
            try {
                sftp.cd(delectPath);
            } catch (SftpException e) {
                e.printStackTrace();
            }
        }
        try {
            sftp.rm(name);
            log.info("删除成功");
        } catch (SftpException e) {
            log.info("删除失败");
            e.printStackTrace();
        }

    }
    /*
     * basePath 上传目录
     * direcotry 子目录
     * sftpFileName 上传的文件名
     * */
    public void  uploadSFTP(String uploadPath, String direcotry,String sftpFileName,byte[] bytes) throws SftpException {
            try {
                sftp.cd(uploadPath);
                log.info("切换到{}目录下",uploadPath);
                if (!direcotry.trim().equals("")){
                    sftp.cd(direcotry);
                    log.info("切换到{}目录下",direcotry);
                }
            } catch (SftpException e) {
                String[] dirs = direcotry.split("/");
                String temPath = uploadPath;
                for (String dir: dirs
                ) {
                    if( null == dir || "".equals(dir)) continue;
                    temPath +="/" + dir;
                    try {
                        sftp.cd(temPath);
                    } catch (SftpException ex) {
                        sftp.mkdir(temPath);
                        log.info("创建文件夹：{}",dir);
                        sftp.cd(temPath);
                        log.info("进入到{}文件夹",dir);
                    }
                }
            }
            try {
                sftp.put(new ByteArrayInputStream(bytes),sftpFileName);
                log.info("上传{}成功",sftpFileName);
            } catch (SftpException e) {
                log.info("上传文件错误");
                throw new BusinessException("上传文件错误");
            }
    }
    /*
    * basePath 上传目录
    * direcotry 子目录
    * sftpFileName 上传的文件名
    * upFile 本地文件地址
    * */
    public void  upload(String basePath, String direcotry, String
            sftpFileName, String upFile)
            throws SftpException, IOException {
        File ff = new File(upFile);
        inputStream = new FileInputStream(ff);
        try {
            //进入到目标目录
            sftp.cd(basePath);
            sftp.cd(direcotry);
        } catch (SftpException e) {
            String[] dirs = direcotry.split("/");
            String temPath = basePath;
            for (String dir: dirs
            ) {
                if( null == dir || "".equals(dir)) continue;
                temPath +="/" + dir;
                try {
                    sftp.cd(temPath);
                } catch (SftpException ex) {
                    sftp.mkdir(temPath);
                    sftp.cd(temPath);
                }
            }
        }
        sftp.put(inputStream,sftpFileName);
        System.out.println("上传成功");
    }


    /*
    * 获取文件夹下所有文件
    *
    * */
    public Vector<ChannelSftp.LsEntry> listFiles(String directory) throws SftpException {
        Vector ls = sftp.ls(directory);
        return ls;
    }
    /*
    * savePath 下载的路径
    * uplodePath 上传的路径
    * fileName 上传下载的名字file
    * */
    public void saveORupload(String savePath,String uplodePath,String fileName)
            throws SftpException, IOException, InterruptedException {
        if(savePath != null && !"".equals(savePath)){
            sftp.cd(savePath);
            log.info("切换到：{}目录",savePath);
        }

        inputStream = sftp.get(fileName);
        log.info("获取{}输入流成功",fileName);
        byte[] one = new byte[1024];
        ByteArrayOutputStream byteoutputStream = new ByteArrayOutputStream();
        int len = -1;
        while ((len = inputStream.read(one)) != -1) {
            byteoutputStream.write(one,0,len);
        }
        log.info("InputStream转ByteArrayOutputStream成功");
        if(uplodePath != null && !"".equals(uplodePath)){
            sftp.cd(uplodePath);
            log.info("切换到：{}目录",uplodePath);
        }
        sftp.put(new ByteArrayInputStream(byteoutputStream.toByteArray()),fileName);
        log.info("上传{}文件成功",fileName);
    }
    public static void main(String args[]) throws JSchException, IOException, SftpException, InterruptedException {
        String ip="152.136.163.72";//临时域名
        String username="root";//用户名
        String privateKey="C:/Users/谷欢/Desktop/SSH";//密码
        FileUtil file = new FileUtil(username,ip,22,privateKey);
        file.login();
        Vector<ChannelSftp.LsEntry> lsEntries = file.listFiles("/root/data");
        log.info("文件数量:{}",lsEntries.size());

        file.closeFtp();


    }
    /**
     * 关闭连接 server
     */
    public void closeFtp(){
        try {
            if(inputStream != null){
                inputStream.close();
            }
            if(outputStream != null){
                outputStream.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        sftp.disconnect();//断开信道
        session.disconnect();//断开ssh连接释放内存资源
        System.out.println("关闭sftp");
    }


}
