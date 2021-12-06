package com.dark.util;

import java.util.UUID;

public final class Tools {
    public static final Integer STATUSERROR=0;
    public static final Integer SUCCESS=1;
    public static final Integer FAILED=2;
    public static final Integer SQLERROR=3;
    public static final Integer DATANULL=4;
    public static final Integer UNLOGIN=5;
    /**
     * 生成随机UUID
     * @return 随机的UUID
     */
    public static String getUUID(){
        return UUID.randomUUID().toString().replaceAll("-"," ");
    }

}
