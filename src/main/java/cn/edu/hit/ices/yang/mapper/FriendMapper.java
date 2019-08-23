package cn.edu.hit.ices.yang.mapper;

import cn.edu.hit.ices.yang.model.Friend;

import java.util.List;

public interface FriendMapper {
    List<Friend> selectFriendByUid(int userid);
}
