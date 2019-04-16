package com.n2o2l.ghg.mapper;

import com.n2o2l.ghg.entity.SearchCode;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author n2o2l
 * @since 2019-01-13
 */
public interface SearchCodeMapper extends BaseMapper<SearchCode> {

    int byHashcode(int hashcode);

}
