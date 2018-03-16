package ranger.algorithm.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class Main {

    /**
     * 一般背包问题的代码实现
     *
     * @param w：每个物体重量的数组
     * @param p：每个物体收益的数组
     * @param m：背包载重
     * @return 结果集（放入哪几个物体、每个物体放入多少部分）
     */
    List<Body> commonPackage(int[] w, int[] p, int m) {

        // 构造物体对象列表（将入参存储在List<Body>中）
        List<Body> bodys = new ArrayList<>();
        for (int i = 0; i < w.length; i++) {
            bodys.add(new Body(w[i], p[i]));
        }

        // 对性价比排序（从高到低排序）
        Collections.sort(bodys, new Comparator<Body>() {
            public int compare(Body b1, Body b2) {
                return b2.p / b2.w - b1.p / b1.w;
            }
        });
        // 将物体按照性价比从高到低依次加入背包
        int rest = m;// 剩余重量
        int i = 0;
        List<Body> results = new ArrayList<>();// 存放结果集
        for (; i < bodys.size(); i++) {
            if (rest < bodys.get(i).w)
                break;
            Body curBody = bodys.get(i);
            results.add(curBody);
            rest -= curBody.w;
        }
        // 计算最后一个物体能放入的部分
        Body lastBody = bodys.get(i);
        results.add(new Body(lastBody.id, rest, (lastBody.p * rest / lastBody.w)));
        return results;
    }

}
