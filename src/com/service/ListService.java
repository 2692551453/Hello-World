package com.service;

import java.util.List;

import com.bean.Message;
import com.dao.MessageDao;

public class ListService {
	public List<Message> queryMessageList(String command,String description ){
		MessageDao messageDao = new MessageDao();
		return messageDao.queryMessageList(command, description);
	}
}
