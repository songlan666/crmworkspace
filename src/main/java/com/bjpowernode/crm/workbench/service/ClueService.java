package com.bjpowernode.crm.workbench.service;

import com.bjpowernode.crm.workbench.domain.Clue;
import com.bjpowernode.crm.workbench.domain.Tran;

import javax.servlet.http.HttpServletRequest;

public interface ClueService {
    boolean save(Clue c);

    Clue detail(String id);

    boolean unbound(String id);

    boolean bound(String cid, String[] aids);


    boolean convert(String clueId, Tran t,String createBy);
}
