package com.zungen.wb.module.system.api.dept;

import com.zungen.wb.module.system.service.dept.PostService;
import org.apache.dubbo.config.annotation.Service;

import javax.annotation.Resource;
import java.util.Collection;

/**
 * 岗位 API 实现类
 *
 * @author admin
 */
@Service
public class PostApiImpl implements PostApi {

    @Resource
    private PostService postService;

    @Override
    public void validPosts(Collection<Long> ids) {
        postService.validPosts(ids);
    }
}
