package com.ddxx.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ddxx.demo.dao.AccountInfoDao;
import com.ddxx.demo.domain.AccountInfo;
import com.ddxx.demo.service.AccountInfoService;
import com.github.pagehelper.PageHelper;
@Service
public class AccountInfoServiceImpl implements AccountInfoService {
	@Autowired
   private AccountInfoDao  accountInfoDao;
	public AccountInfoDao getAccountInfoDao() {
		return accountInfoDao;
	}


	public void setAccountInfoDao(AccountInfoDao accountInfoDao) {
		this.accountInfoDao = accountInfoDao;
	}


	@Override
	public List<AccountInfo> selectAllAccountInfo(Integer PageIndex, Integer PageSize,AccountInfo account_Info) {
		PageHelper.startPage(PageIndex,PageSize);
		List<AccountInfo>   list=accountInfoDao.getOnePageData(account_Info,PageIndex,PageSize);
		return list;
	}


	@Override
	public Integer addAccountInfo(AccountInfo accountInfo) {
		return accountInfoDao.insertAccountInfo(accountInfo);
	}


	

}
