package com.ddxx.demo.controller;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ddxx.demo.domain.AccountInfo;
import com.ddxx.demo.service.AccountInfoService;

@Controller
public class AccountInfoController {
   @Autowired
	private  AccountInfoService accountInfoService;

   
   
public AccountInfoService getAccountInfoService() {
	return accountInfoService;
}
public void setAccountInfoService(AccountInfoService accountInfoService) {
	this.accountInfoService = accountInfoService;
}
@RequestMapping("kgdl/*")
  void getAllAccountByContion(AccountInfo  accountInfo,ModelMap map, Integer PageIndex,Integer PageSize) {
	 if(PageIndex==null) {
		 PageIndex=1;
	 }
	 if(PageSize==null) {
		 PageSize=1;
	 }
	List<AccountInfo> pagelist=accountInfoService.selectAllAccountInfo(PageIndex, PageSize, accountInfo);
	map.put("page", pagelist);
	
	
  }
Integer addAccountInfomation(AccountInfo accountInfomation){
	Integer count=accountInfoService.addAccountInfo(accountInfomation);
	return count;
};

  
}
