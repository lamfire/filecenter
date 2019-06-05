package com.lamfire.filecenter.action;

import com.lamfire.filecenter.FileCenterConfig;
import com.lamfire.filecenter.utils.NameUtils;
import com.lamfire.json.JSON;
import com.lamfire.logger.Logger;
import com.lamfire.utils.FileUtils;
import com.lamfire.utils.FilenameUtils;
import com.lamfire.utils.Image;
import com.lamfire.utils.ImageScale;
import com.lamfire.wkit.MultiPartFile;
import com.lamfire.wkit.action.ActionSupport;
import com.lamfire.wkit.anno.ACTION;
import com.lamfire.wkit.anno.MAPPING;
import com.lamfire.wkit.anno.PARAM;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

@ACTION
public class AvatarAction extends ActionSupport {
    private static final Logger LOGGER = Logger.getLogger("AvatarAction");

    @MAPPING(path = "/avatar/upload")
    public void upload(@PARAM(value = "file")MultiPartFile file, OutputStream out){
        String datePattern = FileCenterConfig.getInstance().getAvatarStoreDirDatePattern();
        String urlPrefix  = FileCenterConfig.getInstance().getAvatarDownloadUrlPrefix();
        String storeDir = FileCenterConfig.getInstance().getAvatarStoreDir();

        String fileNewName = NameUtils.randomFileName(file.getFileName());
        String filePath = NameUtils.filePath(datePattern,fileNewName);
        String fileUrl = NameUtils.urlConcat(urlPrefix , filePath);
        String fileStorePath = FilenameUtils.concat(storeDir,filePath);

        File saveAsFile = new File(fileStorePath);
        try {
            FileUtils.makeParentDirsIfNotExists(saveAsFile);
            scaleAndSave(file,saveAsFile);

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

    private void scaleAndSave(MultiPartFile mfile,File saveAs) throws IOException {
        if(!FileCenterConfig.getInstance().isAvatarScaleEnable()){
            mfile.saveAs(saveAs);
            return;
        }
        int w = FileCenterConfig.getInstance().getAvatarScaleWidth();
        int h = FileCenterConfig.getInstance().getAvatarScaleHeight();
        byte[] imgBytes  = mfile.getFileItem().get();

        BufferedImage bufferedImg = Image.toBufferedImage(imgBytes);
        BufferedImage scaledImg = Image.clipScale(bufferedImg,w,h);

        //ImageScale scale = new ImageScale();
        //BufferedImage scaledImg = scale.zoomOut(bufferedImg,w,h);
        byte[] scaleBytes  = Image.getBytes(scaledImg,FilenameUtils.getExtension(saveAs.getPath()));
        FileUtils.writeByteArrayToFile((saveAs),scaleBytes);
    }
}
