package com.rootbant;

import com.rootbant.entity.SysRole;
import com.rootbant.entity.SysUser;
import com.rootbant.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;
import java.util.Date;
import java.util.List;

/**
 * Hello world!
 */
public class App {
    private static SqlSessionFactory sqlSessionFactory;

    @BeforeClass
    public static void init() throws IOException {
        Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        reader.close();
    }

    @Test
    public void  test(){
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //当selectAll在所有XML里面不唯一的时候，需要加上namespace限定
        //  sqlSession.selectList("com.rootbant.mapper.UserMapper.selectAll");
         List<SysUser> userlist= sqlSession.selectList("selectAll");

         //第一获绑定要用的接口，例如UserMapper
        //根据ID查询
        UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
//        SysUser sysUser = userMapper.selectById(1l);
//        Assert.assertNotNull(sysUser);
//        Assert.assertEquals("admin", sysUser.getUserName());
//
//        List<SysRole> sysRoles = userMapper.selectRolesByUserId(1l);
//        Assert.assertNotNull(sysRoles);
//        Assert.assertTrue(sysRoles.size() > 0);


        //插入数据
//        SysUser user=new SysUser();
//        user.setId(3l);
//        user.setCreateTime(new Date());
//        user.setHeadImg(new byte[]{1, 2, 3});
//        user.setUserEmail("11XX9990163@qq.com");
//        user.setUserInfo("text text");
//        user.setUserPassword("admin");
//        user.setUserName("admin");

//        //最原始的插入数据
//        int result = userMapper.insert(user);
//        Assert.assertEquals(1, result);
//        Assert.assertNotNull(result);
//        sqlSession.rollback();

        //插入数据用默认JDBC自己创建ID
//        int insertBack = userMapper.insertBack(user);
//        Assert.assertEquals(1, insertBack);
//        Assert.assertNotNull(user.getId());
//        sqlSession.commit();
     //   sqlSession.rollback();

//        //插入数据内嵌selectKey 标签创建ID
//        int insertBackLong = userMapper.insertBackLong(user);
//        Assert.assertEquals(1, insertBackLong);
//        Assert.assertNotNull(user.getId());
//        sqlSession.rollback();
//
//
//        //更新数据
//        SysUser upUser = userMapper.selectById(1l);
//        Assert.assertEquals("admin", upUser.getUserName());
//        upUser.setUserName("hello");
//
//        int updateResult = userMapper.updateById(upUser);
//        Assert.assertEquals(1, updateResult);
//        SysUser user1 = userMapper.selectById(1l);
//        Assert.assertEquals("hello", user1.getUserName());
//        sqlSession.rollback();
//
//        //测试删除
//        SysUser deUser = userMapper.selectById(1l);
//        int deflag = userMapper.deleteById(deUser);
//        Assert.assertEquals(1, deflag);
//        Assert.assertNull(userMapper.selectById(1l));

        //根据userid和enabled查询数据
       // List<SysRole> sysRoles = userMapper.slectRolesByUserIdAndRoleEnabled(1L, 1);


        //用对象查询数据
          SysUser user=new SysUser();user.setId(1l);
          SysRole role=new SysRole(); role.setId(1L);
          List<SysRole> sysRoles = userMapper.slectRolesByUserIdAndRoleEnabled2(user,role);
        Assert.assertTrue(sysRoles.size() > 0);

        sqlSession.close();
    }

}
