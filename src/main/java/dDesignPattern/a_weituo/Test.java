package dDesignPattern.a_weituo;

import java.util.Date;

/**
 * <pre>
 * 1、通過反射的机制获取委托对象的暴露接口
 * 2、通知者通过统一调用事件的反射机制，通知所有类
 *
 * </pre>
 *
 * @Author Bllose
 * @Date 2020/1/5 11:09
 */
public class Test {

    public static void main(String[] args) {
        //创建一个尽职尽责的放哨者   
        Notifier goodNotifier = new GoodNotifier();

        //创建一个玩游戏的同学，开始玩游戏
        PlayingGameListener playingGameListener = new PlayingGameListener();
        //创建一个看电视的同学，开始看电视
        WatchingTVListener watchingTVListener = new WatchingTVListener();
        //玩游戏的同学告诉放哨的同学，老师来了告诉一下
        goodNotifier.addListener(playingGameListener, "stopPlayingGame", new Date());
        //看电视的同学告诉放哨的同学，老师来了告诉一下
        goodNotifier.addListener(watchingTVListener, "stopWatchingTV", new Date());
        try {
            //一点时间后
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //老师出现，放哨的人通知所有要帮忙的同学:老师来了
        goodNotifier.notifyX();

    }
}
