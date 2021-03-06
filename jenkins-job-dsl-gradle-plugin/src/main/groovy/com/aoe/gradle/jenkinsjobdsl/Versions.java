package com.aoe.gradle.jenkinsjobdsl;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Loads generated version information from the classpath.
 * It's a java class because Groovy seems to fuck up loading resources from
 * classpath somehow... Or maybe it's Gradle... anyway it's fucked up.
 *
 * @author Carsten Lenz, AOE
 */
public class Versions {
    static Properties props;
    static {
        props = new Properties();
        try {
            InputStream is = Versions.class.getResourceAsStream("dependencyVersions.properties");
            props.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NullPointerException npe) {
            npe.printStackTrace();
        }

    }

    public static String getJobDsl() {
        return props.getProperty("jobDsl");
    }

    public static String getPluginVersion() {
        return props.getProperty("pluginVersion");
    }

    public static String getGroovy() {
        return props.getProperty("groovy");
    }

    public static String getSpock() {
        return props.getProperty("spock");
    }
}
