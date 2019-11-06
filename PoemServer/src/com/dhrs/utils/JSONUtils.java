package com.dhrs.utils;

import com.dhrs.domain.Attraction;
import com.dhrs.domain.Poem;
import com.dhrs.domain.Poet;

import java.util.*;

public class JSONUtils {
    public static List<Map<String, String>> PackagePoemsData(Attraction attraction){
        List<Map<String, String>> res = new ArrayList<>();
        Set<Poem> poems = attraction.getPoems();
        for (Poem poem : poems) {
            Map<String, String> map = new HashMap<>();
            Poet poet = poem.getPoet();
            map.put("title", poem.getPoemTitle());
            map.put("dynasty", poet.getDynasty());
            map.put("author", poet.getPoetName());
            map.put("content", poem.getPoemText());
            if(attraction != null) {
                map.put("scene", attraction.getAttractionName());
            }
            res.add(map);
        }
        return res;
    }

    public static Map<String, String> PoemToJson(Poem poem){
        Map<String, String> map = new HashMap<>();
        map.put("title", poem.getPoemTitle());
        map.put("dynasty", poem.getPoet().getDynasty());
        map.put("author", poem.getPoet().getPoetName());
        map.put("content", poem.getPoemText());
        return map;
    }

    public static String MapToJson(Map<String, String> map){
        StringBuffer sb = new StringBuffer();
        sb.append("{");
        boolean flag = false;
        for(Map.Entry<String, String> entry : map.entrySet()){
            if(!flag){
                flag = true;
            }
            String tmp = "\"" + entry.getKey() + "\" : \"" + entry.getValue() + "\",";
            sb.append(tmp);
        }
        if(flag) {
            sb.deleteCharAt(sb.length() - 1);
        }
        sb.append("}");
        return sb.toString();
    }

    public static String ListToJson(List<Map<String, String>> list){
        StringBuffer sb = new StringBuffer();
        sb.append("[");
        for (int i = 0; i < list.size(); i++) {
            if(i == 0){
                sb.append(MapToJson(list.get(i)));
            }else{
                sb.append(",");
                sb.append(MapToJson(list.get(i)));
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
