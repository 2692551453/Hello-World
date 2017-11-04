package com.service;

import java.util.ArrayList;
import java.util.List;

import com.dao.MessageDao;
/*
 * 维护的相关功能
 */
public class Maintainservice {
	
  public void deleteOne(String id) {
	  if(id != null && !"".equals(id.trim())) {
		  MessageDao messageDao = new MessageDao();
		  messageDao.deleteOne(Integer.valueOf(id));
	  }
  }
  
  public void deleteBatch(String[] ids) {
	  MessageDao messageDao = new MessageDao();
	  List<Integer> list = new ArrayList<Integer>();
	  for(String id:ids) {
		  list.add(Integer.valueOf(id));
	  }
	  messageDao.deleteBatch(list);
  }
}
