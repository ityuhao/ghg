package com.n2o2l.ghg.service;

import cn.hutool.core.codec.Base64;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.toolkit.SystemClock;
import com.mzlion.easyokhttp.HttpClient;
import com.mzlion.easyokhttp.request.GetRequest;
import com.n2o2l.ghg.dto.searchCode.Items;
import com.n2o2l.ghg.dto.searchCode.RootBean;
import com.n2o2l.ghg.entity.SearchCode;
import com.n2o2l.ghg.mapper.SearchCodeMapper;
import com.n2o2l.ghg.service.ISearchCodeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author n2o2l
 * @since 2019-01-13
 */
@Service
@Slf4j
public class SearchCodeServiceImpl extends ServiceImpl<SearchCodeMapper, SearchCode> implements ISearchCodeService {


    @Override
    public Boolean build(String q) {
        String url = "https://api.github.com/search/code";
        long page = 10;
        long per_page = 50;
        String github_username = "github账号";
        String github_password = "github密码";
        String authString = github_username + ":" + github_password;
        String authStringEncode = Base64.encode(authString.getBytes());
        while (true) {
            String content = HttpClient.get(url)
                    .queryString("q", q)
                    .queryString("page", page)
                    .queryString("per_page", per_page).header("Authorization", "Basic " + authStringEncode)
                    .asString();
            RootBean rootBean = JSONObject.parseObject(content, RootBean.class);
            List<Items> items = rootBean.getItems();
            if (CollUtil.isEmpty(items)) break;
            page++;
            if (page == 21) break;
            // db
//            List<SearchCode> list = new ArrayList<>();
            for (Items item : items){
                String downloads_url = item.getRepository().getDownloads_url();
                int hashcode = downloads_url.hashCode();
                int row = this.baseMapper.byHashcode(hashcode);
                if (row != 0) continue;
                SearchCode searchCode = new SearchCode();
                searchCode.setContent(JSONObject.toJSONString(item));
                searchCode.setDownloadsUrl(downloads_url);
                searchCode.setHashcode(hashcode);
//                searchCode.setDownloadsUrlContent(HttpClient.get(downloads_url).asString());
                searchCode.setQ(q);
//                list.add(searchCode);
                LocalDateTime now = LocalDateTime.now();
                searchCode.setCreateTime(now);
                searchCode.setLastModifiedTime(now);
                try {
                    this.save(searchCode);
                }catch (Exception e){
                    log.error("插入数据库异常",e);
                }

            }
//            try {
//                log.info("休眠2秒调用,now:{}",SystemClock.now());
//                Thread.sleep(2000);
//            }catch (Exception e){
//                log.error("线程休眠异常");
//            }
        }
        return true;
    }
}
