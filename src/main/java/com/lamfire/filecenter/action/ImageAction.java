package com.lamfire.filecenter.action;

import com.lamfire.filecenter.FileCenterConfig;
import com.lamfire.filecenter.utils.NameUtils;
import com.lamfire.json.JSON;
import com.lamfire.logger.Logger;
import com.lamfire.utils.FileUtils;
import com.lamfire.utils.FilenameUtils;
import com.lamfire.utils.ImageScale;
import com.lamfire.wkit.MultiPartFile;
import com.lamfire.wkit.action.ActionSupport;
import com.lamfire.wkit.anno.ACTION;
import com.lamfire.wkit.anno.MAPPING;
import com.lamfire.wkit.anno.PARAM;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

@ACTION
public class ImageAction extends ActionSupport {
    private static final Logger LOGGER = Logger.getLogger("ImageAction");

    @MAPPING(path = "/image/upload")
    public void upload(@PARAM(value = "file")MultiPartFile file, OutputStream out){
        if(file == null){
            JSON json = new JSON();
            json.put("status",500);
            json.put("error","multi part file not found");
            this.write(out,json.toBytes());
            return;
        }
        String datePattern = FileCenterConfig.getInstance().getImageStoreDirDatePattern();
        String urlPrefix  = FileCenterConfig.getInstance().getImageDownloadUrlPrefix();
        String storeDir = FileCenterConfig.getInstance().getImageStoreDir();

        String fileNewName = NameUtils.randomFileName(file.getFileName());
        String filePath = NameUtils.filePath(datePattern,fileNewName);
        String fileUrl = NameUtils.urlConcat(urlPrefix , filePath);
        String fileStorePath = FilenameUtils.concat(storeDir,filePath);

        File saveAsFile = new File(fileStorePath);
        try {
            FileUtils.makeParentDirsIfNotExists(saveAsFile);
            file.saveAs(saveAsFile);

            JSON json = new JSON();
            json.put("status",200);
            json.put("url",fileUrl);
            this.write(out,json.toBytes());
        } catch (IOException e) {
            LOGGER.error(e.getMessage(),e);

            JSON json = new JSON();
            json.put("status",500);
            json.put("error",e.getMessage());
            this.write(out,json.toBytes());
        }
    }

}
