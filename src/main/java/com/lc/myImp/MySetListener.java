package com.lc.myImp;

import cn.hutool.log.StaticLog;
import com.mybatisflex.annotation.SetListener;

/**
 * @Table 注解 onSet 使用监听器
 * https://mybatis-flex.com/zh/core/table.html#onset
 */
public class MySetListener implements SetListener {

    @Override
    public Object onSet(Object entity, String property, Object value) {
        //场景1：用于检测当前账户是否拥有该字段权限，
        //      有正常返回 value，没有权限返回 null


        //场景2：entity 中可能定义某个业务值
        //      当监听到某个字段被赋值了，这
        //      里可以主动去给另外的其他字段赋值


        //场景3：内容转换和二次加工，对 value 值进行修改后返回

        Object newValue = value + "|new";

        StaticLog.info("===> MySetListener onSet监听器 entity => 【{}】 | property => 【{}】 | old value => 【{}】 | new value => 【{}】", entity, property, value, newValue);

        // return newValue;
        return value;
    }
}
