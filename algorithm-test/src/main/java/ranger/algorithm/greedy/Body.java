package ranger.algorithm.greedy;

public class Body {
    int id;//物品的序号
    int w; //物体的重量
    int p ; //物体的价值

    public Body(int w, int p) {
        this.w = w;
        this.p = p;
    }

    public Body(int id, int w, int p) {
        this.id = id;
        this.w = w;
        this.p = p;
    }

}
