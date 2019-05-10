//
//import java.io.File;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.OutputStream;
//import java.net.HttpURLConnection;
//import java.net.URL;
//import java.net.URLConnection;
//
//import org.jsoup.Jsoup;
//import org.jsoup.nodes.Document;
//import org.jsoup.nodes.Element;
//import org.jsoup.select.Elements;
//
//public class JsoupDemo {
//	private static OutputStream os;
// 
//	public static void main(String[] args) {
//		try {
//			String connectionUrl = "http://aiait.aia.com/aiait/";
//			Document doc = getDocument(connectionUrl);
//			//获取页面上的图片保存到本地
//			Elements imgs = doc.select("img[src$=(.png|.jpg)]");
//			for (Element element : imgs) {
//				String img = element.attr("src");
//				String url = connectionUrl + img;
//				
//				url = url.replace(" ", "%20"); 
//				
//				URL u = new URL(String.valueOf(url));
//				URLConnection uc = u.openConnection();
//				HttpURLConnection httpURLConnection = (HttpURLConnection)uc;
//				System.out.println("网址 ： " + url + "  ========  返回状态码 ：  " +  httpURLConnection.getResponseCode());
//		        //获取数据流
//		        InputStream is = uc.getInputStream();
//		        //获取后缀名
//		        String imageName = img.substring(img.lastIndexOf("/") + 1,img.length());
//		        
//		        File file = new File("D:\\jsoup\\img");
//		        if(!file.exists() || !file.isDirectory()) {
//		        	file.mkdirs();
//		        }
//		        
//		        //写入本地
//		        os = new FileOutputStream(new File("D:\\jsoup\\img", imageName));
//		        byte[] b = new byte[1024];
//		        int i=0;
//		        while((i=is.read(b))!=-1){
//		          os.write(b, 0, i);
//		        }
//		        is.close();
//		        os.flush();
//		        os.close();
//			}
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
//	
//	private static Document getDocument(String url) {
//        Document doc = null;
//        boolean flag = true;
//            while (flag) {
//            try {
//                doc = Jsoup.connect(url).timeout(50000).userAgent("Mozilla/4.0 (compatible; MSIE 9.0; Windows NT 5.0)").get();
//                flag = false;
//            } catch (IOException e) {
//            	e.printStackTrace();
//            }
//        }
//        return doc;
//    }
//}
