package com.eastcom.teoan.learning.java.agent;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import lombok.extern.slf4j.Slf4j;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.security.ProtectionDomain;

/**
 * @author Teoan
 * @date 2022/4/18 22:44
 * @description
 */
@Slf4j
public class MethodAgent implements ClassFileTransformer {

    public final String injectedClassName = "com.eastcom.teoan.learning.spi.service.OrderHandleServiceImpl";
    public final String methodName = "handelOrder";

    @Override
    public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] classfileBuffer) throws IllegalClassFormatException {
        className = className.replace("/", ".");
        if (className.equals(injectedClassName)) {
            CtClass ctclass;
            try {
                ctclass = ClassPool.getDefault().get(className);// 使用全称,用于取得字节码类<使用javassist>
                CtMethod ctmethod = ctclass.getDeclaredMethod(methodName);// 得到这方法实例
                log.info("被注入代码块类名:[{}]",ctclass.getName());
                // 在某行 字节码 后插入代码块
//                ctmethod.insertAt(10, "");

                //方法执行前插入代码块
                ctmethod.insertBefore("log.info(\"--------------开始批量处理工单{}------------------\",orderList);");
                //用取消单的逻辑处理调整单
//                ctmethod.insertBefore("orderTypeMap.put(OrderType.调整,null);");
                //方法执行后插入代码块
                ctmethod.insertAfter("log.info(\"--------------处理工单结束------------------\");");
                return ctclass.toBytecode();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
        }
        return null;
    }
}
