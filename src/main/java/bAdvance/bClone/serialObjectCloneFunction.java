package bAdvance.bClone;

import java.io.*;

/**
 * <pre>
 *     通过oos序列化对象
 *      通过ois反序列化获取对象
 *
 *      克隆对象的方法包含两种
 *      1、使用object中的 clone
 *      2、通过serializable
 *
 *      两种方法各有利弊
 *      1、clone可以实现顶层类实例化，然后克隆一个完整的、深层次的对象。
 *      2、serializable可以克隆整个对象中所有serializable部分。
 *
 *      1、clone在编写对象时，所有对象都需要implements cloneable，同时父类需要实现clone方法，主动克隆需要复制的对象
 *      2、serializable需要从一个已经实例化过的对象中复制
 * </pre>
 *
 * @Author Bllose
 * @Date 2019/12/29 18:40
 */
public class serialObjectCloneFunction {

    private serialObjectCloneFunction() {
        throw new AssertionError("我坚信，该方法不应该被实例化~");
    }

    @SuppressWarnings("unchecked")
    public static <T extends Serializable> T clone(T obj) throws Exception {

        ByteArrayOutputStream bout = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bout);
        oos.writeObject(obj);

        ByteArrayInputStream bin = new ByteArrayInputStream(bout.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bin);
        return (T) ois.readObject();

        // 说明：调用ByteArrayInputStream或ByteArrayOutputStream对象的close方法没有
        // 任何意义
        // 这两个基于内存的流只要垃圾回收器清理对象就能够释放资源，这一点不同于对外部资源
        // （如文件流）的释放
    }
}
