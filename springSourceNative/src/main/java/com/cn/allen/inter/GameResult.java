package com.cn.allen.inter;

/**
 * @Author:ZhangWeiWei
 * @Date:2021/1/21
 * @Description:
 * 小年活动测试结果
 */
public class GameResult {

    /**
     * 结果标识
     */
    private Integer id;

    /**
     * 结果名称
     */
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public GameResult() {
    }

    public GameResult(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "GameResult{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
