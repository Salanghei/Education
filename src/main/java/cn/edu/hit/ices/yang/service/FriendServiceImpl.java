package cn.edu.hit.ices.yang.service;

import cn.edu.hit.ices.yang.mapper.FriendMapper;
import cn.edu.hit.ices.yang.model.Friend;
import cn.edu.hit.ices.yang.model.FriendApply;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class FriendServiceImpl implements FriendService{
    @Resource
    private FriendMapper friendMapper;

    @Override
    public List<Friend> getFriendByUid(int userid){
        try{
            return friendMapper.selectFriendByUid(userid);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Integer> getFIdByUid(int userid){
        try{
            return friendMapper.selectFIdByUid(userid);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public int getFriendCountByUid(int userid){
        try{
            return friendMapper.selectFriendCountByUid(userid);
        }catch (Exception e){
            e.printStackTrace();
            return -1;
        }
    }

    @Override
    public List<FriendApply> getToPassFriendApplyByUid(int userid){
        try{
            return friendMapper.selectToPassFriendApplyByUid(userid);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
