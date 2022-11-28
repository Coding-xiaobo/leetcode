```java
//反转整数
public int reverse(int x) {
    int res = 0;
    while(x != 0) {
        //取出最后一位
        int t = x % 10;
        //除10
        x = x / 10;
        //结果乘10加上最后那一位
        res = res * 10 + t;
    }
    return res;
}
```