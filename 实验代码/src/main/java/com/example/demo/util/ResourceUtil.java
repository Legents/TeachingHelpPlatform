package com.example.demo.util;

import org.springframework.util.ResourceUtils;

import java.io.FileNotFoundException;

public class ResourceUtil {
    public static String getResourcePath() throws FileNotFoundException {
        String path = ResourceUtils.getURL("src/main/resources").getPath();
        return path;
    }
}
