package com.teoan;

import org.apache.commons.collections4.MapUtils;
import org.dromara.hutool.core.collection.CollUtil;
import org.dromara.hutool.core.io.file.FileUtil;
import org.dromara.hutool.core.map.MapUtil;
import org.dromara.hutool.core.text.StrUtil;
import org.dromara.hutool.poi.excel.ExcelReader;
import org.dromara.hutool.poi.excel.ExcelUtil;
import org.dromara.hutool.poi.excel.ExcelWriter;

import java.lang.reflect.Executable;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * @author zhuangjy
 * @since 2024/4/25 下午4:26
 */
public class Main {
    public static void main(String[] args) {



        String cmpUrl = "[](http://10.51.167.232/#/iaas/instance/instance-detail?_L=3&_mid=2cb517a8-3bb9-4a69-\n" +
                "aa9a-e56cba44bd95&_pst=_&canManger=true&id=26c0ff9e-9408-46f1-b851-fdcbc8491e6d&isAdmin=false&isApply=true&projectType=apply)\",";
        String regex = "&id=([a-zA-Z0-9-]+)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(cmpUrl);
        if(matcher.find()){
            String group = matcher.group().split("=")[1];
            System.out.println(group);


        }






//        ExcelReader expData = ExcelUtil.getReader(FileUtil.file("/Users/teoan/Downloads/全量API梳理.xlsx"),"expdata");
//        ExcelReader reader = ExcelUtil.getReader(FileUtil.file("/Users/teoan/Downloads/全量API梳理.xlsx"),"cmp-monitor-aggregator-extend");
//        ExcelWriter writer = ExcelUtil.getWriter(FileUtil.file("/Users/teoan/Downloads/全量API梳理.xlsx"),"Sheet4");
//        List<Map<String, Object>> expDataMaps = expData.readAll();
//        // 构建映射map
//        Map<String, Map<String, Object>> pathMap = expDataMaps.stream().filter(map -> {
//            String ppName = MapUtil.getStr(map, "PPNAME");
//            return StrUtil.isNotBlank(ppName);
//        }).collect(Collectors.toMap(map -> {
//            String url = MapUtil.getStr(map, "URL");
//            return url.split("/", 2)[1].trim();
//        }, map -> map, (k1, k2) -> k1));
//        List<List<Object>> read = reader.read();
//        read.removeFirst();
//        List<List<Object>> rows = read.stream().peek(list -> {
//            String path = String.valueOf(list.getFirst()).split("/", 2)[1].trim();
//            Map<String, Object> map = pathMap.getOrDefault(path, MapUtil.newHashMap());
//            if(CollUtil.isNotEmpty(map)){
//                list.add("是");
//                list.addAll(map.values());
//            }
//        }).toList();
//        writer.write(rows);
//        writer.close();
//        test();
    }




    private static void test(){
        ExcelReader expData = ExcelUtil.getReader(FileUtil.file("/Users/teoan/Downloads/sqls_0426_order_full.xlsx"),"0");
        ExcelWriter writer = ExcelUtil.getWriter(FileUtil.file("/Users/teoan/Downloads/sqls_0426_order_full.xlsx"),"Sheet1");
//        Set<String> sheetNameSet = expData.readAll().stream().map(map -> {
//            String sheetName = MapUtil.getStr(map, "api工程");
//            if(sheetName.trim().equals("cmp")){
//                String split = "\\\\";
//                sheetName = MapUtil.getStr(map, "api文件").split(split)[1];
//            }
//            return sheetName;
//        }).filter(StrUtil::isNotBlank).collect(Collectors.toSet());

        Map<String, List<Map<String, Object>>> expDataMap = expData.readAll().stream().filter(map -> {
            String sheetName = MapUtil.getStr(map, "api工程");
            if (sheetName.trim().equals("cmp")) {
                String split = "\\\\";
                sheetName = MapUtil.getStr(map, "api文件").split(split)[1];
            }
            return StrUtil.isNotBlank(sheetName);
        }).collect(Collectors.groupingBy(map -> {
            String sheetName = MapUtil.getStr(map, "api工程");
            if (sheetName.trim().equals("cmp")) {
                String split = "\\\\";
                sheetName = MapUtil.getStr(map, "api文件").split(split)[1];
            }
            return sheetName;
        }));

        List<String> tmpTitle = expData.setSheet("tmp").read().getFirst().stream().map(String::valueOf).toList();
        // 获取字母表头
        Set<String> titleSet = tmpTitle.stream().filter(s -> !containsChinese(String.valueOf(s))).map(String::valueOf).collect(Collectors.toSet());
        LinkedHashMap<String, String> titleMap = new LinkedHashMap<>();
        tmpTitle.forEach(s -> {
            titleMap.put(s,"");
        });
        expDataMap.forEach((k, v) -> {
            writer.setSheet(k);
            List<Map<String, Object>> writeData = v.stream().map(stringObjectMap -> {
                Map<String,Object> newTmp = new LinkedHashMap<>(titleMap);
                newTmp.replace("接口",stringObjectMap.get("sqlId"));
                String isHorizontalOverstepping = MapUtil.getStr(stringObjectMap,"sql内容").contains("@kissuSecurity")?"是":"否";
                newTmp.replace("是否已控制水平越权",isHorizontalOverstepping);
                stringObjectMap.forEach((k1, v1) -> {
                    if(titleSet.contains(k1)){
                     newTmp.replace(k1,v1);
                    }
                });
                return newTmp;
            }).toList();
            writer.write(writeData,true);
        });
        writer.close();
    }


    public static boolean containsChinese(String input) {
        String chineseRegex = "[\\u4e00-\\u9fa5]";
        return input.matches(".*" + chineseRegex + ".*");
    }
}



