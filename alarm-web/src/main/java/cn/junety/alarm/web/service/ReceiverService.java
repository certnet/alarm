package cn.junety.alarm.web.service;

import cn.junety.alarm.base.entity.Receiver;
import cn.junety.alarm.web.dao.ReceiverDao;
import cn.junety.alarm.web.vo.ReceiverSearch;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by caijt on 2017/3/27.
 */
@Service
public class ReceiverService {

    private static final Logger logger = LoggerFactory.getLogger(ReceiverService.class);

    @Autowired
    private ReceiverDao receiverDao;

    /**
     * 获取接收者列表
     * @param receiverSearch
     * @return
     */
    public List<Receiver> getReceiverList(ReceiverSearch receiverSearch) {
        if(receiverSearch.getName() != null) {
            return receiverDao.getReceiverByName(receiverSearch);
        } else if(receiverSearch.getMail() != null) {
            return receiverDao.getReceiverByMail(receiverSearch);
        } else if(receiverSearch.getPhone() != null){
            return receiverDao.getReceiverByPhone(receiverSearch);
        } else if(receiverSearch.getWechat() != null) {
            return receiverDao.getReceiverByWechat(receiverSearch);
        } else if(receiverSearch.getQq() != null) {
            return receiverDao.getReceiverByQq(receiverSearch);
        } else {
            return receiverDao.getReceiver(receiverSearch);
        }
    }

    /**
     * 获取接收者列表的长度，用于分页
     * @param receiverSearch
     * @return
     */
    public int getReceiverCount(ReceiverSearch receiverSearch) {
        if(receiverSearch.getName() != null) {
            return receiverDao.getReceiverCountByName(receiverSearch);
        } else if(receiverSearch.getMail() != null) {
            return receiverDao.getReceiverCountByMail(receiverSearch);
        } else if(receiverSearch.getPhone() != null){
            return receiverDao.getReceiverCountByPhone(receiverSearch);
        } else if(receiverSearch.getWechat() != null) {
            return receiverDao.getReceiverCountByWechat(receiverSearch);
        } else if(receiverSearch.getQq() != null) {
            return receiverDao.getReceiverCountByQq(receiverSearch);
        } else {
            return receiverDao.getReceiverCount();
        }
    }

    /**
     * 创建用户
     * @param receiver
     * @return
     */
    public int createReceiver(Receiver receiver) {
        return receiverDao.save(receiver);
    }

    /**
     * 删除用户
     * @param id
     * @return
     */
    public int deleteReceiver(int id) {
        return receiverDao.deleteById(id);
    }

    /**
     * 更新用户信息
     * @param receiver
     * @return
     */
    public int updateReceiver(Receiver receiver) {
        return receiverDao.updateById(receiver);
    }

    /**
     * 根据接收者id获取接收者信息
     * @param id
     * @return
     */
    public Receiver getReceiverById(int id) {
        return receiverDao.getReceiverById(id);
    }
}
