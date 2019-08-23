package cn.edu.hit.ices.yang.mapper;

import cn.edu.hit.ices.yang.model.User;
import org.springframework.stereotype.Repository;

@Repository("userMapper")
public interface UserMapper {
    User selectUserByUserName(String email);
}
