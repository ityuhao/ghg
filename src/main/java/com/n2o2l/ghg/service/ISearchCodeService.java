package com.n2o2l.ghg.service;

import com.n2o2l.ghg.entity.SearchCode;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author n2o2l
 * @since 2019-01-13
 */
public interface ISearchCodeService extends IService<SearchCode> {

    Boolean build(String q);

}
