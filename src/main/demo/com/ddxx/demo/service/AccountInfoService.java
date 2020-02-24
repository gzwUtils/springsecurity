package com.ddxx.demo.service;


import java.util.List;

import com.ddxx.demo.domain.AccountInfo;


public interface AccountInfoService {
   List<AccountInfo>  selectAllAccountInfo(Integer PageIndex, Integer PageSize,AccountInfo account_Info);
   Integer addAccountInfo(AccountInfo accountInfo);
}
