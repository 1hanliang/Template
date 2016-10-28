package com.hebrf.template.mvp.model.api.service;

import javax.inject.Inject;

/**
 * Created by Administrator on 2016/10/24.
 */
public class ServiceManager extends BaseServiceManager {
    private CommonService mCommonService;

    /**
     * 如果需要添加service只需在构造方法中添加对应的service,
     * 在提供get方法返回出去,只要在ServiceModule提供了该service
     * Dagger2会自行注入
     * @param commonService
     */
    @Inject
    public ServiceManager(CommonService commonService){
        this.mCommonService = commonService;
    }

    public CommonService getCommonService() {
        return mCommonService;
    }
}
