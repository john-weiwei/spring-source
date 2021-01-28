package com.cn.allen.inter;


import java.util.Map;

/**
 * @Author:ZhangWeiWei
 * @Date:2021/1/22
 * @Description:
 */
@FunctionalInterface
public interface Repository {

    //南方游戏结果编码
    //地道的南方人
    String TUNNEL_SOUTH_CODE = "011,012,110,111,112,020,021,022,120,121,122,220,221";
    //假的南方人
    String FAKE_SOUTH_CODE = "001,002,100,010";
    //从北方来的卧底
    String UNDERCOVER_SOUTH_CODE = "101,102,200,201,202,210,211,212";

    //北方方游戏结果编码
    //地道的北方人
    String TUNNEL_NORTH_CODE = "101,102,110,111,112,200,201,202,210,211,212,220,221";
    //假的北方人
    String FAKE_NORTH_CODE = "100,010,001,002";
    //从南方来的卧底
    String UNDERCOVER_NORTH_CODE = "011,012,020,021,022,120,121,122";

    //火星人
    String MARTIAN_SOUTH_CODE = "000";
    //南北混血人
    String MIXED_RACE_SOUTH_CODE = "222";

    GameResult getGameResult(String key);

    //默认接口实现
    default void parse(String gameResultCode, GameResult gameResult, Map<String, GameResult> map) {
        String[] keys = gameResultCode.split(",");
        for (String key : keys) {
            map.put(key, gameResult);
        }
    };
}
