package com.hkl.school.service.impl;

import com.hkl.school.dao.MessageMapper;
import com.hkl.school.pojo.Message;
import com.hkl.school.pojo.MessageExample;
import com.hkl.school.pojo.dto.MessageDTO;
import com.hkl.school.service.StudentIndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * author:zwy
 * Date:2018/10/16
 * Time:15:46
 */
@Service
public class StudentIndexServiceImpl implements StudentIndexService {

    @Autowired
    private MessageMapper messageMapper;

    @Override
    public int countNotReadMsg(Long uid, Byte status) {
        MessageExample example = new MessageExample();
        example.createCriteria().andReceiverEqualTo(uid).andStatusEqualTo(status);
        return messageMapper.countByExample(example);
    }

    @Override
    public List<Message> getByUid(Long uid) {
        MessageExample example = new MessageExample();
        Byte b = 1;
        example.createCriteria().andReceiverEqualTo(uid).andStatusEqualTo(b);
        return messageMapper.selectByExample(example);
    }

    @Override
    public void updateMessageStatus(Long mid, Byte status) {
        Message message = new Message();
        message.setId(mid);
        message.setStatus(status);
        messageMapper.updateByPrimaryKeySelective(message);
    }

    @Override
    public void sendMessage(Long senderid, Long receiverid, String content) {
        Message message = new Message();
        message.setSender(senderid);
        message.setReceiver(receiverid);
        message.setContent(content);
        messageMapper.insertSelective(message);
    }

    @Override
    public MessageDTO getDTOByMid(Long mid) {
        return messageMapper.selectByMid(mid);
    }
}
