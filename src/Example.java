
public class Example{
    String str=new String("tarena");
    char[]ch={'a','b','c'};
    public static void main(String args[]){
        Example ex=new Example();
        ex.change(ex.str,ex.ch);
        System.out.print(ex.str+" and ");
        System.out.print(ex.ch);
    }
    public void change(String str,char ch[]){
   //�������ͱ��������ݵ��ǵ�ַ���������ô��ݡ�
        str="test ok";
        System.out.println();
        ch[0]='g';
        
    }
}