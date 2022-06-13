package com.eastcom.teoan.learning.java.agent;

import java.lang.instrument.Instrumentation;

/**
 * @author Teoan
 * @date 2022/4/18 22:44
 * @description Premain类 执行main类之前执行
 */
public class Agent {

    public static void premain(String arg, Instrumentation instrumentation) {
        //JVM启动参数 -javaagent:E:\Teoan\JavaProject\EastcomStudy\target\EastcomStudy-1.0-SNAPSHOT.jar
        instrumentation.addTransformer(new MethodAgent());
    }

}
