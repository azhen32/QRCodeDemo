package cc.az.zxing;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.imageio.ImageIO;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;


public class ReadQRCode {
	public static void main(String[] args) throws Exception {
		try {
			//创建多格式读取器
			MultiFormatReader formatReader = new MultiFormatReader();
			//指定二维码图片位置
			File file = new File("/home/azhen/qrcode.png");
			//读取图片
			BufferedImage image = ImageIO.read(file);
			
			BinaryBitmap binaryBitmap = new BinaryBitmap(new HybridBinarizer(new BufferedImageLuminanceSource(image))); 
			HashMap hints = new HashMap();
			hints.put(EncodeHintType.CHARACTER_SET, "utf-8");	
			
			Result result = formatReader.decode(binaryBitmap,hints);
			
			System.out.println("url:" + result.toString());
			System.out.println("格式:" + result.getBarcodeFormat());
			System.out.println("文本:" + result.getText());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
