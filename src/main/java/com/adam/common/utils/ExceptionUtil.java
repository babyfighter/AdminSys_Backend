package com.adam.common.utils;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
/*
    堆栈信息转为String，输出
 */
@Slf4j
public class ExceptionUtil {
    public static String getMessage(Exception e) {
        String message = null;
        try(StringWriter sw = new StringWriter(); PrintWriter pw = new PrintWriter(sw)) {
            e.printStackTrace(pw);
            pw.flush();
            sw.flush();
            message = sw.toString();
        }catch (IOException io) {
            io.printStackTrace();
            log.error(io.getMessage());
        }
        return message;
    }
}
