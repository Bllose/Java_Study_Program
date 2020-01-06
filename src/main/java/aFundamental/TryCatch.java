package aFundamental;

/**
 * <pre>
 *
 * </pre>
 *
 * @Author Bllose
 * @Date 2019/12/29 23:48
 */
public class TryCatch {

    public static void main(String[] args) {
        System.out.println(fun());
    }

    /*
     * @Author Bllose
     * @Date 2019/12/29 23:58
     *
     * catch 在return时依然会执行finally
     */
    public static int fun(){
        int i = 0;
        try{
            throw new Exception("");
        }catch (Exception e){
            i = 30;
            return i;
        }finally {
            i = 40;
            return i;
        }
    }

}
