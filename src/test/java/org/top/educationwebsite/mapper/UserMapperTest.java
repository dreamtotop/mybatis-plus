package org.top.educationwebsite.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.top.educationwebsite.model.User;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
public class UserMapperTest {

    @Resource
    private UserMapper userMapper;

    @Test
    public void test() {
        User user = new User();
        user.setName("岳不群");
        user.setAge(20);
        user.setEmail("134@qq.com");
        userMapper.insert(user);
    }

    @Test
    public void update() {
        User user = new User();
        user.setId(1273112171424825345l);
        user.setAge(30);
        userMapper.updateById(user);
    }

    /**
     * 测试乐观锁插件
     */
    @Test
    public void testOps() {
        User user = userMapper.selectById(1273112171424825345l);
        user.setAge(120);
        userMapper.updateById(user);
    }

    /**
     * 测试分页插件
     */
    @Test
    public void testPage(){
        //参数  当前页  和   分页大小
        Page page = new Page(1,1);
        userMapper.selectPage(page,null);
        System.out.println(page.getTotal());
        System.out.println(page.getCurrent());
        System.out.println(page.getPages());
        System.out.println(page.getRecords().toString());
    }


    /**
     * 测试逻辑删除
     */
    @Test
    public void testDel(){
        userMapper.deleteById(1273112171424825345l);
    }

    @Test
    public void testSelect(){
        List<User> users = userMapper.selectList(null);
        System.out.println(users.size());
    }

    /**
     * 测试包装条件查询
     */
    @Test
    public void testWrapper(){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        // ge gt le lt  大于等于 大于  小于等于  小于
//        wrapper.le("create_time", LocalDateTime.now());
//        List<User> users = userMapper.selectList(wrapper);
//        System.out.println(users);

        // eq 等于  ne 不等于
//        wrapper.eq("name","jack");
//        User user = userMapper.selectOne(wrapper);
//        System.out.println(user);


        //between

        // like

        //orderByDesc

        //last 拼接sql语句
//        wrapper.last("limit 1");


        //select 指定查询的列
        wrapper.eq("name","jack");
        wrapper.select("name","age");
        User user = userMapper.selectOne(wrapper);
        System.out.println(user);

    }
}