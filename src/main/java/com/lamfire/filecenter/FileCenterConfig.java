package com.lamfire.filecenter;

import com.lamfire.logger.Logger;
import com.lamfire.utils.PropertiesUtils;

import java.util.Properties;

public class FileCenterConfig {
    private static final Logger LOGGER = Logger.getLogger("FileCenterConfig");
    private final static String FILE_CENTER_CONFIG_FILE="filecenter.properties";

    private final static FileCenterConfig instance = new FileCenterConfig();

    public static final FileCenterConfig getInstance(){
        return instance;
    }

    private String fileDownloadUrlPrefix;
    private String fileStoreDir;
    private String fileStoreDirDatePattern;

    private String imageDownloadUrlPrefix;
    private String imageStoreDir;
    private String imageStoreDirDatePattern;

    private String iconDownloadUrlPrefix;
    private String iconStoreDir;
    private String iconStoreDirDatePattern;

    private String avatarDownloadUrlPrefix;
    private String avatarStoreDir;
    private String avatarStoreDirDatePattern;

    private FileCenterConfig(){
        Properties prop = PropertiesUtils.load(FILE_CENTER_CONFIG_FILE,PropertiesUtils.class);

        this.fileDownloadUrlPrefix = prop.getProperty("file.download.url.prefix");
        this.fileStoreDir = prop.getProperty("file.store.dir");
        this.fileStoreDirDatePattern = prop.getProperty("file.store.dir.datepattern");
        LOGGER.info("fileDownloadUrlPrefix : " + fileDownloadUrlPrefix);
        LOGGER.info("fileStoreDir : " + fileStoreDir);
        LOGGER.info("fileStoreDirDatePattern : " + fileStoreDirDatePattern);


        this.imageDownloadUrlPrefix = prop.getProperty("image.download.url.prefix");
        this.imageStoreDir = prop.getProperty("image.store.dir");
        this.imageStoreDirDatePattern = prop.getProperty("image.store.dir.datepattern");
        LOGGER.info("imageDownloadUrlPrefix : " + imageDownloadUrlPrefix);
        LOGGER.info("imageStoreDir : " + imageStoreDir);
        LOGGER.info("imageStoreDirDatePattern : " + imageStoreDirDatePattern);

        this.iconDownloadUrlPrefix = prop.getProperty("icon.download.url.prefix");
        this.iconStoreDir = prop.getProperty("icon.store.dir");
        this.iconStoreDirDatePattern = prop.getProperty("icon.store.dir.datepattern");
        LOGGER.info("iconDownloadUrlPrefix : " + iconDownloadUrlPrefix);
        LOGGER.info("iconStoreDir : " + iconStoreDir);
        LOGGER.info("iconStoreDirDatePattern : " + iconStoreDirDatePattern);

        this.avatarDownloadUrlPrefix = prop.getProperty("avatar.download.url.prefix");
        this.avatarStoreDir = prop.getProperty("avatar.store.dir");
        this.avatarStoreDirDatePattern = prop.getProperty("avatar.store.dir.datepattern");
        LOGGER.info("avatarDownloadUrlPrefix : " + avatarDownloadUrlPrefix);
        LOGGER.info("avatarStoreDir : " + avatarStoreDir);
        LOGGER.info("avatarStoreDirDatePattern : " + avatarStoreDirDatePattern);


    }

    public String getFileDownloadUrlPrefix() {
        return fileDownloadUrlPrefix;
    }

    public void setFileDownloadUrlPrefix(String fileDownloadUrlPrefix) {
        this.fileDownloadUrlPrefix = fileDownloadUrlPrefix;
    }

    public String getFileStoreDir() {
        return fileStoreDir;
    }

    public void setFileStoreDir(String fileStoreDir) {
        this.fileStoreDir = fileStoreDir;
    }

    public String getFileStoreDirDatePattern() {
        return fileStoreDirDatePattern;
    }

    public void setFileStoreDirDatePattern(String fileStoreDirDatePattern) {
        this.fileStoreDirDatePattern = fileStoreDirDatePattern;
    }

    public String getImageDownloadUrlPrefix() {
        return imageDownloadUrlPrefix;
    }

    public void setImageDownloadUrlPrefix(String imageDownloadUrlPrefix) {
        this.imageDownloadUrlPrefix = imageDownloadUrlPrefix;
    }

    public String getImageStoreDir() {
        return imageStoreDir;
    }

    public void setImageStoreDir(String imageStoreDir) {
        this.imageStoreDir = imageStoreDir;
    }

    public String getImageStoreDirDatePattern() {
        return imageStoreDirDatePattern;
    }

    public void setImageStoreDirDatePattern(String imageStoreDirDatePattern) {
        this.imageStoreDirDatePattern = imageStoreDirDatePattern;
    }

    public String getIconDownloadUrlPrefix() {
        return iconDownloadUrlPrefix;
    }

    public void setIconDownloadUrlPrefix(String iconDownloadUrlPrefix) {
        this.iconDownloadUrlPrefix = iconDownloadUrlPrefix;
    }

    public String getIconStoreDir() {
        return iconStoreDir;
    }

    public void setIconStoreDir(String iconStoreDir) {
        this.iconStoreDir = iconStoreDir;
    }

    public String getIconStoreDirDatePattern() {
        return iconStoreDirDatePattern;
    }

    public void setIconStoreDirDatePattern(String iconStoreDirDatePattern) {
        this.iconStoreDirDatePattern = iconStoreDirDatePattern;
    }

    public String getAvatarDownloadUrlPrefix() {
        return avatarDownloadUrlPrefix;
    }

    public void setAvatarDownloadUrlPrefix(String avatarDownloadUrlPrefix) {
        this.avatarDownloadUrlPrefix = avatarDownloadUrlPrefix;
    }

    public String getAvatarStoreDir() {
        return avatarStoreDir;
    }

    public void setAvatarStoreDir(String avatarStoreDir) {
        this.avatarStoreDir = avatarStoreDir;
    }

    public String getAvatarStoreDirDatePattern() {
        return avatarStoreDirDatePattern;
    }

    public void setAvatarStoreDirDatePattern(String avatarStoreDirDatePattern) {
        this.avatarStoreDirDatePattern = avatarStoreDirDatePattern;
    }
}
