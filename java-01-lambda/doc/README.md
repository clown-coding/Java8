# ***Lambda表达式***

## **什么是Lambda表达式**
   * Lambda是一个匿名函数,我们可以将Lambda表达式理解为一段可以传递的代码(将代码像数据一样传递)
   * 可以写出更简洁,更灵活的代码
   * 作为一种紧凑的代码风格,使Java语言的表达能力得到提升
## **Java8其他函数式接口**



| 函数式接口  |参数类型|返回类型|用途|
|---|---|---|---|
| BiFunction<T, U, R>  |T,U|R|对类型为 T, U 参数应用操作，返回 R 类型的结果。包含方法为R apply(T t, U u);|
|UnaryOperator<T>(Function子接口) |T|T|对类型为T的对象进行一元运算，并返回T类型的结果。包含方法为T apply(T t);|
| BinaryOperator<T>(BiFunction 子接口) |T,T|T|对类型为T的对象进行二元运算，并返回T类型的结果。包含方法为T apply(T t1, T t2);|
|BiConsumer<T, U>  |T,U|void|对类型为T, U 参数应用操作。包含方法为void accept(T t, U u)|
| ToIntFunction<T> |T|int|计算int值得函数|
| ToLongFunction<T> |T|long|计算long值得函数|
| ToDoubleFunction<T> |T|double|计算long值得函数|
| IntFunction<R> |int|R|参数是int类型的函数|
| LongFunction<R> |long|R|参数是long类型的函数|
| DoubleFunction<R> |double|R|参数是long类型的函数|

