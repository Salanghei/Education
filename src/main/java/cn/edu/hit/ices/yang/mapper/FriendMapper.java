package cn.edu.hit.ices.yang.mapper;

import cn.edu.hit.ices.yang.model.Friend;
import cn.edu.hit.ices.yang.model.FriendApply;

import java.util.List;

public interface FriendMapper {
    List<Friend> selectFriendByUid(int userid);

    List<Integer> selectFIdByUid(int userid);

    List<Double> selectTrustByUid(int userid);

    int selectFriendCountByUid(int userid);

    List<FriendApply> selectToPassFriendApplyByUid(int userid);
}
