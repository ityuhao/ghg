package com.n2o2l.ghg.service;

import com.n2o2l.ghg.GhgApplicationTests;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

public class SearchCodeServiceTest extends GhgApplicationTests {

    @Autowired
    private ISearchCodeService service;

    @Test
    public void test(){
        Boolean build = service.build("bj-cdb-0srt3yo9.sql.tencentcdb.com");
    }

}