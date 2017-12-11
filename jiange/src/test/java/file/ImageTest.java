package file;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;

public class ImageTest {

	public static void main(String[] args) {
		Image[] images = new Image[10];
		for (int i = 0; i < images.length; i++) {
			images[i] = new Image() {
				
				@Override
				public int getWidth(ImageObserver observer) {
					// TODO Auto-generated method stub
					return 0;
				}
				
				@Override
				public ImageProducer getSource() {
					// TODO Auto-generated method stub
					return null;
				}
				
				@Override
				public Object getProperty(String name, ImageObserver observer) {
					// TODO Auto-generated method stub
					return null;
				}
				
				@Override
				public int getHeight(ImageObserver observer) {
					// TODO Auto-generated method stub
					return 0;
				}
				
				@Override
				public Graphics getGraphics() {
					// TODO Auto-generated method stub
					return null;
				}
			};
		}
	}

}
