
import java.io.File;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

public class DemoTest {
    public static void main(String[] args) throws DocumentException
    {
        SAXReader reader = new SAXReader();
        Document document = reader.read(new File("./src/scrt.xml"));
        
        //获取根节点
        Element root = document.getRootElement();
        //输出根标签的名字
       // System.out.println(root.getName());
        
        
//        //获取根节点下面的所有子节点（不包过子节点的子节点）
//        List<Element> list = root.elements() ;
//        //打印所有子节点的名字
//        for (Element e:list){
//            System.out.println(e.getName());
//        }
                
//      
        //模拟获取Insert_into_WLMPRD的数据
        testWLMPRD(root);
    
    }

	private static void testWLMPRD(Element element) {
		 List<Element> productNodes = getChildrenNode(element,"product");
	        for (Element node : productNodes) {
	        	System.out.println(getChildText(element,"unique-request-id"));
				System.out.println(getChildText(node,"product-name"));
				System.out.println(getChildText(node,"product-id"));
				System.out.println(getChildText(node,"tool-msu"));
				System.out.println(getChildText(node,"customer-msu"));
				System.out.println(getChildText(element,"unique-request-id"));
				System.out.println("----------------------------------------------------------");
			}
		
	}
	private static String getChildText(Element parent, String childName){
		return parent.element(childName)!=null?parent.element(childName).getText().trim():null;
	}
	private static List<Element> getChildrenNode(Element parent, String childName){
		return parent.elements(childName)!=null?parent.elements(childName):null;
			
		
	}
}