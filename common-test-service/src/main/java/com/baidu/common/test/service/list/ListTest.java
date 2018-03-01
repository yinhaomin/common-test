package com.baidu.common.test.service.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.google.common.collect.Lists;

public class ListTest {

    public static void main(String[] args) {

        List<MidwayWhiteCatBo> list = Lists.newArrayList();
        MidwayWhiteCatBo m1 = new MidwayWhiteCatBo();
        m1.setId(1001L);
        m1.setName("科学");

        MidwayWhiteCatBo m2 = new MidwayWhiteCatBo();
        m2.setId(1002L);
        m2.setName("宗教");

        list.add(m1);
        list.add(m2);

        System.out.println(list);

        // List<String> strs = Lists.newArrayList();
        // strs.add("Science");
        // strs.add("Technology");
        // System.out.println(strs);

        String cateStr = "MidwayWhiteCatBo(id=1001,name=娱乐).1002,体育.1003,图片.1004,IT.1005,手机.1006,财经.1007,汽车."
                + "1008,房产.1009,时尚.1010,购物.1011,文化.1012,军事.1013,科技.1014,健康."
                + "1015,母婴.1016,社会.1017,美食.1018,家居.1019,游戏.1020,历史.1021,时政."
                + "1024,美女.1025,搞笑.1026,猎奇.1027,旅游.1028,动物.1029,萌宠.1030,摄影." + "1031,动漫.1032,女人.1033,生活";

        String[] dataArray = cateStr.split(".");
        List<MidwayWhiteCatBo> midwayCatWhitelist = new ArrayList<MidwayWhiteCatBo>();
//        Collections.addAll(midwayCatWhitelist, dataArray);
        System.out.println(midwayCatWhitelist);

    }

}
