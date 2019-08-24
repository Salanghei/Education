package cn.edu.hit.ices.yang.service;

import cn.edu.hit.ices.yang.mapper.FriendMapper;
import cn.edu.hit.ices.yang.model.Friend;
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
}
