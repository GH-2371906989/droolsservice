package com.gu.drools.controller;

import com.gu.drools.File.FileUtil;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.SftpException;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

@RestController
@CrossOrigin
@RequestMapping("file")
@Slf4j
public class FileController {


    @ApiOperation("远程下载文件")
    @GetMapping("/saveFile")
    public String saveFile() throws IOException, JSchException, SftpException {
        log.info("saveFile");
        String ip="152.136.163.72";//临时域名
        String username="root";//用户名
        String privateKey= "PDF/SSH";
        FileUtil file = new FileUtil(username,ip,22,privateKey );
        log.info("开始登录");
        file.login();
        String SavePath = System.getProperty("user.dir")+"/PDF";
        file.download("/root/data","00000000000000106817.pdf",SavePath);
        file.closeFtp();
        return "saveFile";
    }
    @ApiOperation("删除本地文件")
    @PostMapping("/delectFile")
    public String delectFile(String name) throws IOException, JSchException {

        File file = new File(System.getProperty("user.dir") + "/PDF/"+name);
        if (file.exists()){
            file.delete();
        }
        return "删除成功";
    }

/*    @GetMapping("/updateFile")
    public String updateFile() throws IOException, JSchException, SftpException {
        String ip="152.136.163.72";//临时域名
        String username="root";//用户名
        String privateKey= "PDF/SSH";
        FileUtil file = new FileUtil(username,ip,22,privateKey );
        log.info("开始登录");
        file.login();
        String UpdatePath = "/root/data1";
        file.upload(UpdatePath,"","00000000000000106817.pdf",
                System.getProperty("user.dir") + "/PDF/00000000000000106817.pdf");
        file.closeFtp();
        return  "上传成功";
    }
    @PostMapping("/getfiles")
    public Map<String,Object> getfiles(String path) throws IOException, JSchException {
        Map<String,Object> map = new HashMap<>();
        String ip="152.136.163.72";//临时域名
        String username="root";//用户名
        String privateKey= "PDF/SSH";
        FileUtil file = new FileUtil(username,ip,22,privateKey );
        log.info("开始登录");
        file.login();
        try {
            Vector<ChannelSftp.LsEntry> lsEntries = file.listFiles(path);
            int size = lsEntries.size();
            log.info("文件数量:{}",size);
            for (ChannelSftp.LsEntry lsEntry : lsEntries){
                log.info("Filename:{}",lsEntry.getFilename());
                log.info("Longname:{}",lsEntry.getLongname());
                log.info("isDir:{}",lsEntry.getAttrs().isDir());
                log.info("================================");
            }
        } catch (SftpException e) {
            map.put("error","路径错误");
        }
        return map;
    }*/
}
