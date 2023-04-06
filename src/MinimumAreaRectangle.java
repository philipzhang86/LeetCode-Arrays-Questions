import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class MinimumAreaRectangle {
    public static int minimumAreaRectangle(int[][] points) {
        // Write your code here.
        //将二维数组的元素通通存到一个complicated Map里，然后通过每个顶点，去loop遍其对应的坐标
        HashMap<Integer, Set<Integer>> hashMap = new HashMap<>();
        for(int[] p : points){
            hashMap.computeIfAbsent(p[0], k-> new HashSet<>());
            hashMap.get(p[0]).add(p[1]);
        }

        int area = Integer.MAX_VALUE;
        for(int i = 0; i<points.length; i++){
            for(int j = i+1; j< points.length; j++){
                int x1 = points[i][0];//这保证了4点的存在
                int y1 = points[i][1];
                int x2 = points[j][0];
                int y2 = points[j][1];
        /*当两点 x1 != x2 & y1 != y2 这样可以构成一条对角线，有了这条对角线，我们可以构造另一条与之交叉的对角线
          x1y1, x2y1,       x1=x2 构成一条垂直线    水平线是可以构成矩形，但不适合本解法
          x1y2, x2y2,       y1=y2 构成一条水平线    我们要找交叉线，∴ x1 != x2 & y1 != y2 */
                if(x1 != x2 && y1 != y2){//条件 1
                    //条件 2   x1映射的y坐标中找到 y2     x2映射的y坐标中找到 y2
                    if(hashMap.get(x1).contains(y2) && hashMap.get(x2).contains(y1)){
                        //条件1、条件2 同时满足，即是要找的矩形
                        area = Math.min(area, Math.abs(x1-x2) *Math.abs(y1-y2));
                    }
                }
            }
        }
        return area == Integer.MAX_VALUE ? 0 : area;
    }

    public static void main(String[] args) {
        int[][] array = {{1,1},{1,3},{3,1},{3,3},{2,2}};
        System.out.println(minimumAreaRectangle(array));

        int x = 13; //1101
        int y = 7;  //111
        //00000000 00000000 00000000 00001101       13 binary representation
        //00000000 00000000 00000000 00000111        7 binary representation
        //00000000 00000000 00000000 00001010        10 binary representation  ^ 计算结果

        System.out.println(x ^ y);//10    ^ XOR
    }
}
