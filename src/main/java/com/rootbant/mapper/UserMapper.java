package com.rootbant.mapper;

import com.rootbant.entity.SysRole;
import com.rootbant.entity.SysUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Program: mybatis
 * @Description
 * @Author: Stephen
 * @Create: 2019-07-22 17:58
 **/
public interface UserMapper {
    /**
     * 通过ID查询用户
     * @param id
     * @return
     */
    SysUser selectById(Long id);

    /**
     * 查询所有用户
     * @return
     */
    List<SysUser> selectAll();

    /**
     * 根据用户 id 获取角色信息
     *
     * @param userId
     * @return
     */
    List<SysRole> selectRolesByUserId(Long userId);

    /**
     * 插入用户数据 返回的int是影响的行数
     * @param sysUser
     * @return
     */
    int insert(SysUser sysUser);

    /**
     * 插入用户数据，ＩD 设置的是数据库的递增
     * @param sysUser
     * @return
     */

    int insertBack(SysUser sysUser);

    /**
     *  插入用户数据，采用标签selectkey回填sysUser
     * @param sysUser
     * @return
     */

    int insertBackLong(SysUser sysUser);

    /**
     * 更新数据
     * @param sysUser
     * @return
     */
    int updateById(SysUser sysUser);

    int deleteById(SysUser sysUser);

    List<SysRole> slectRolesByUserIdAndRoleEnabled( Long userId, Integer enabled);

    //List<SysRole> slectRolesByUserIdAndRoleEnabled(@param("userId") Long userId,@param("enabled") Integer enabled);

    List<SysRole> slectRolesByUserIdAndRoleEnabled2( @Param("user") SysUser user, @Param("role") SysRole role);

}
