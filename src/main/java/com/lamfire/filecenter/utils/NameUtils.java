package com.lamfire.filecenter.utils;

import com.lamfire.code.Base62;
import com.lamfire.code.Base64;
import com.lamfire.code.Hex;
import com.lamfire.code.PUID;
import com.lamfire.utils.DateFormatUtils;
import com.lamfire.utils.DateUtils;
import com.lamfire.utils.FilenameUtils;
import com.lamfire.utils.StringUtils;

import java.util.TimeZone;

public class NameUtils {

    public static String fileStoreDir(String storeDir,String datePattern){
        if(StringUtils.isBlank(datePattern)){
            return storeDir;
        }
        String dateName = DateFormatUtils.format(System.currentTimeMillis(),datePattern,DateUtils.TIMEZONE_ASIA_SHANGHAI);
        return FilenameUtils.concat(storeDir,dateName);
    }

    public static String fileStorePath(String storeDir,String datePattern,String fileNameOnly){
        return FilenameUtils.concat(fileStoreDir(storeDir,datePattern),fileNameOnly);
    }

    public static String filePath(String datePattern ,String fileNameOnly){
        if(StringUtils.isBlank(datePattern)){
            return fileNameOnly;
        }
        String dateName = DateFormatUtils.format(System.currentTimeMillis(),datePattern,DateUtils.TIMEZONE_ASIA_SHANGHAI);
        return FilenameUtils.concat(dateName,fileNameOnly);
    }

    public static String randomFileName(String oFileName){
        String extension = FilenameUtils.getExtension(oFileName);
        byte[] bytes = PUID.puidAsBytes();
        String newName = FilenameUtils.setExtension(Hex.encode(bytes),extension);
        return newName;
    }

    public static String urlConcat(String baseUrl,String fullFilenameToAdd){
        if(StringUtils.isBlank(baseUrl)){
            return fullFilenameToAdd;
        }
        if(StringUtils.isBlank(fullFilenameToAdd)){
            return baseUrl;
        }
        char ch = baseUrl.charAt(baseUrl.length() - 1);
        char ch1 = fullFilenameToAdd.charAt(0);
        if(ch1 =='/'){
            fullFilenameToAdd = StringUtils.substring(fullFilenameToAdd,1);
        }
        String result ;
        if(ch == '/'){
            result = baseUrl + fullFilenameToAdd;
        }else{
            result = baseUrl + '/' + fullFilenameToAdd;
        }

        return result;
    }
    public static void main(String[] args) {
        System.out.println(urlConcat("http://127.0.0.1/f","/a.jpg"));
        System.out.println(urlConcat("http://127.0.0.1/f/","/a.jpg"));
        System.out.println(urlConcat("http://127.0.0.1/f/","/a.jpg"));
        System.out.println(urlConcat("http://127.0.0.1/f","a.jpg"));
    }
}
