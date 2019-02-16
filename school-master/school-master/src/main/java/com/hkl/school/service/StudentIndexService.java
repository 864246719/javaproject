package com.hkl.school.service;

import com.hkl.school.pojo.Message;
import com.hkl.school.pojo.dto.MessageDTO;

import java.util.List;

/**
 * author:hkl
 * Date:2018/10/16
 * Time:15:23
 */
public interface StudentIndexService {

    /**
     * 统计未读的信息
     * @param uid
     * @param status
     * @return
     */
    int countNotReadMsg(Long uid,Byte status);

    /**
     * 根据用户id获得消息
     * @param uid
     * @return
     */
    List<Message> getByUid(Long uid);

    /**
     * 更新信息状态
     * @param mid   信息的id
     * @param status
     */
    void updateMessageStatus(Long mid,Byte status);

    /**
     * 发送信息
     * @param senderid  发送人id
     * @param receiverid    接收人id
     * @param content   内容
     */
    void sendMessage(Long senderid,Long receiverid,String content);

    /**
     * 获得messageDTO
     * @param mid   信息id
     * @return
     */
    MessageDTO getDTOByMid(Long mid);
}
