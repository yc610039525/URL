import java.net.*;
import java.io.*;

import com.sun.org.apache.xml.internal.security.exceptions.Base64DecodingException;
import com.sun.org.apache.xml.internal.security.utils.Base64;
public class HttpClient1 {
  public static void main(String args[])throws IOException, Base64DecodingException{
//    URL url=new URL("http://www.javathinker.org/hello.htm");
    URL url=new URL("http://www.baidu.com");
       
    //接收响应结果
    InputStream in=url.openStream();
//    ByteArrayOutputStream buffer=new ByteArrayOutputStream();
    
    InputStreamReader  bw = new InputStreamReader(in, "UTF-8");
    char[] cbuf=new char[256];  
    int len=-1;
    CharArrayWriter buffer=new CharArrayWriter();
    while((len=bw.read(cbuf))!=-1){
      buffer.write(cbuf,0,len);
    }
     
//    System.out.println(new String(buffer.toByteArray()));  //把字节数组转换为字符串
    String responseStr = new String(buffer.toCharArray());
//    System.out.println(responseStr);  //把字节数组转换为字符串
    byte[] bytes = responseStr.getBytes();
//    System.out.println(Base64.encode(bytes));
    System.out.println(new String(Base64.decode(Base64.encode(bytes).getBytes())));
    
  } 
  
}


/****************************************************
 * 作者：孙卫琴                                     *
 * 来源：<<Java网络编程精解>>                       *
 * 技术支持网址：www.javathinker.org                *
 ***************************************************/
