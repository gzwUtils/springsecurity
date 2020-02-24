package com.ddxx.demo.dao;

import java.util.List;


import com.ddxx.demo.domain.AccountInfo;

public interface AccountInfoDao  {
    List<AccountInfo> getOnePageData(AccountInfo account_Info,Integer PageSize,Integer PageIndex) ;
    Integer insertAccountInfo(AccountInfo accountInfomation);
}
