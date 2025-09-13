import java.util.*;

public class Base64 {

  public static Map<Integer, Character> getBase64Map() {
    String base64Chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";
    Map<Integer, Character> map = new HashMap<>();

    for (int i = 0; i < base64Chars.length(); i++) {
      map.put(i, base64Chars.charAt(i));
    }

    return map;
  }

  public String toBase64(String s){
    HashMap<Integer, Character> map = (HashMap<Integer, Character>) getBase64Map();
    StringBuilder sb = new StringBuilder();
    byte[] ar = s.getBytes();
    int i = 0;
    while(i < ar.length){
      int a = ar[i++] & 0xFF;
      int b = -1;
      int c = -1;
      if(i < ar.length){
        b = ar[i++] & 0xFF;
      }
      if(i < ar.length){
        c = ar[i++] & 0xFF;
      }
      int tot = (a);
      tot <<= 16;
      if(b != -1){
        tot |= (b) << 8;
      }
      if(c != -1){
        tot |= (c);
      }

      int s1 = (tot >> 18) & 63;
      int s2 = (tot >> 12) & 63;
      int s3 = (tot >> 6) & 63;
      int s4 = (tot) & 63;

      sb.append(map.get(s1));
      sb.append(map.get(s2));
      if(b == -1){
        sb.append("==");
      }
      else if(c == -1){
        sb.append(map.get(s3));
        sb.append('=');
      }
      else{
      sb.append(map.get(s3));
      sb.append(map.get(s4));
      }
    }
    return sb.toString();
  }

  public static void main(String[] args) {
    Base64 b = new Base64();
    System.out.println(b.toBase64("Hello, World!"));
  }  
}
