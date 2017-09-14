package com.bw.repostory;


import com.bw.bean.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

/**
 * Created by lenovo on 2017/8/1.
 */
public interface TeacherRepostory extends JpaRepository<Teacher, Integer> {

    /**
     * 登录校验
     */

    Teacher findAllByNameAndPwd(String name,String pwd);


    /**
     * 修改用户信息
     */
    @Transactional
    @Modifying
    @Query("update Teacher f set f.name = ?1,f.pwd=?2 where f.id=?3")
    void  modifyById(String name,String pwd,Integer id);



}
