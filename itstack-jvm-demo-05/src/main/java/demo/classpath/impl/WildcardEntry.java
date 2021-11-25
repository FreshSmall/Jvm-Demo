/*
 * Copyright (C) GSX Techedu Inc. All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 */

package demo.classpath.impl;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;

/**
 * @author yinchao
 * @description
 * @team wuhan operational dev.
 * @date 2021/11/19 15:00 通配符类路径，继承CompositeEntry
 **/
public class WildcardEntry extends CompositeEntry {

    public WildcardEntry(String path) {
        super(toPathList(path));
    }

    private static String toPathList(String wildcardPath) {

        // remove *
        String baseDir = wildcardPath.replace("*", "");
        try {
            return Files.walk(Paths.get(baseDir))
                .filter(Files::isRegularFile)
                .map(Path::toString)
                .filter(p -> p.endsWith(".jar") || p.endsWith(".JAR"))
                .collect(Collectors.joining(File.pathSeparator));
        } catch (IOException e) {
            return "";
        }
    }

}
