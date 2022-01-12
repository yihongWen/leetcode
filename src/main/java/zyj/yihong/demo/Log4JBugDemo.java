package zyj.yihong.demo;

import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * log4j  bug 复现
 * @author yihong
 */
@Slf4j
public class Log4JBugDemo {

    private static final Logger logger = LogManager.getLogger();

    public static void main(String[] args) {
        String error = "${java:vm}";
        logger.error("log4jDemo show...{}", error);
    }

}
