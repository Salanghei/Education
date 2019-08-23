package cn.edu.hit.ices.yang.service;

import cn.edu.hit.ices.yang.model.Friend;

import java.util.List;

public interface FriendService {
    List<Friend> getFriendByUid(int userid);
}
