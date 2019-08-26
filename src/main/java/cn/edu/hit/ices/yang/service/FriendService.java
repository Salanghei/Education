package cn.edu.hit.ices.yang.service;

import cn.edu.hit.ices.yang.model.Friend;
import cn.edu.hit.ices.yang.model.FriendApply;

import java.util.List;

public interface FriendService {
    List<Friend> getFriendByUid(int userid);

    List<Integer> getFIdByUid(int userid);

    int getFriendCountByUid(int userid);

    List<FriendApply> getToPassFriendApplyByUid(int userid);
}
