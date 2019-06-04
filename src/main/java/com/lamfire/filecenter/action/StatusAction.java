package com.lamfire.filecenter.action;

import com.lamfire.filecenter.FileCenterConfig;
import com.lamfire.json.JSON;
import com.lamfire.wkit.MultiPartFile;
import com.lamfire.wkit.action.ActionSupport;
import com.lamfire.wkit.anno.ACTION;
import com.lamfire.wkit.anno.MAPPING;
import com.lamfire.wkit.anno.PARAM;

import java.io.OutputStream;

@ACTION
public class StatusAction extends ActionSupport {

    @MAPPING(path = "/")
    public void status(OutputStream out){
        JSON json = JSON.fromJavaObject(FileCenterConfig.getInstance());
        json.put("status",200);

        this.write(out,json.toBytes());
    }
}
