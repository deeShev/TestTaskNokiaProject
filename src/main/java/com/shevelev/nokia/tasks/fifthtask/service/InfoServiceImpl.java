package com.shevelev.nokia.tasks.fifthtask.service;

import com.shevelev.nokia.tasks.fourthtask.company.DeeShevFuncCompany;
import com.shevelev.nokia.tasks.fourthtask.employee.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InfoServiceImpl implements InfoService {
    private static final Logger LOG = LoggerFactory.getLogger(InfoServiceImpl.class);
    private DeeShevFuncCompany deeShevFuncCompany;

    @Autowired
    public InfoServiceImpl(DeeShevFuncCompany deeShevFuncCompany) {
        this.deeShevFuncCompany = deeShevFuncCompany;
    }

    @Override
    public String getInfoEmployee(Employee employee) {
        String resp;
        if (deeShevFuncCompany.getStaff().contains(employee)){
            resp = deeShevFuncCompany.infoEmployee(employee);
        }else {
            LOG.info("There is no such employee:" + employee);
            resp = null;
        }
        return resp;
    }
}
