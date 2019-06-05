package com.lamfire.filecenter;

import com.lamfire.logger.Logger;
import com.lamfire.utils.NumberUtils;
import com.lamfire.utils.PropertiesUtils;
import com.lamfire.utils.StringUtils;
import com.lamfire.utils.TypeConvertUtils;

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
    private boolean iconScaleEnable = false;
    private int iconScaleWidth = 64;
    private int iconScaleHeight = 64;

    private String avatarDownloadUrlPrefix;
    private String avatarStoreDir;
    private String avatarStoreDirDatePattern;
    private boolean avatarScaleEnable = false;
    private int avatarScaleWidth = 64;
    private int avatarScaleHeight = 64;

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
        this.iconScaleEnable = TypeConvertUtils.toBoolean(prop.getProperty("icon.scale.enable"));
        this.iconScaleWidth = NumberUtils.toInt(prop.getProperty("icon.scale.width"),64);
        this.iconScaleHeight = NumberUtils.toInt(prop.getProperty("icon.scale.height"),64);
        LOGGER.info("iconDownloadUrlPrefix : " + iconDownloadUrlPrefix);
        LOGGER.info("iconStoreDir : " + iconStoreDir);
        LOGGER.info("iconStoreDirDatePattern : " + iconStoreDirDatePattern);
        LOGGER.info("iconScaleEnable : " + iconScaleEnable);
        LOGGER.info("iconScaleWidth : " + iconScaleWidth);
        LOGGER.info("iconScaleHeight : " + iconScaleHeight);

        this.avatarDownloadUrlPrefix = prop.getProperty("avatar.download.url.prefix");
        this.avatarStoreDir = prop.getProperty("avatar.store.dir");
        this.avatarStoreDirDatePattern = prop.getProperty("avatar.store.dir.datepattern");
        this.avatarScaleEnable = TypeConvertUtils.toBoolean(prop.getProperty("avatar.scale.enable"));
        this.avatarScaleWidth = NumberUtils.toInt(prop.getProperty("avatar.scale.width"),64);
        this.avatarScaleHeight = NumberUtils.toInt(prop.getProperty("avatar.scale.height"),64);
        LOGGER.info("avatarDownloadUrlPrefix : " + avatarDownloadUrlPrefix);
        LOGGER.info("avatarStoreDir : " + avatarStoreDir);
        LOGGER.info("avatarStoreDirDatePattern : " + avatarStoreDirDatePattern);
        LOGGER.info("avatarScaleEnable : " + avatarScaleEnable);
        LOGGER.info("avatarScaleWidth : " + avatarScaleWidth);
        LOGGER.info("avatarScaleHeight : " + avatarScaleHeight);


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

    public boolean isIconScaleEnable() {
        return iconScaleEnable;
    }

    public void setIconScaleEnable(boolean iconScaleEnable) {
        this.iconScaleEnable = iconScaleEnable;
    }

    public int getIconScaleWidth() {
        return iconScaleWidth;
    }

    public void setIconScaleWidth(int iconScaleWidth) {
        this.iconScaleWidth = iconScaleWidth;
    }

    public int getIconScaleHeight() {
        return iconScaleHeight;
    }

    public void setIconScaleHeight(int iconScaleHeight) {
        this.iconScaleHeight = iconScaleHeight;
    }

    public boolean isAvatarScaleEnable() {
        return avatarScaleEnable;
    }

    public void setAvatarScaleEnable(boolean avatarScaleEnable) {
        this.avatarScaleEnable = avatarScaleEnable;
    }

    public int getAvatarScaleWidth() {
        return avatarScaleWidth;
    }

    public void setAvatarScaleWidth(int avatarScaleWidth) {
        this.avatarScaleWidth = avatarScaleWidth;
    }

    public int getAvatarScaleHeight() {
        return avatarScaleHeight;
    }

    public void setAvatarScaleHeight(int avatarScaleHeight) {
        this.avatarScaleHeight = avatarScaleHeight;
    }
}
