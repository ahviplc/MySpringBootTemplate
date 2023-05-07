package com.lc.myInterface;

import cn.hutool.log.StaticLog;
import com.mybatisflex.core.audit.AuditMessage;
import com.mybatisflex.core.audit.MessageReporter;

import java.util.List;

public class MyMessageReporter implements MessageReporter {

    @Override
    public void sendMessages(List<AuditMessage> messages) {
        // 在这里把 messages 审计日志发送到指定位置
        // 写入日志文件
        for (AuditMessage message : messages) {
            //System.out.println(">>>>>>Flex Sql Audit: " + message.toString());
            StaticLog.info(">>>>>> Flex Sql Audit => {} | FullSql => 【{}】", message.toString(), message.getFullSql());
        }
    }
}
